package com.getnovel.user.serviceImpl;


import com.getnovel.user.dao.UserDao;
import com.getnovel.user.pojo.User;
import com.getnovel.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getnovel.utils.JwtUtils;

@Service("UserService")
public class UserServiceImpl  implements UserService{
    @Autowired
    private UserDao dao;
    @Override
    public void add(User user) {
          dao.add(user);
    }
    @Override
    public User selectByAccountAndPassword(User user){
        User u = dao.selectByAccountAndPassword(user.getAccount(),user.getPassword());
        return u;
    }
    @Override
    public String login(User u) {
        String token = JwtUtils.generateToken(u);
        return token;
    }
}
