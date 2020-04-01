package com.clrvn.classroom.vo;

import com.classroom.pojo.Apply;
import com.classroom.pojo.Classroom;
import com.classroom.pojo.Course;
import lombok.Data;

/**
 * @author Clrvn
 * @description
 * @className ClassroomVO
 * @date 2019-05-24 10:56
 */
@Data
public class ClassroomVO {
    
    private Integer classroomId;
    
    private Course course;
    
    private Classroom classroom;
    
    private Apply apply;
    
    private long orderTime;
    
}
