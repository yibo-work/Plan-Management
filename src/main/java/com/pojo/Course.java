package com.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Course implements Serializable{

    private static final long serialVersionUID = 3L;

    private Integer id;

    private String name;

    private Integer userId;

    private Integer classroomId;

    private Date beginTime;

    private Date endTime;

    public Course() {
       super();
    }

}
