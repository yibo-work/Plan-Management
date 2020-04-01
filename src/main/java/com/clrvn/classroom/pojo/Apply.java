package com.clrvn.classroom.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Apply implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    private Integer classroomId;
    
    private Integer userId;
    
    private Date beginTime;
    
    private Date endTime;
    
    private String reason;
    
    private Integer status;
    
    private Integer showStatus;
    
    
    public Apply() {
        super();
    }
    
}
