package com.clrvn.classroom.enums;

import lombok.Getter;

/**
 * @author Clrvn
 * @description
 * @className ClassroomTypeEnum
 * @date 2019-05-17 14:44
 */
@Getter
public enum ClassroomTypeEnum {
    CLASSROOM_TEACHER(1, "教室"),
    CLASSROOM_LAB(2, "实验室"),
    ;
    
    private Integer typeId;
    
    private String typeName;
    
    ClassroomTypeEnum(Integer typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }
}
