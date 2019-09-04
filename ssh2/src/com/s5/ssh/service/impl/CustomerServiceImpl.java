package com.s5.ssh.service.impl;

import java.util.List;

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

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerDao.delete(customer);
    }

    @Override
    public List<Customer> findByHQL() {
        List<Customer> list = customerDao.getListByHQL();
        return list;
    }

    @Override
    public List<Customer> findByQBC() {
        List<Customer> list = customerDao.getListByQBC();
        return list;
    }

    @Override
    public Customer findById(Long cust_id) {
        Customer customer = customerDao.getById(cust_id);
        return customer;
    }

    @Override
    public List<Customer> findByNameQuery() {
        return customerDao.getByNameQuery();
    }

}
