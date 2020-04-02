package com.pojo;


import lombok.Data;

import java.io.Serializable;

/**
 * @author Clrvn
 * 客户
 */
@Data
public class Customer implements Serializable {

    private Integer id;
    private String companyName;
    private String man;
    private String phone;
    private String address;
    private Integer planFlag;
}
