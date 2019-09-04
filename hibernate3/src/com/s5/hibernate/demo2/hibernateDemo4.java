package com.s5.hibernate.demo2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.s5.hibernate.entity.Customer;
import com.s5.hibernate.entity.LinkMan;
import com.s5.hibernate.utils.HibernateUtils;

public class hibernateDemo4 {
    @SuppressWarnings("unchecked")
    @Test
    /**
     * ��ȡ�ͻ���ʱ������ץȡ��ϵ��
     * ��Customer.hbm.xml��set������batch-size
     */
    public void demo1() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        List<Customer> list = session.createQuery("from Customer").list();
        for (Customer customer : list) {
            System.out.println(customer.getCust_name());
            for (LinkMan linkMan : customer.getLinkMans()) {
                System.out.println(linkMan.getLkm_name());
            }
        }
        tx.commit();
    }

    @SuppressWarnings("unchecked")
    @Test
    /**
     * ��ȡ��ϵ�˵�ʱ������ץȡ�ͻ�
     * * ��Customer.hbm.xml��<class>������
     */
    public void demo2() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        List<LinkMan> list = session.createQuery("from LinkMan").list();
        for (LinkMan linkMan : list) {
            System.out.println(linkMan.getLkm_name());
            System.out.println(linkMan.getCustomer().getCust_name());
        }
        tx.commit();
    }
}
