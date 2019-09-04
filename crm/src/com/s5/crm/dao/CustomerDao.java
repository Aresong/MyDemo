package com.s5.crm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.s5.crm.entity.Customer;

/**
 * @author Aresong
 * 客户管理dao的接口
 */
public interface CustomerDao {

    void save(Customer customer);

    Integer findCount(DetachedCriteria detachedCriteria);

    List<Customer> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize);

}
