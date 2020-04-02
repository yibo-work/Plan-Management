package com.service.impl;

import com.mapper.UserMapper;
import com.pojo.Role;
import com.pojo.User;
import com.service.IUserService;
import com.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserVO login(User user) {
        return userMapper.login(user);
    }

    @Override
    public void modifyUser(User user) {
        userMapper.modifyUser(user);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void updateRole(Role role) {
        userMapper.updateRole(role);
    }

    @Override
    public void deleteUserById(Integer id) {
        userMapper.deleteUserById(id);
    }

}
