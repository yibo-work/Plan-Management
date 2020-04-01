package com.clrvn.classroom.service.impl;

import com.classroom.mapper.UserMapper;
import com.classroom.pojo.User;
import com.classroom.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements IUserService {
    
    @Autowired
    private UserMapper userMapper;
    
    public User login(User user) {
        return userMapper.login(user);
    }
    
    @Override
    public List<User> getAllTeacher() {
        return userMapper.getAllTeacher();
    }
}
