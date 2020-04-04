package com.service;

import com.pojo.Role;
import com.pojo.User;
import com.vo.UserVO;
import org.springframework.stereotype.Service;


public interface IUserService {

    UserVO login(User user);

    void modifyUser(User user);

    void addUser(User user);

    void updateRole(Role role);

    void deleteUserById(Integer id);

}
