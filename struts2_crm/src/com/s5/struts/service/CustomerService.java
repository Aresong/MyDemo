package com.s5.struts.service;

import java.util.List;

import com.s5.struts.entity.Customer;

public interface CustomerService {
    public List<Customer> find();

    public void save(Customer customer);
}
