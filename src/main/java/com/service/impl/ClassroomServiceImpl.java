package com.service.impl;

import com.mapper.ApplyMapper;
import com.mapper.ClassroomMapper;
import com.mapper.CourseMapper;
import com.pojo.Apply;
import com.pojo.Classroom;
import com.pojo.Course;
import com.service.IClassroomService;
import com.vo.ClassroomApplyVO;
import com.vo.ClassroomCourseVO;
import com.vo.ClassroomVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ClassroomServiceImpl implements IClassroomService {
    
    @Autowired
    private ClassroomMapper classroomMapper;
    
    @Autowired
    private ApplyMapper applyMapper;
    
    @Autowired
    private CourseMapper courseMapper;
    
    @Override
    public PageInfo<Classroom> queryClassroomList(Integer pageNum, Integer pageSize, Integer type, String name, Date beginTime, Date endTime) {
        
        List<Classroom> classroomList = classroomMapper.queryClassroomList(type, name);
        
        if (beginTime != null || endTime != null) {
            
            List<Classroom> newClassroomList = new ArrayList<>();
            
            for (Classroom classroom : classroomList) {
                List<Apply> applyList = applyMapper.getApplyByBeginTimeAndEndTime(classroom.getId(), beginTime, endTime);
                List<Course> courseList = courseMapper.getCourseByBeginTimeAndEndTime(classroom.getId(), beginTime, endTime);
                
                if (applyList.isEmpty() && courseList.isEmpty()) {
                    newClassroomList.add(classroom);
                }
            }
            
            PageHelper.startPage(pageNum, pageSize);
            return new PageInfo<>(newClassroomList);
        } else {
            PageHelper.startPage(pageNum, pageSize);
            return new PageInfo<>(classroomList);
        }
        
        
    }
    
    @Override
    @Transactional
    public int addClassroom(Classroom classroom) {
        return classroomMapper.addClassroom(classroom);
    }
    
    @Override
    public List<Classroom> getAllClassroom() {
        return classroomMapper.getAllClassroom();
    }
    
    @Override
    public Classroom getClassroomById(Integer id) {
        return classroomMapper.getClassroomById(id);
    }
    
    @Override
    @Transactional
    public int updateClassroom(Classroom classroom) {
        return classroomMapper.updateClassroom(classroom);
    }
    
    @Override
    @Transactional
    public int removeClassroomById(Integer roomId) {
        return classroomMapper.removeClassroomById(roomId);
    }
    
    @Override
    public List<ClassroomVO> queryClassroomTimeListById(Integer id) {
        
        List<ClassroomApplyVO> applyVOList = classroomMapper.queryClassroomTimeListByIdApply(id);
        List<ClassroomCourseVO> courseVOList = classroomMapper.queryClassroomTimeListByIdCourse(id);
        
        
        List<ClassroomVO> classroomVOList = new ArrayList<>();
        
        for (ClassroomApplyVO classroomApplyVO : applyVOList) {
            
            for (Apply apply : classroomApplyVO.getApplyList()) {
                ClassroomVO classroomVO = new ClassroomVO();
                classroomVO.setClassroomId(classroomApplyVO.getClassroomId());
                classroomVO.setCourse(null);
                classroomVO.setClassroom(classroomApplyVO.getClassroom());
                classroomVO.setApply(apply);
                classroomVO.setOrderTime(apply.getBeginTime().getTime());
                classroomVOList.add(classroomVO);
            }
            
        }
        
        for (ClassroomCourseVO classroomCourseVO : courseVOList) {
            
            for (Course course : classroomCourseVO.getCourseList()) {
                ClassroomVO classroomVO = new ClassroomVO();
                classroomVO.setClassroomId(classroomCourseVO.getClassroomId());
                classroomVO.setCourse(course);
                classroomVO.setOrderTime(course.getBeginTime().getTime());
                classroomVO.setClassroom(classroomCourseVO.getClassroom());
                classroomVO.setApply(null);
                classroomVOList.add(classroomVO);
            }
            
        }
        
        //排序
        for (int i = 0; i < classroomVOList.size() - 1; i++) {
            for (int j = 0; j < classroomVOList.size() - 1 - i; j++) {
                if (classroomVOList.get(j).getOrderTime() > classroomVOList.get(j + 1).getOrderTime()) {
                    ClassroomVO temp = classroomVOList.get(j);
                    classroomVOList.set(j, classroomVOList.get(j + 1));
                    classroomVOList.set(j + 1, temp);
                }
            }
        }
        
        return classroomVOList;
    }
}
