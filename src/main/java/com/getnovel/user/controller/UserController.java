package com.getnovel.user.controller;

import com.getnovel.user.pojo.User;
import com.getnovel.user.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * *
 */
@RestController
@ResponseBody
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public void add(User user){
        userService.add(user);
    }

    /**
     * 登陆密码验证
     * 生成token
     * @param user
     * @return
     */
    @RequestMapping(value = "/OAuth" ,method =RequestMethod.POST)
    public Object login( @RequestBody  User user){
        Map<String,Object> result = new HashMap<>();
        if(StringUtils.isEmpty(user.getAccount())){
            result.put("status",false);
            result.put("accountErr","*请输入用户名");
        }else if (StringUtils.isEmpty(user.getPassword())){
            result.put("status",false);
            result.put("passwordErr","*请输入密码");
        } else {
            String token = userService.login(user);
            if (token == null){
                // token 生成失败 登陆失败
                result.put("status",false);
                result.put("msg","服务器错误，请稍后重新登陆");
            }else if(token.equals("paswordErr")){
                result.put("status",false);
                result.put("msg","账号不存在或者密码错误");
            }else {
                //登陆成功
                result.put("status",true);
                result.put("token",token);
            }
        }
        return result;
    }
    @RequestMapping(value = "/user" ,method =RequestMethod.PUT)
    public void resetPassword(@RequestBody  User user){
        System.out.println(user + "test");
    }
}
