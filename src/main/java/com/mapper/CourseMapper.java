package com.mapper;

import com.pojo.Course;
import com.vo.CourseVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository

public interface CourseMapper {
    
    List<CourseVO> queryCourseList(@Param("name") String name);
    
    int addCourse(@Param("course") Course course);
    
    Course getCourseById(@Param("id") Integer id);
    
    List<Course> getCourseByClassroomAndTime(@Param("classroomId") Integer classroomId, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
    
    List<Course> getCourseByBeginTimeAndEndTime(@Param("classroomId") Integer classroomId, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
    
    int updateCourse(@Param("course") Course course);
    
    int removeCourseById(@Param("id") Integer id);
}
