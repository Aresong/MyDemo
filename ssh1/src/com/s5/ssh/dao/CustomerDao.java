package com.s5.ssh.dao;

import com.s5.ssh.entity.Customer;

/**
 * 客户管理的dao层的接口
 **/
public interface CustomerDao {
    public void save(Customer customer);
}
