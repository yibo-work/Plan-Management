package com.mapper;

import com.pojo.Role;
import com.pojo.User;
import com.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    UserVO login(@Param("user") User user);

    void modifyUser(@Param("user") User user);

    void addUser(@Param("user") User user);

    void updateRole(@Param("role") Role role);

    void deleteUserById(@Param("id") Integer id);

    List<User> getUserList();

    List<User> queryUserList();

    User getUserById(@Param("userId") Integer userId);
}
