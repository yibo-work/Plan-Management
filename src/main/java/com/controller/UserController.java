package com.controller;

import com.enums.ResultFailureEnum;
import com.github.pagehelper.PageInfo;
import com.pojo.Role;
import com.pojo.User;
import com.service.IUserService;
import com.utils.ResultVOUtil;
import com.vo.ResultVO;
import com.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public ResultVO login(@RequestBody User loginUser, HttpSession session) {
        //MD5转码
//        loginUser.setPassword(AppMD5Util.getMD5(loginUser.getPassword()));//你把这行删掉，然后数据库的密码都改为123qwe
        //这样就不会有问题了
        UserVO user = userService.login(loginUser);
        if (user != null) {
            session.setAttribute("USER", user);
            return ResultVOUtil.success();
        } else {
            return ResultVOUtil.failure(ResultFailureEnum.LOGIN_ERROR);
        }

    }

    @RequestMapping("/loginOut")
    public void loginOut(HttpSession session) {
        session.removeAttribute("USER");
        session.invalidate();
    }

    @GetMapping("/page")
    public PageInfo<User> queryAllPlan(@RequestParam("pageNum") Integer pageNum
            , @RequestParam("pageSize") Integer pageSize
    ) {
        return userService.queryUserList(pageNum, pageSize);
    }

    @RequestMapping("/getUser")
    public ResultVO modifyUser(@RequestParam(value = "userId") Integer userId) {
        User user = userService.getUserById(userId);
        return ResultVOUtil.success(user);
    }

    @RequestMapping("/updateUser")
    public ResultVO modifyUser(@RequestBody User user) {
        userService.modifyUser(user);
        return ResultVOUtil.success();
    }

    @RequestMapping("/addUser")
    public ResultVO addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResultVOUtil.success();
    }

    @RequestMapping("/updateRole")
    public ResultVO updateRole(@RequestBody Role role) {
        userService.updateRole(role);
        return ResultVOUtil.success();
    }

    @RequestMapping("/removeUser")
    public ResultVO deleteUserById(@RequestParam(value = "userId") Integer id) {
        userService.deleteUserById(id);
        return ResultVOUtil.success();
    }

    @RequestMapping("/getUserList")
    public ResultVO getUserList() {
        return ResultVOUtil.success(userService.getUserList());
    }

}
