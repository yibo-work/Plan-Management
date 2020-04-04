package com.service;

import com.github.pagehelper.PageInfo;
import com.pojo.Plan;
import com.vo.PlanVO;

public interface IPlanService {

    PageInfo<PlanVO> queryPlanList(Integer pageNum, Integer pageSize, Integer status, Integer type, String execTime, String companyName);

    int addPlan(Plan plan);

    PlanVO getPlanById(Integer id);

    int updatePlan(Plan plan);

    int removePlanById(Integer id);

}
