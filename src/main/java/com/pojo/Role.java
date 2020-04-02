package com.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Clrvn
 * 角色
 */
@Data
public class Role implements Serializable {

    private static final long serialVersionUID = 1234L;

    private Integer id;

    private String name;

    private String auths;
}
