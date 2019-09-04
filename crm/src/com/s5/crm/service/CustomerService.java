package com.s5.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import com.s5.crm.entity.Customer;
import com.s5.crm.entity.PageBean;

/**
 * @author Aresong
 * 客户管理service的接口
 */
public interface CustomerService {

    void save(Customer customer);

    PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer curPage, Integer pageSize);

}
