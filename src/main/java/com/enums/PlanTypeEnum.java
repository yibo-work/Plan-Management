package com.enums;

import lombok.Getter;

/**
 * @author Clrvn
 */
@Getter
public enum PlanTypeEnum {
    /**
     * 计划类型分四种
     */
    WEEK(1, "周计划"),
    MONTH(2, "月计划"),
    QUARTER(3, "季度计划"),
    YEAR(4, "年计划"),
    ;

    private Integer typeId;

    private String typeName;

    PlanTypeEnum(Integer typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }
}
