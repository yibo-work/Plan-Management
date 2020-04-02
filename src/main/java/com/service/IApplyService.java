//package com.service;
//
//import com.pojo.Apply;
//import com.vo.ApplyVO;
//import com.github.pagehelper.PageInfo;
//
//import java.util.Date;
//import java.util.List;
//
//
///**
// * @author Clrvn
// * @description
// * @className IClassroomService
// * @date 2019-05-17 7:58
// */
//public interface IApplyService {
//
//    PageInfo<ApplyVO> queryApplyVOList(Integer pageNum, Integer pageSize, Integer userId, Integer role, Integer classroomId, Integer status);
//
//    int auditApplyStatusById(Integer id, Integer status);
//
//    void addApply(Apply apply);
//
//    List<Apply> getApplyByClassroomAndTime(Integer classroomId, Date beginTime, Date endTime);
//
//    int cancelApply(Integer id);
//
//    int deleteApply(Integer id);
//
//}
