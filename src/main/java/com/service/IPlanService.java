package com.service;

import com.github.pagehelper.PageInfo;
import com.pojo.Plan;

public interface IPlanService {

    PageInfo<Plan> queryPlanList(Integer pageNum, Integer pageSize, Integer status, Integer type, String execTime, String companyName);

    int addPlan(Plan plan);

    Plan getPlanById(Integer id);

    int updatePlan(Plan plan);

    int removePlanById(Integer id);

}
