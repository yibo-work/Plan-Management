package com.clrvn.classroom.vo;

import com.classroom.pojo.Apply;
import com.classroom.pojo.Classroom;
import com.classroom.pojo.User;
import lombok.Data;

/**
 * @author Clrvn
 * @description
 * @className ApplyVO
 * @date 2019-05-17 8:18
 */
@Data
public class ApplyVO {
    
    private Integer applyId;
    
    private User user;
    
    private Classroom classroom;
    
    private Apply apply;
    
}
