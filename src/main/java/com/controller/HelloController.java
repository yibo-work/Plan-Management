package com.controller;

import com.pojo.User;
import org.springframework.stereotype.Controller;
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
    public String index(HttpSession session) {
        //默认，不用登录
        User user = new User();
        user.setName("chen");
        user.setPassword("123qwe");
        session.setAttribute("USER", user);
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/propManage")
    public String propManage() {
        return "propManage";
    }

    @GetMapping("/customerUpdate")
    public String customerUpdate() {
        return "propUpdate";
    }

    @GetMapping("/customerAdd")
    public String customerAdd() {
        return "propAdd";
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
     * 属性管理
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
