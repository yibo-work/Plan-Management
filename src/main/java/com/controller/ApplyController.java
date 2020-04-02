//package com.controller;
//
//import com.enums.ResultFailureEnum;
//import com.exception.ApplyException;
//import com.pojo.Apply;
//import com.pojo.Course;
//import com.pojo.User;
//import com.service.IApplyService;
//import com.service.ICourseService;
//import com.utils.ResultVOUtil;
//import com.vo.ApplyVO;
//import com.vo.ResultVO;
//import com.github.pagehelper.PageInfo;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpSession;
//import java.util.List;
//
//@RestController
//@RequestMapping("/apply")
//@Slf4j
//public class ApplyController {
//
//    @Resource
//    private IApplyService applyService;
//
//    @Resource
//    private ICourseService courseService;
//
//    @PostMapping("/addApply")
//    public ResultVO addApply(@RequestBody Apply apply, HttpSession session) {
//        User user = (User) session.getAttribute("USER");
//        apply.setUserId(user.getId());
//
//        //判断该时间段教室是否被课程占用
//        List<Course> course = courseService.getCourseByClassroomAndTime(apply.getClassroomId(), apply.getBeginTime(), apply.getEndTime());
//
//        //判断该时间段教室是否被申请
//        List<Apply> apply1 = applyService.getApplyByClassroomAndTime(apply.getClassroomId(), apply.getBeginTime(), apply.getEndTime());
//
//        if (!course.isEmpty()) {
//            return ResultVOUtil.failure(ResultFailureEnum.CLASSROOM_ARE_OCCUPIED_BY_COURSE);
//        }
//
//        if (!apply1.isEmpty()) {
//            return ResultVOUtil.failure(ResultFailureEnum.CLASSROOM_ARE_OCCUPIED_BY_APPLY);
//        }
//
//        try {
//            applyService.addApply(apply);
//            return ResultVOUtil.success();
//        } catch (Exception ex) {
//            return ResultVOUtil.failure(ResultFailureEnum.Apply_ERROR);
//        }
//
//    }
//
//
//    /**
//     * 通过当前用户查询自己的申请
//     *
//     * @param session     session用户
//     * @param pageNum     页码
//     * @param pageSize    页面大小
//     * @param role        角色
//     * @param status      状态
//     * @param classroomId 教室编号
//     * @return pageInfo<ApplyVO> 对象
//     */
//    @GetMapping("/queryApplyByUser")
//    public PageInfo<ApplyVO> queryApplyByUser(HttpSession session,
//                                              @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
//                                              @RequestParam(value = "pageSize", required = false, defaultValue = "2") Integer pageSize,
//                                              @RequestParam(value = "role", required = false) Integer role,
//                                              @RequestParam(value = "status", required = false) Integer status,
//                                              @RequestParam(value = "classroomId", required = false) Integer classroomId) {
//        User user = (User) session.getAttribute("USER");
//
//        if (user.getRole() > 1) {//如果是管理员则返回所有
//            return applyService.queryApplyVOList(pageNum, pageSize, null, role, classroomId, status);
//        }
//
//        //默认查询当前用户的
//        return applyService.queryApplyVOList(pageNum, pageSize, user.getId(), role, classroomId, status);
//
//
//    }
//
//    /**
//     * 通过当前用户查询自己的申请历史
//     *
//     * @param session     session用户
//     * @param pageNum     页码
//     * @param pageSize    页面大小
//     * @param role        角色
//     * @param status      状态
//     * @param classroomId 教室编号
//     * @return pageInfo<ApplyVO> 对象
//     */
//    @GetMapping("/queryApplyHistoryByUser")
//    public PageInfo<ApplyVO> queryApplyHistoryByUser(HttpSession session,
//                                                     @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
//                                                     @RequestParam(value = "pageSize", required = false, defaultValue = "2") Integer pageSize,
//                                                     @RequestParam(value = "role", required = false) Integer role,
//                                                     @RequestParam(value = "status", required = false) Integer status,
//                                                     @RequestParam(value = "classroomId", required = false) Integer classroomId) {
//        User user = (User) session.getAttribute("USER");
//
//        if (user.getRole() > 1) {//如果是管理员则返回所有
//            return applyService.queryApplyVOList(pageNum, pageSize, null, role, classroomId, 1);
//        }
//
//        //默认查询当前用户的
//        return applyService.queryApplyVOList(pageNum, pageSize, user.getId(), role, classroomId, 1);
//
//
//    }
//
//    @GetMapping("/queryAllAuditApply")
//    public PageInfo<ApplyVO> queryAllAuditApply(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
//                                                @RequestParam(value = "pageSize", required = false, defaultValue = "2") Integer pageSize,
//                                                @RequestParam(value = "role", required = false) Integer role,
//                                                @RequestParam(value = "status", required = false, defaultValue = "0") Integer status,
//                                                @RequestParam(value = "classroomId", required = false) Integer classroomId) {
////        User user = (User) session.getAttribute("USER");
//
//        //默认查询当前用户的
//        return applyService.queryApplyVOList(pageNum, pageSize, null, role, classroomId, status);
//    }
//
//
//    @PutMapping("/cancelApply")
//    public ResultVO cancelApply(@RequestParam(value = "applyId") Integer applyId) {
//        try {
//            int count = applyService.cancelApply(applyId);
//            if (count > 0) {
//                return ResultVOUtil.success();
//            } else {
//                return ResultVOUtil.failure(ResultFailureEnum.CANCEL_Apply_ERROR);
//            }
//        } catch (Exception ex) {
//            return ResultVOUtil.failure(ResultFailureEnum.CANCEL_Apply_ERROR);
//        }
//    }
//
//    @DeleteMapping("/deleteApply")
//    public ResultVO deleteApply(@RequestParam(value = "applyId") Integer applyId) {
//        try {
//            int count = applyService.deleteApply(applyId);
//            if (count > 0) {
//                return ResultVOUtil.success();
//            } else {
//                return ResultVOUtil.failure(ResultFailureEnum.DELETE_Apply_ERROR);
//            }
//        } catch (Exception ex) {
//            return ResultVOUtil.failure(ResultFailureEnum.DELETE_Apply_ERROR);
//        }
//    }
//
//    @PutMapping("/updateApply")
//    public ResultVO updateApply(@RequestParam(value = "id") Integer id, @RequestParam(value = "status") Integer status) {
//        try {
//            int count = applyService.auditApplyStatusById(id, status);
//            if (count > 0) {
//                return ResultVOUtil.success();
//            } else {
//                return ResultVOUtil.failure(ResultFailureEnum.AUDIT_APPLY_ERROR);
//            }
//        } catch (Exception ex) {
//            throw new ApplyException(ResultFailureEnum.AUDIT_APPLY_ERROR);
//        }
//    }
//}
