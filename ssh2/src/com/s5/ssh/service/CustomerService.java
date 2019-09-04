package com.s5.ssh.service;

import java.util.List;

import com.s5.ssh.entity.Customer;

/**
 * 客户管理的业务层的接口
 **/
public interface CustomerService {
    public void save(Customer customer);

    public void update(Customer customer);

    public void delete(Customer customer);

    public List<Customer> findByHQL();

    public List<Customer> findByQBC();

    public Customer findById(Long cust_id);

    public List<Customer> findByNameQuery();
}
