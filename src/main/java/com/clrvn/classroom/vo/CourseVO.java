package com.clrvn.classroom.vo;

import com.classroom.pojo.Classroom;
import com.classroom.pojo.Course;
import com.classroom.pojo.User;
import lombok.Data;

/**
 * @author Clrvn
 * @description
 * @className CourseVO
 * @date 2019-05-17 8:21
 */
@Data
public class CourseVO {
    
    private Integer courseId;
    
    private Course course;
    
    private User user;
    
    private Classroom classroom;
    
}
