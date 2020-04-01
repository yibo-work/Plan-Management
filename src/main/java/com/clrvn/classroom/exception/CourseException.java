package com.clrvn.classroom.exception;

import com.classroom.enums.ResultFailureEnum;

public class CourseException extends RuntimeException {

    private Integer code;

    public CourseException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public CourseException(ResultFailureEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
