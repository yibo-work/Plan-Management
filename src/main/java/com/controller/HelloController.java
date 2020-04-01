package com.controller;

import com.enums.ClassroomAuditEnum;
import com.enums.ClassroomTypeEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Clrvn
 * @description
 * @className HelloController
 * @date 2019-05-16 21:54
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
        /*User user1 = new User();
        user1.setId(1);
        user1.setUserNo("wang");
        user1.setName("小王");
        user1.setPassword("46f94c8de14fb36680850768ff1b7f2a");
        user1.setRole(UserRoleConstant.ROLE_STUDENT);
        
        User user2 = new User();
        user2.setId(3);
        user2.setUserNo("chen");
        user2.setName("老陈");
        user2.setPassword("46f94c8de14fb36680850768ff1b7f2a");
        user2.setRole(UserRoleConstant.ROLE_TEACHER);*/
        
        //教室类型枚举列表
        List<ClassroomTypeEnum> classroomTypeEnumList = new ArrayList<>();
        
        classroomTypeEnumList.add(ClassroomTypeEnum.CLASSROOM_TEACHER);
        classroomTypeEnumList.add(ClassroomTypeEnum.CLASSROOM_LAB);
        
        //审批类型枚举列表
        List<ClassroomAuditEnum> classroomAuditEnumList = new ArrayList<>();
        
        classroomAuditEnumList.add(ClassroomAuditEnum.CLASSROOM_AUDIT_PASS);
        classroomAuditEnumList.add(ClassroomAuditEnum.CLASSROOM_AUDIT_NOT_PASS);

//        session.setAttribute("USER", user2);
        session.setAttribute("CLASSROOM", classroomTypeEnumList);
        session.setAttribute("AUDIT", classroomAuditEnumList);
        
        return "index";
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
