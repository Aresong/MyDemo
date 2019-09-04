package com.s5.struts.dao;

import java.util.List;

import com.s5.struts.entity.Customer;

public interface CustomerDao {
    public List<Customer> find();

    public void save(Customer customer);
}
