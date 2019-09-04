package com.s5.ssh.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.s5.ssh.dao.CustomerDao;
import com.s5.ssh.entity.Customer;
/**
 * 业务层客户的实现类
 * **/
import com.s5.ssh.service.CustomerService;

@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void save(Customer customer) {
        customerDao.save(customer);
        System.out.println("Service中的save方法执行了……");
    }

}
