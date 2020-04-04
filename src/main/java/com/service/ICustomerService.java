package com.service;

import com.github.pagehelper.PageInfo;
import com.pojo.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICustomerService {

    PageInfo<Customer> queryCustomerList(Integer pageNum, Integer pageSize, Integer planFlag);

    int addCustomer(Customer classroom);

    List<Customer> getAllCustomer();

    Customer getCustomerById(Integer id);

    int updateCustomer(Customer classroom);

    int removeCustomerById(Integer classroomId);

}
