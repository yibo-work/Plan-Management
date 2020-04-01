package com.clrvn.classroom.service.impl;

import com.classroom.mapper.CourseMapper;
import com.classroom.pojo.Course;
import com.classroom.service.ICourseService;
import com.classroom.vo.CourseVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {
    
    @Autowired
    private CourseMapper courseMapper;
    
    @Override
    public PageInfo<CourseVO> queryCourseList(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(courseMapper.queryCourseList(name));
    }
    
    @Override
    @Transactional
    public int addCourse(Course course) {
        return courseMapper.addCourse(course);
    }
    
    @Override
    public Course getCourseById(Integer id) {
        return courseMapper.getCourseById(id);
    }
    
    @Override
    public List<Course> getCourseByClassroomAndTime(Integer classroomId, Date beginTime, Date endTime) {
        return courseMapper.getCourseByClassroomAndTime(classroomId, beginTime, endTime);
    }
    
    @Override
    @Transactional
    public int updateCourse(Course course) {
        return courseMapper.updateCourse(course);
    }
    
    @Override
    @Transactional
    public int removeCourseById(Integer id) {
        return courseMapper.removeCourseById(id);
    }
}
