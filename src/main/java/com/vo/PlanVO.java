package com.vo;

import com.pojo.Customer;
import com.pojo.Plan;
import com.pojo.User;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Clrvn
 */
@Data
public class PlanVO implements Serializable {
    private static final long serialVersionUID = 3462341L;

    private Plan plan;

    private Customer customer;

    private User user;
}