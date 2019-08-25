package com.getnovel.user.service;

import com.getnovel.user.pojo.User;

public interface UserService {
    public void add(User user);
    public User selectByAccountAndPassword(User user);
    public String login(User user);
}

