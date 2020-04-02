package com.controller;

import com.enums.PlanTypeEnum;
import com.pojo.Role;
import com.pojo.User;
import com.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @author Clrvn
 */
@Controller
public class HelloController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("loginOut")
    public String loginOut(HttpSession session) {
        session.removeAttribute("USER");
        session.invalidate();
        session.getServletContext().removeAttribute(session.getId());
        return "login";
    }

    @GetMapping("/index")
    public String index(HttpSession session, Model model) {
        //默认，不用登录
        UserVO user2 = new UserVO();
        User user = new User();
        user.setId(3);
        user.setName("chen");
        user.setPassword("123qwe");
        user.setRoleId(4);

        user2.setUser(user);
        Role role = new Role();
        role.setId(1);
        role.setName("管理员");
        role.setAuths("计划执行,计划查询,计划定制,计划管理,客户信息管理,无计划客户查询,后台管理");

        user2.setRole(role);

        session.setAttribute("PLAN_TYPE", PlanTypeEnum.values());
        // 测试时取消前三行，加上后三行注释

        session.setAttribute("USER", user2);
        model.addAttribute("auths", user2.getRole().getAuths());
        return "index";


//        UserVO userVo = (UserVO) session.getAttribute("USER");
//        model.addAttribute("auths", userVo.getRole().getAuths());
//        return "index";


    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/classroomList")
    public String queryAll() {
        return "classroomList";
    }

    @GetMapping("/applyAdd")
    public String applyAdd() {
        return "applyAdd";
    }

    @GetMapping("/applyList")
    public String applyList() {
        return "applyList";
    }

    @GetMapping("/applyHistoryList")
    public String applyHistoryList() {
        return "applyHistoryList";
    }

    @GetMapping("/classroomManage")
    public String classroomManage() {
        return "classroomManage";
    }

    @GetMapping("/classroomAdd")
    public String classroomAdd() {
        return "classroomAdd";
    }

    @GetMapping("/classroomUpdate")
    public String classroomUpdate() {
        return "classroomUpdate";
    }

    @GetMapping("/courseManage")
    public String courseManage() {
        return "courseManage";
    }

    @GetMapping("/courseAdd")
    public String courseAdd() {
        return "courseAdd";
    }

    @GetMapping("/courseUpdate")
    public String courseUpdate() {
        return "courseUpdate";
    }

    @GetMapping("/auditList")
    public String auditList() {
        return "auditList";
    }

    @GetMapping("/classroomTimeList")
    public String classroomTimeList() {
        return "classroomTimeList";
    }

}
