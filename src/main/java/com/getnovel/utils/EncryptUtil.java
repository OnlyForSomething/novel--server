package com.getnovel.utils;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class EncryptUtil {
    /**
     * MD5加密
     * @param str
     * @return
     */
    public static String encryptMD5(String str){
        try {
            byte[] bytes=str.getBytes();
            MessageDigest messageDigest=MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            bytes = messageDigest.digest();

            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            //一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
            return new BigInteger(1, bytes).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Base64编码
     * @param str
     * @return
     */
    public static String encryptBase64(String str){
        byte[] bytes=str.getBytes();
        bytes= Base64.getEncoder().encode(bytes);
        return new String(bytes);
    }
}
