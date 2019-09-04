package com.s5.hibernate.demo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.s5.hibernate.entity.Customer;
import com.s5.hibernate.entity.LinkMan;
import com.s5.hibernate.utils.HibernateUtils;

public class HibernateDome2 {
    @Test
    /**
     * �򵥵Ĳ�ѯ
     */
    public void demo1() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        // ���Criteria�Ķ���
        Criteria criteria = session.createCriteria(Customer.class);
        List<Customer> list = criteria.list();

        for (Customer customer : list) {
            System.out.println(customer);
        }
        tx.commit();
    }

    @Test
    /**
     * �����ѯ
     */
    public void demo2() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        // �����ѯ
        Criteria criteria = session.createCriteria(Customer.class);
//		criteria.addOrder(Order.asc("cust_id")); // ����
        criteria.addOrder(Order.desc("cust_id")); // ����
        List<Customer> list = criteria.list();

        for (Customer customer : list) {
            System.out.println(customer);
        }

        tx.commit();
    }

    @Test
    /**
     * ��ҳ��ѯ
     */
    public void demo3() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        // ��ҳ��ѯ
        Criteria criteria = session.createCriteria(LinkMan.class);
        criteria.setFirstResult(10);
        criteria.setMaxResults(10);
        List<LinkMan> list = criteria.list();

        for (LinkMan linkMan : list) {
            System.out.println(linkMan);
        }
        tx.commit();
    }

    @Test
    /**
     * ������ѯ
     */
    public void demo4() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        // ������ѯ
        Criteria criteria = session.createCriteria(Customer.class);
        // ��������:
        /**
         * =   eq
         * >   gt
         * >=  ge
         * <   lt
         * <=  le
         * <>  ne
         * like
         * in
         * and
         * or
         */
        //criteria.add(Restrictions.eq("cust_source", "С���"));
        criteria.add(Restrictions.or(Restrictions.like("cust_name", "��%"), Restrictions.eq("cust_source", "С���")));
        //criteria.add(Restrictions.like("cust_name", "��%"));
        List<Customer> list = criteria.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        tx.commit();
    }

    @Test
    /**
     * ͳ�Ʋ�ѯ
     */
    public void demo5() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Criteria criteria = session.createCriteria(Customer.class);
        /**
         * add				:��ͨ��������where��������
         * addOrder			:����
         * setProjection	:�ۺϺ��� �� group by having
         */
        criteria.setProjection(Projections.rowCount());
        Long num = (Long) criteria.uniqueResult();
        System.out.println(num);
        tx.commit();
    }

    @Test
    public void demo6() {

        //web���
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        detachedCriteria.add(Restrictions.or(Restrictions.like("cust_name", "��%"), Restrictions.eq("cust_source", "С���")));

        //dao���
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Criteria criteria = detachedCriteria.getExecutableCriteria(session);
        List<Object> list = criteria.list();
        for (Object object : list) {
            System.out.println(object);
        }

        tx.commit();
    }
}
