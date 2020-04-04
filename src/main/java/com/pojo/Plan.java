package com.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Clrvn
 * 计划
 */
@Data
public class Plan implements Serializable {
    private static final long serialVersionUID = 153664L;
    private Integer id;
    private String companyName;
    private String execTime;
    private String phone;
    private String address;
    private Integer type;
    private Integer rank;
    private Integer status;
    private Integer customerId;
    private Integer userId;

}
