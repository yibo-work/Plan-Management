package com.clrvn.classroom.mapper;

import com.classroom.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    
    User login(@Param("user") User user);
    
    List<User> getAllTeacher();
}
