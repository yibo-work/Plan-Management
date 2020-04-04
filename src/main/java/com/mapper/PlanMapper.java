package com.mapper;

import com.pojo.Plan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PlanMapper {

    List<Plan> queryPlanList(@Param("status") Integer status, @Param("type") Integer type, @Param("execTime") String execTime, @Param("companyName") String companyName);

    int addPlan(@Param("plan") Plan plan);

    Plan getPlanById(@Param("id") Integer id);

    int updatePlan(@Param("plan") Plan plan);

    int removePlanById(@Param("id") Integer id);

}