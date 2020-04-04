package com.controller;

import com.github.pagehelper.PageInfo;
import com.pojo.Plan;
import com.service.IPlanService;
import com.utils.ResultVOUtil;
import com.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private IPlanService planService;

    @GetMapping("/page")
    public PageInfo<Plan> queryAllPlan(@RequestParam("pageNum") Integer pageNum
            , @RequestParam("pageSize") Integer pageSize
            , @RequestParam(required = false, name = "status") Integer status
            , @RequestParam(required = false, name = "type") Integer type
            , @RequestParam(required = false, name = "execTime") String execTime
            , @RequestParam(required = false, name = "companyName") String companyName
    ) {
        return planService.queryPlanList(pageNum, pageSize, status, type, execTime, companyName);
    }

    @DeleteMapping("/removePlan")
    public ResultVO removePlan(@RequestParam(value = "planId") Integer planId) {
        planService.removePlanById(planId);
        return ResultVOUtil.success();

    }

    @PostMapping("/addPlan")
    public ResultVO addPlan(@RequestBody Plan plan) {
        planService.addPlan(plan);
        return ResultVOUtil.success();
    }

    @GetMapping("/getPlan")
    public ResultVO getPlan(@RequestParam(value = "planId") Integer planId) {
        Plan plan = planService.getPlanById(planId);
        return ResultVOUtil.success(plan);
    }

    @PutMapping("/updatePlan")
    public ResultVO updatePlan(@RequestBody Plan plan) {
        planService.updatePlan(plan);
        return ResultVOUtil.success();
    }
}