package com.service;

import com.github.pagehelper.PageInfo;
import com.pojo.Role;
import com.pojo.User;
import com.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IUserService {

    UserVO login(User user);

    void modifyUser(User user);

    void addUser(User user);

    void updateRole(Role role);

    void deleteUserById(Integer id);

    List<User> getUserList();

    PageInfo<User> queryUserList(Integer pageNum, Integer pageSize);

    User getUserById(Integer userId);
}
