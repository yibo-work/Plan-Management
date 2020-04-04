package com.mapper;

import com.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CustomerMapper {

    List<Customer> queryCustomerList(Integer planFlag);

    int addCustomer(@Param("customer") Customer customer);

    Customer getCustomerById(@Param("id") Integer id);

    int updateCustomer(@Param("customer") Customer customer);

    int removeCustomerById(@Param("id") Integer id);

}
