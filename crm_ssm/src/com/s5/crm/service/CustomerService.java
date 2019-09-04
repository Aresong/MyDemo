package com.s5.crm.service;

import com.s5.common.utils.Page;
import com.s5.crm.pojo.Customer;
import com.s5.crm.pojo.QueryVo;

public interface CustomerService {
    public Page<Customer> selectPageByQueryVo(QueryVo vo);

    public Customer selectCustomerById(Integer id);

    public void updateCustomerById(Customer customer);

    public void deleteCustomerById(Integer id);
}
