package com.getnovel.user.dao;

import com.getnovel.user.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public void add(User user);
    public int selectByAccount(String account);
    public User selectByAccountAndPassword(@Param("account") String account,@Param("password") String password);
}
