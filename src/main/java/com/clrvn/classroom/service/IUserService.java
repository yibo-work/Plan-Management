package com.clrvn.classroom.service;

import com.classroom.pojo.User;

import java.util.List;


public interface IUserService {
    
    User login(User user);
    
    List<User> getAllTeacher();
}
