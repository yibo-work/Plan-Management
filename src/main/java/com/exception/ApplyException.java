package com.exception;

import com.enums.ResultFailureEnum;

public class ApplyException extends RuntimeException {

    private Integer code;

    public ApplyException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ApplyException(ResultFailureEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
