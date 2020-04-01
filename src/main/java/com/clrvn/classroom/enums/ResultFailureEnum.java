package com.clrvn.classroom.enums;

import lombok.Getter;

@Getter
public enum ResultFailureEnum {
    LOGIN_ERROR(1, "登录失败"),
    Apply_ERROR(2, "申请失败"),
    CANCEL_Apply_ERROR(3, "撤销申请失败"),
    ADD_CLASSROOM_ERROR(4, "添加教室失败"),
    UPDATE_CLASSROOM_ERROR(5, "修改教室失败"),
    REMOVE_CLASSROOM_ERROR(6, "删除教室失败"),
    ADD_COURSE_ERROR(7, "添加教室失败"),
    UPDATE_COURSE_ERROR(8, "修改教室失败"),
    REMOVE_COURSE_ERROR(9, "删除教室失败"),
    AUDIT_APPLY_ERROR(10, "审批申请失败"),
    CLASSROOM_ARE_OCCUPIED_BY_COURSE(11, "该时间段内教室被课程占用"),
    CLASSROOM_ARE_OCCUPIED_BY_APPLY(12, "该时间段内教室已被申请"),
    DELETE_Apply_ERROR(13, "删除记录失败"),
    ;
    
    private Integer code;
    
    private String msg;
    
    ResultFailureEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
