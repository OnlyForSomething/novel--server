package com.getnovel.utils;

import com.getnovel.common.NovelProperties;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

@Service
public class AesDecryptUtils {
//    @Value("${encrypt.body.aes-key}")
//    private static String AES_KEY = "ZGIyYzlmZTA2OA==";
//    private static final String AES_IV = "==AO2ATZmlzYyIGZ";
    @Autowired
    private NovelProperties novelproperties;
    //参数分别代表 算法名称/解密模式/数据填充方式
    private static final String ALGORITHMSTR = "AES/CBC/PKCS7Padding";
    /**
     * 解密
     * @param decryptStr 解密的字符串
     * @param decryptKey 解密的key值
     * @return
     * @throws Exception
     */
    public  String decrypt(String decryptStr, String decryptKey,String decryptIv) throws Exception {
        /**
         * 这个地方调用BouncyCastleProvider
         *让java支持PKCS7Padding
         */
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        try{
            byte[] key = decryptKey.getBytes("utf-8");
            IvParameterSpec iv = new IvParameterSpec(decryptIv.getBytes());
            Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
            cipher.init(Cipher.DECRYPT_MODE,new SecretKeySpec(key,"AES"),iv);
            byte[] encrypted = Base64.decodeBase64(decryptStr);
            System.out.println(encrypted);
            try {
                byte[] original = cipher.doFinal(encrypted);
                String originalString = new String(original);
                return originalString;
            }catch (Exception e){
                System.out.println(e);
                return  null;
            }
        }catch (Exception e){
             System.out.println(e);
             return  null;
        }
    }
    public  String decrypt(String decryptStr) throws Exception {
      //  return decrypt(decryptStr,AES_KEY,AES_IV);
        return decrypt(decryptStr,novelproperties.getAesKey(),new StringBuffer(novelproperties.getAesKey()).reverse().toString());
    }

}
