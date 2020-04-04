package com.controller;

import com.github.pagehelper.PageInfo;
import com.pojo.Role;
import com.service.IRoleService;
import com.utils.ResultVOUtil;
import com.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/updateRole")
    public ResultVO updateRole(@RequestBody Role role) {
        roleService.updateRole(role);
        return ResultVOUtil.success();
    }

    @RequestMapping("/getRoleList")
    public ResultVO getRoleList() {
        return ResultVOUtil.success(roleService.getRoleList());
    }

    @RequestMapping("/getRole")
    public ResultVO modifyRole(@RequestParam(value = "roleId") Integer roleId) {
        Role role = roleService.getRoleById(roleId);
        return ResultVOUtil.success(role);
    }

    @GetMapping("/page")
    public PageInfo<Role> queryAllPlan(@RequestParam("pageNum") Integer pageNum
            , @RequestParam("pageSize") Integer pageSize) {
        return roleService.queryRolePage(pageNum, pageSize);
    }
}
