package com.service;

import com.pojo.User;

import java.util.List;


public interface IUserService {
    
    User login(User user);
    
    List<User> getAllTeacher();
}
