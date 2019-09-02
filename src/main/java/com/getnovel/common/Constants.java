package com.getnovel.common;

import org.springframework.stereotype.Component;


/**
 * @author
 * 常量定义
 */
@Component
public class Constants {
//    @Autowired
//    private static NovelProperties novelProperties;
//
//    public static final String AES_KEY = novelProperties.getAesKey();
//    public static final String AES_IV = new StringBuffer(Constants.AES_KEY).reverse().toString();
    /**
     * 邮箱格式正则
     */
    public static final String emailRegexp ="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
    /**
     * 手机号格式正则
     */
    public static  final String phoneRegexp ="^1[345678]\\d{9}$";
}
