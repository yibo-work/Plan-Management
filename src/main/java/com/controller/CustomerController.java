package com.controller;

import com.github.pagehelper.PageInfo;
import com.pojo.Customer;
import com.service.ICustomerService;
import com.utils.ResultVOUtil;
import com.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/page")
    public PageInfo<Customer> queryAllCustomer(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize  , @RequestParam(required = false, name = "planFlag") Integer planFlag) {
        return customerService.queryCustomerList(pageNum, pageSize, planFlag);
    }

    @DeleteMapping("/removeCustomer")
    public ResultVO removeCustomer(@RequestParam(value = "customerId") Integer customerId) {
        customerService.removeCustomerById(customerId);
        return ResultVOUtil.success();

    }

    @PostMapping("/addCustomer")
    public ResultVO addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return ResultVOUtil.success();
    }

    @GetMapping("/getAllCustomer")
    public ResultVO getAllCustomer() {
        return ResultVOUtil.success(customerService.getAllCustomer());
    }

    @GetMapping("/getCustomer")
    public ResultVO getCustomer(@RequestParam(value = "customerId") Integer customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return ResultVOUtil.success(customer);
    }

    @PutMapping("/updateCustomer")
    public ResultVO updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        return ResultVOUtil.success();
    }
}