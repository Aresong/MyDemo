package com.s5.struts.service.impl;

import java.util.List;

import com.s5.struts.dao.CustomerDao;
import com.s5.struts.dao.impl.CustomerDaoImpl;
import com.s5.struts.entity.Customer;
import com.s5.struts.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public List<Customer> find() {
        CustomerDao customerDao = new CustomerDaoImpl();
        return customerDao.find();
    }

    @Override
    public void save(Customer customer) {
        CustomerDao customerDao = new CustomerDaoImpl();
        customerDao.save(customer);
    }

}
