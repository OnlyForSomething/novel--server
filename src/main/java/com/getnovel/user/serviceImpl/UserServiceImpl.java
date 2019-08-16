package com.getnovel.user.serviceImpl;


import com.getnovel.user.dao.UserDao;
import com.getnovel.user.pojo.User;
import com.getnovel.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.JwtUtils;

@Service("UserService")
public class UserServiceImpl  implements UserService{
    @Autowired
    private UserDao dao;
    public void add(User user) {
          dao.add(user);
    }

    @Override
    public String login(User user) {
        User u = dao.selectByAccountAndPassword(user.getAccount(),user.getPassword());
        System.out.println(u);
        if(u == null){
            return "paswordErr";
        }
        String token = JwtUtils.generateToken(u);
        return token;
    }
}
