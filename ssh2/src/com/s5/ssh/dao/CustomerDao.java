package com.s5.ssh.dao;

import java.util.List;

import com.s5.ssh.entity.Customer;

/**
 * 客户管理的dao层的接口
 **/
public interface CustomerDao {
    public void save(Customer customer);

    public void update(Customer customer);

    public void delete(Customer customer);

    public List<Customer> getListByHQL();

    public List<Customer> getListByQBC();

    public Customer getById(Long cust_id);

    public List<Customer> getByNameQuery();
}
