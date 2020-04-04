package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.PlanMapper;
import com.pojo.Plan;
import com.service.IPlanService;
import com.vo.PlanVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements IPlanService {

    @Autowired
    private PlanMapper planMapper;

    @Override
    public PageInfo<PlanVO> queryPlanList(Integer pageNum, Integer pageSize, Integer status, Integer type, String execTime, String companyName) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(planMapper.queryPlanList(status, type, execTime, companyName));
    }

    @Override
    public int addPlan(Plan plan) {
        return planMapper.addPlan(plan);
    }

    @Override
    public PlanVO getPlanById(Integer id) {
        return planMapper.getPlanById(id);
    }

    @Override
    public int updatePlan(Plan plan) {
        return planMapper.updatePlan(plan);
    }

    @Override
    public int removePlanById(Integer roomId) {
        return planMapper.removePlanById(roomId);
    }

}
