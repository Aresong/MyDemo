package com.s5.ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * 客户dao层的实现类
 * **/
import com.s5.ssh.dao.CustomerDao;
import com.s5.ssh.entity.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

    @Override
    public void save(Customer customer) {
        System.out.println("Dao中的save方法被执行了……");
        System.out.println(customer);
        this.getHibernateTemplate().save(customer);
    }

    @Override
    public void update(Customer customer) {
        this.getHibernateTemplate().update(customer);
    }

    @Override
    public void delete(Customer customer) {
        this.getHibernateTemplate().delete(customer);
    }

    @Override
    public List<Customer> getListByHQL() {
        List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer");
        return list;
    }

    @Override
    public List<Customer> getListByQBC() {
        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
        List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
        return list;
    }

    @Override
    public Customer getById(Long cust_id) {
        //return this.getHibernateTemplate().get(Customer.class, cust_id);
        return this.getHibernateTemplate().load(Customer.class, cust_id);
    }

    @Override
    public List<Customer> getByNameQuery() {
        return (List<Customer>) this.getHibernateTemplate().findByNamedQuery("queryAll");
    }


}
