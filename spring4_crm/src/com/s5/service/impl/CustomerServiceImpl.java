package com.s5.service.impl;

import com.s5.dao.CustomerDao;
import com.s5.entity.Customer;
import com.s5.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void save(Customer customer) {
        System.out.println("CustomerService的save方法被执行了……");
        customerDao.save(customer);
    }
}
