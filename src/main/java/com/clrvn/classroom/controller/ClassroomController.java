package com.clrvn.classroom.controller;

import com.classroom.enums.ResultFailureEnum;
import com.classroom.exception.ClassroomException;
import com.classroom.pojo.Classroom;
import com.classroom.service.IClassroomService;
import com.classroom.utils.ResultVOUtil;
import com.classroom.vo.ResultVO;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/classroom")
@Slf4j
public class ClassroomController {
    
    @Resource
    private IClassroomService classroomService;
    
    /*@GetMapping(value = {"/page/{pageNum}/{pageSize}/{name}/{type}", "/page/{pageNum}/{pageSize}", "/page/{pageNum}/{pageSize}/{type}"})*/
    @GetMapping("/page")
    public PageInfo<Classroom> queryAllClassroom(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize,
                                                 @RequestParam(value = "name", required = false) String name,
                                                 @RequestParam(value = "type", required = false) Integer type,
                                                 @RequestParam(value = "beginTime", required = false) String beginTimeString,
                                                 @RequestParam(value = "endTime", required = false) String endTimeString) throws ParseException {
        /*Integer typeId = null;
        
        if (type != null) {
            if (name == null) {
                try {
                    typeId = Integer.valueOf(type);
                } catch (Exception ignored) {
                    //这个是让他可以输入1，2就查询教室类型
                    name = type;
                }
            } else {
                typeId = Integer.valueOf(type);
            }
        }*/
        
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        Date beginTime = null;
        
        Date endTime = null;
        
        if (beginTimeString != null && endTimeString != null) {
            
            beginTime = df.parse(beginTimeString);
            endTime = df.parse(endTimeString);
            
        }
        
        return classroomService.queryClassroomList(pageNum, pageSize, type, name, beginTime, endTime);
    }
    
    /**
     * 查询单个教室的申请和课程时间
     *
     * @param id
     * @return
     */
    @GetMapping("/queryClassroomTimeListById")
    public ResultVO queryClassroomTimeListById(@RequestParam(value = "id") Integer id) {
        return ResultVOUtil.success(classroomService.queryClassroomTimeListById(id));
    }
    
    @DeleteMapping("/removeClassroom")
    public ResultVO removeClassroom(@RequestParam(value = "classroomId") Integer classroomId) {
        try {
            int count = classroomService.removeClassroomById(classroomId);
            if (count > 0) {
                return ResultVOUtil.success();
            } else {
                return ResultVOUtil.failure(ResultFailureEnum.REMOVE_CLASSROOM_ERROR);
            }
        } catch (Exception ex) {
            throw new ClassroomException(ResultFailureEnum.REMOVE_COURSE_ERROR);
        }
        
    }
    
    @PostMapping("/addClassroom")
    public ResultVO addClassroom(@RequestBody Classroom classroom) {
        
        try {
            int count = classroomService.addClassroom(classroom);
            if (count > 0) {
                return ResultVOUtil.success();
            } else {
                return ResultVOUtil.failure(ResultFailureEnum.ADD_CLASSROOM_ERROR);
            }
        } catch (Exception ex) {
            throw new ClassroomException(ResultFailureEnum.ADD_CLASSROOM_ERROR);
        }
    }
    
    @GetMapping("/getAllClassroom")
    public ResultVO getAllClassroom() {
        return ResultVOUtil.success(classroomService.getAllClassroom());
    }
    
    @GetMapping("/getClassroom")
    public ResultVO getClassroom(@RequestParam(value = "classroomId") Integer classroomId) {
        Classroom classroom = classroomService.getClassroomById(classroomId);
        return ResultVOUtil.success(classroom);
    }
    
    @PutMapping("/updateClassroom")
    public ResultVO updateClassroom(@RequestBody Classroom classroom) {
        
        try {
            int count = classroomService.updateClassroom(classroom);
            if (count > 0) {
                return ResultVOUtil.success();
            } else {
                return ResultVOUtil.failure(ResultFailureEnum.UPDATE_CLASSROOM_ERROR);
            }
        } catch (Exception ex) {
            throw new ClassroomException(ResultFailureEnum.UPDATE_CLASSROOM_ERROR);
        }
    }
}