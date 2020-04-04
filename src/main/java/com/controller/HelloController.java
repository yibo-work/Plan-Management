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

        /*session.setAttribute("USER", user2);
        model.addAttribute("auths", user2.getRole().getAuths());
        return "index";*/


        UserVO userVo = (UserVO) session.getAttribute("USER");
        model.addAttribute("auths", userVo.getRole().getAuths());
        return "index";


    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/customerManage")
    public String customerManage() {
        return "customerManage";
    }

    @GetMapping("/customerUpdate")
    public String customerUpdate() {
        return "customerUpdate";
    }

    @GetMapping("/customerAdd")
    public String customerAdd() {
        return "customerAdd";
    }

    /**
     * WEEK
     */
    @GetMapping("/weekPlanManage")
    public String weekPlanManage() {
        return "weekPlanManage";
    }

    @GetMapping("/weekPlanUpdate")
    public String weekPlanUpdate() {
        return "weekPlanUpdate";
    }

    @GetMapping("/weekPlanAdd")
    public String weekPlanAdd() {
        return "weekPlanAdd";
    }

    /**
     * MONTH
     */
    @GetMapping("/monthPlanManage")
    public String monthPlanManage() {
        return "monthPlanManage";
    }

    @GetMapping("/monthPlanUpdate")
    public String monthPlanUpdate() {
        return "monthPlanUpdate";
    }

    @GetMapping("/monthPlanAdd")
    public String monthPlanAdd() {
        return "monthPlanAdd";
    }

    /**
     * QUARTER
     */
    @GetMapping("/quarterPlanManage")
    public String quarterPlanManage() {
        return "quarterPlanManage";
    }

    @GetMapping("/quarterPlanUpdate")
    public String quarterPlanUpdate() {
        return "quarterPlanUpdate";
    }

    @GetMapping("/quarterPlanAdd")
    public String quarterPlanAdd() {
        return "quarterPlanAdd";
    }

    /**
     * YEAR
     */
    @GetMapping("/yearPlanManage")
    public String yearPlanManage() {
        return "yearPlanManage";
    }

    @GetMapping("/yearPlanUpdate")
    public String yearPlanUpdate() {
        return "yearPlanUpdate";
    }

    @GetMapping("/yearPlanAdd")
    public String yearPlanAdd() {
        return "yearPlanAdd";
    }


    /**
     * 计划管理
     */
    @GetMapping("/planManage")
    public String planManage() {
        return "planManage";
    }

    @GetMapping("/planUpdate")
    public String planUpdate() {
        return "planUpdate";
    }

    @GetMapping("/planUpdateRank")
    public String planUpdateRank() {
        return "planUpdateRank";
    }

    /**
     * 计划审批
     */
    @GetMapping("/planApproval")
    public String planApproval() {
        return "planApproval";
    }

    /**
     * 执行计划记录
     */
    @GetMapping("/planPrint")
    public String planPrint() {
        return "planPrint";
    }

    /**
     * 已执行计划查询
     */
    @GetMapping("/planQuery")
    public String planQuery() {
        return "planQuery";
    }

    /**
     * 无计划客户查询
     */
    @GetMapping("/customerNoPlan")
    public String customerNoPlan() {
        return "customerNoPlan";
    }

    /**
     * 用户管理
     */
    @GetMapping("/userManage")
    public String userManage() {
        return "userManage";
    }

    @GetMapping("/userAdd")
    public String userAdd() {
        return "userAdd";
    }

    @GetMapping("/userUpdate")
    public String userUpdate() {
        return "userUpdate";
    }

    /**
     * 角色管理
     */
    @GetMapping("/roleManage")
    public String roleManage() {
        return "roleManage";
    }

    @GetMapping("/roleUpdate")
    public String roleUpdate() {
        return "roleUpdate";
    }
}
