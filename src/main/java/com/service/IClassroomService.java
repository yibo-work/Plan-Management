//package com.service;
//
//import com.pojo.Classroom;
//import com.vo.ClassroomVO;
//import com.github.pagehelper.PageInfo;
//
//import java.util.Date;
//import java.util.List;
//
///**
// * @author Clrvn
// * @description
// * @className IClassroomService
// * @date 2019-05-17 7:58
// */
//public interface IClassroomService {
//
//    PageInfo<Classroom> queryClassroomList(Integer pageNum, Integer pageSize, Integer type, String name, Date beginTime, Date endTime);
//
//    int addClassroom(Classroom classroom);
//
//    List<Classroom> getAllClassroom();
//
//    Classroom getClassroomById(Integer id);
//
//    int updateClassroom(Classroom classroom);
//
//    int removeClassroomById(Integer classroomId);
//
//    List<ClassroomVO> queryClassroomTimeListById(Integer id);
//}
