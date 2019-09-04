package com.s5.dao.impl;

import com.s5.dao.CustomerDao;
import com.s5.entity.Customer;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public void save(Customer customer) {
        System.out.println("customerDao中的save被执行了……");
    }

}
