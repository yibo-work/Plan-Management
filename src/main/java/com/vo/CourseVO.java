package com.vo;

import com.pojo.Classroom;
import com.pojo.Course;
import com.pojo.User;
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
