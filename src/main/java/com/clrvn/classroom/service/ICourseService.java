package com.clrvn.classroom.service;

import com.classroom.pojo.Course;
import com.classroom.vo.CourseVO;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;

public interface ICourseService {
    
    PageInfo<CourseVO> queryCourseList(Integer pageNum, Integer pageSize, String name);
    
    int addCourse(Course course);
    
    Course getCourseById(Integer id);
    
    List<Course> getCourseByClassroomAndTime(Integer classroomId, Date beginTime, Date endTime);
    
    int updateCourse(Course course);
    
    int removeCourseById(Integer id);
}
