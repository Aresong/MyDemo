package com.s5.ssh.dao.impl;

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

}
