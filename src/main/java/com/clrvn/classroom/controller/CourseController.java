package com.clrvn.classroom.controller;

import com.classroom.enums.ResultFailureEnum;
import com.classroom.exception.CourseException;
import com.classroom.pojo.Course;
import com.classroom.service.ICourseService;
import com.classroom.utils.ResultVOUtil;
import com.classroom.vo.CourseVO;
import com.classroom.vo.ResultVO;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/course")
@Slf4j
public class CourseController {
    
    @Resource
    private ICourseService courseService;
    
    @GetMapping(value = {"/page/{pageNum}/{pageSize}/{name}", "/page/{pageNum}/{pageSize}"})
    @ResponseBody
    public PageInfo<CourseVO> queryAllCourse(@PathVariable Integer pageNum, @PathVariable Integer pageSize,
                                             @PathVariable(value = "name", required = false) String name) {
        
        return courseService.queryCourseList(pageNum, pageSize, name);
    }
    
    @DeleteMapping("/removeCourse")
    public ResultVO removeCourse(@RequestParam(value = "courseId") Integer courseId) {
        try {
            int count = courseService.removeCourseById(courseId);
            if (count > 0) {
                return ResultVOUtil.success();
            } else {
                return ResultVOUtil.failure(ResultFailureEnum.REMOVE_COURSE_ERROR);
            }
        } catch (Exception ex) {
            throw new CourseException(ResultFailureEnum.REMOVE_COURSE_ERROR);
        }
        
    }
    
    
    @PostMapping("/addCourse")
    public ResultVO addCourse(@RequestBody Course course) {
        
        try {
            int count = courseService.addCourse(course);
            if (count > 0) {
                return ResultVOUtil.success();
            } else {
                return ResultVOUtil.failure(ResultFailureEnum.ADD_COURSE_ERROR);
            }
        } catch (Exception ex) {
            throw new CourseException(ResultFailureEnum.ADD_COURSE_ERROR);
        }
    }
    
    @GetMapping("/getCourse")
    public ResultVO getClassroom(@RequestParam(value = "courseId") Integer courseId) {
        Course course = courseService.getCourseById(courseId);
        return ResultVOUtil.success(course);
    }
    
    @PutMapping("/updateCourse")
    public ResultVO updateCourse(@RequestBody Course course) {
        
        try {
    
            int count = courseService.updateCourse(course);
            if (count > 0) {
                return ResultVOUtil.success();
            } else {
                return ResultVOUtil.failure(ResultFailureEnum.UPDATE_COURSE_ERROR);
            }
        } catch (Exception ex) {
            throw new CourseException(ResultFailureEnum.UPDATE_COURSE_ERROR);
        }
    }
}