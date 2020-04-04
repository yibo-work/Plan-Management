package com.service;

import com.github.pagehelper.PageInfo;
import com.pojo.Role;

import java.util.List;

/**
 * @author Clrvn
 */
public interface IRoleService {

    int updateRole(Role role);

    List<Role> getRoleList();

    PageInfo<Role> queryRolePage(Integer pageNum, Integer pageSize);

    Role getRoleById(Integer roleId);
}
