package com.clrvn.classroom.vo;

import com.classroom.pojo.Classroom;
import com.classroom.pojo.Course;
import lombok.Data;

import java.util.List;

/**
 * @author Clrvn
 * @description
 * @className ClassroomVO
 * @date 2019-05-24 10:56
 */
@Data
public class ClassroomCourseVO {
    
    private Integer classroomId;
    
    private List<Course> courseList;
    
    private Classroom classroom;
    
}
