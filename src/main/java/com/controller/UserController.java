package com.controller;

import com.enums.ResultFailureEnum;
import com.pojo.User;
import com.service.IUserService;
import com.utils.ResultVOUtil;
import com.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Resource
    private IUserService userService;
    
    @RequestMapping("/login")
    public ResultVO login(@RequestBody User loginUser, HttpSession session) {
        //MD5转码
//        loginUser.setPassword(AppMD5Util.getMD5(loginUser.getPassword()));//你把这行删掉，然后数据库的密码都改为123qwe
                                                                            //这样就不会有问题了
        User user = userService.login(loginUser);
        if (user != null) {
            session.setAttribute("USER", user);
            return ResultVOUtil.success();
        } else {
            return ResultVOUtil.failure(ResultFailureEnum.LOGIN_ERROR);
        }
        
    }
    
    @GetMapping("/getAllTeacher")
    public ResultVO getAllTeacher() {
        return ResultVOUtil.success(userService.getAllTeacher());
    }
    
    
}
