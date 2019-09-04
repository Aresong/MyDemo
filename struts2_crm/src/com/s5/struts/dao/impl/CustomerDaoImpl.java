package com.s5.struts.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.s5.struts.dao.CustomerDao;
import com.s5.struts.entity.Customer;
import com.s5.struts.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {
    public List<Customer> find() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from Customer");
        List<Customer> list = query.list();
        tx.commit();
        return list;
    }

    @Override
    public void save(Customer customer) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        session.save(customer);

        tx.commit();
    }
}
