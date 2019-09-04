package com.s5.hibernate.demo2;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.s5.hibernate.entity.Customer;
import com.s5.hibernate.utils.HibernateUtils;

public class HibernateDemo1 {
    @Test
    /**
     * �༶����ӳټ���
     * * ��<class>�ı�ǩ�����õ�lazy
     */
    public void demo1() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Customer customer = session.load(Customer.class, 1l);
        Hibernate.initialize(customer);
        System.out.println(customer);

        tx.commit();
    }
}
