package com.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Clrvn
 * 用户
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 4L;

    private Integer id;

    private String name;

    private String password;

    private String phone;

    private Integer roleId;

    public User() {
        super();
    }

}
