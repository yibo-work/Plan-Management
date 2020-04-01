package com.mapper;

import com.pojo.Apply;
import com.vo.ApplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface ApplyMapper {
    
    List<ApplyVO> queryApplyVOList(@Param("userId") Integer userId, @Param("role") Integer role, @Param("classroomId") Integer classroomId, @Param(
            "status") Integer status);
    
    int auditApplyStatusById(@Param("id") Integer id, @Param("status") Integer status);
    
    int addApply(@Param("apply") Apply apply);
    
    List<Apply> getApplyByClassroomAndTime(@Param("classroomId") Integer classroomId, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
    
    List<Apply> getApplyByBeginTimeAndEndTime(@Param("classroomId") Integer classroomId, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
    
    int deleteApply(@Param("id") Integer id);
    
    int cancelApply(@Param("id") Integer id);
}
