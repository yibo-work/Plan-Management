package com.clrvn.classroom.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
  
  private static final long serialVersionUID = 4L;
  
  private Integer id;
  
  private String userNo;
  
  private String name;
  
  private String password;
  
  private Integer role;
  
  public User() {
    super();
  }
  
}
