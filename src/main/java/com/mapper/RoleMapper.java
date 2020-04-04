package com.mapper;

import com.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper {

    int updateRole(@Param("role") Role role);

    List<Role> getRoleList();

    Role getRoleById(@Param("roleId") Integer roleId);
}