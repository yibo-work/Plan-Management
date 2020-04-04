package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.CustomerMapper;
import com.pojo.Customer;
import com.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public PageInfo<Customer> queryCustomerList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(customerMapper.queryCustomerList());
    }

    @Override
    public int addCustomer(Customer customer) {
        return customerMapper.addCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerMapper.queryCustomerList();
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerMapper.getCustomerById(id);
    }

    @Override
    public int updateCustomer(Customer customer) {
        return customerMapper.updateCustomer(customer);
    }

    @Override
    public int removeCustomerById(Integer roomId) {
        return customerMapper.removeCustomerById(roomId);
    }

}
