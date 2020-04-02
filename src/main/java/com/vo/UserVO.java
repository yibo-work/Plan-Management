package com.vo;

import com.pojo.Role;
import com.pojo.User;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Clrvn
 */
@Data
public class UserVO  implements Serializable {
    private static final long serialVersionUID = 41245L;
    private User user;

    private Role role;

}
