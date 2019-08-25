package com.getnovel.user.controller;

import com.getnovel.common.NovelProperties;
import com.getnovel.common.annotation.SecurityParameter;
import com.getnovel.user.pojo.User;
import com.getnovel.user.serviceImpl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * *
 */
@RestController
@ResponseBody
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private NovelProperties novelproperties;
//    @Value("${encrypt.body.aes-key}")
//    private String AES_KEY;
    /**
     * ASE加密
     * AES_KEY 密钥
     * AES_IV 密钥偏移
     * @return
     */
    @RequestMapping(value = "/secret",method = RequestMethod.GET)
    public List<String> returnSecret(){
        List list = new ArrayList();
       // System.out.println(Constants.AES_KEY);
        String AES_KEY  = novelproperties.getAesKey();
        if (StringUtils.isEmpty(AES_KEY)){
            logger.error("AES_KEY配置读取出错，出错方法：novelproperties.getAesKey()");
            return null;
        }else {
        String AES_IV = new StringBuffer(AES_KEY).reverse().toString();
        list.add(AES_KEY);
        list.add(AES_IV);
        return list;
        }
    }
    /**
     * 用户注册接口
     */
    @SecurityParameter
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public Object add(@RequestBody User user){
        System.out.println(user);
        userService.add(user);
        Map<String,Object> result = new HashMap<>();
        result.put("status","ok");
        return result;
    }
    @RequestMapping(value = "/user" ,method =RequestMethod.PUT)
    public void resetPassword(@RequestBody  User user){
        System.out.println(user + "test");
    }
    /**
     * 登陆密码验证
     * 生成token
     * @param user
     * @return
     */
    @SecurityParameter
    @RequestMapping(value = "/OAuth" ,method =RequestMethod.POST)
    public Object login( @RequestBody  User user){
        Map<String,Object> result = new HashMap<>();
        String token=null;
        if(StringUtils.isEmpty(user.getAccount())){
            result.put("accountErr","*请输入用户名");
        }else if (StringUtils.isEmpty(user.getPassword())){
            result.put("passwordErr","*请输入密码");
        }else {
            User u= userService.selectByAccountAndPassword(user);
            if (null == u){
                result.put("msg","账号不存在或者密码错误");
            }else if (null != u){
                token = userService.login(u);
            }
            if (token == null){
                // token 生成失败 登陆失败
                result.put("msg","服务器错误，请稍后重新登陆");
            }else {
                //登陆成功
                result.put("status",true);
                result.put("user_id",u.getUserId());
                result.put("token",token);
            }
        }
        return result;
    }

}
