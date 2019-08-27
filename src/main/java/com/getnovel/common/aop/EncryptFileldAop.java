package com.getnovel.common.aop;

import com.getnovel.common.annotation.EncryptField;
import com.getnovel.utils.EncryptUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Objects;


@Aspect
@Component
public class EncryptFileldAop {
    Logger log = LoggerFactory.getLogger(EncryptFileldAop.class);

    /**
     * 切点：被@EncryptMethod标注的方法
     */
    @Pointcut("@annotation(com.getnovel.common.annotation.EncryptMethod)")
    public void annotationPointCut() {
    }
    @Around("annotationPointCut()")
    public void doBefore(ProceedingJoinPoint joinPoint) {
        try {
            //获取到参数值
            Object requestObj = joinPoint.getArgs()[0];
            // 加密
              handleEncrypt(requestObj);
             joinPoint.proceed();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            log.error("SecureFieldAop处理出现异常{}", e);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.error("SecureFieldAop处理出现异常{}", throwable);
        }
    }
    /**
     * 处理加密
     * @param requestObj
     */
    private void handleEncrypt(Object requestObj) throws IllegalAccessException {
        if (Objects.isNull(requestObj)) {
            return;
        }else {
             // 获取到参数的所有字段
            Field[] fields = requestObj.getClass().getDeclaredFields();
            for (Field field : fields) {
                // 是否被@EncryptField注解标注
                boolean hasSecureField = field.isAnnotationPresent(EncryptField.class);
                if (hasSecureField) {
                        // 设置字段可赋值
                        field.setAccessible(true);
                        // 获取当前字段的值
                        String plaintextValue = (String) field.get(requestObj);
                        /* 给当前字段加密 加密后的字符串长度为44 MD5加密后32位 base64编码后长度为
                        * [n/3]*4 n为原字符串长度 []表示向上取整(Math.ceil(n))
                        * */
                        String encryptValue = EncryptUtil.encryptBase64(EncryptUtil.encryptMD5(plaintextValue));
                        // 加密后的值赋值给当前字段
                        field.set(requestObj, encryptValue);
                }
            }
        }
    }

}
