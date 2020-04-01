package com.service.impl;

import com.mapper.ApplyMapper;
import com.pojo.Apply;
import com.service.IApplyService;
import com.vo.ApplyVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApplyServiceImpl implements IApplyService {
    
    @Autowired
    private ApplyMapper applyMapper;
    
    @Override
    public PageInfo<ApplyVO> queryApplyVOList(Integer pageNum, Integer pageSize, Integer userId, Integer role, Integer classroomId, Integer status) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(applyMapper.queryApplyVOList(userId, role, classroomId, status));
    }
    
    @Override
    public int auditApplyStatusById(Integer id, Integer status) {
        return applyMapper.auditApplyStatusById(id, status);
    }
    
    @Override
    public void addApply(Apply apply) {
        applyMapper.addApply(apply);
    }
    
    @Override
    public List<Apply> getApplyByClassroomAndTime(Integer classroomId, Date beginTime, Date endTime) {
        return applyMapper.getApplyByClassroomAndTime(classroomId, beginTime, endTime);
    }
    
    @Override
    public int cancelApply(Integer id) {
        return applyMapper.cancelApply(id);
    }
    
    @Override
    public int deleteApply(Integer id) {
        return applyMapper.deleteApply(id);
    }
}
