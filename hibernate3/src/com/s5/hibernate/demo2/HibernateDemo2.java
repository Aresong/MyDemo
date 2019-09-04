package com.s5.hibernate.demo2;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.s5.hibernate.entity.Customer;
import com.s5.hibernate.entity.LinkMan;
import com.s5.hibernate.utils.HibernateUtils;

public class HibernateDemo2 {
    @Test
    /**
     * Ĭ�������
     */
    public void demo1() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        // ��ѯ1�ſͻ�
        Customer customer = session.get(Customer.class, 1l);// ����һ����ѯ�ͻ���SQL
        System.out.println(customer.getCust_name());
        // �鿴1�ſͻ���ÿ����ϵ�˵���Ϣ
        for (LinkMan linkMan : customer.getLinkMans()) {// ����һ�����ݿͻ�ID��ѯ��ϵ�˵�SQL
            System.out.println(linkMan.getLkm_name());
        }
        tx.commit();
    }

    @Test
    /**
     * ����fetch="select" lazy="true"
     */
    public void demo2() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        // ��ѯ1�ſͻ�
        Customer customer = session.get(Customer.class, 1l);// ����һ����ѯ�ͻ���SQL
        System.out.println(customer.getCust_name());
        // �鿴1�ſͻ���ÿ����ϵ�˵���Ϣ
        for (LinkMan linkMan : customer.getLinkMans()) {// ����һ�����ݿͻ�ID��ѯ��ϵ�˵�SQL
            System.out.println(linkMan.getLkm_name());
        }
        tx.commit();
    }

    @Test
    /**
     * ����	fetch="select" lazy="false"
     */
    public void demo3() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        // ��ѯ1�ſͻ�
        Customer customer = session.get(Customer.class, 1l);// ��������SQL��䣺��ѯ�ͻ������ƣ���ѯ�ͻ�������ϵ��
        System.out.println(customer.getCust_name());
		/*// �鿴1�ſͻ���ÿ����ϵ�˵���Ϣ
		for (LinkMan linkMan : customer.getLinkMans()) {// 
			System.out.println(linkMan.getLkm_name());
		}*/

        System.out.println(customer.getLinkMans().size());//ʲôҲ���飬ֱ����ʾ��ϵ������
        tx.commit();
    }

    @Test
    /**
     * ����fetch="select" lazy="extra"
     */
    public void demo4() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        // ��ѯ1�ſͻ�
        Customer customer = session.get(Customer.class, 1l);// ����һ����ѯ1�ſͻ���SQL���
        System.out.println(customer.getCust_name());

        System.out.println(customer.getLinkMans().size());// ����һ��select count() from ...;
        tx.commit();
    }

    @Test
    /**
     * ����fetch="join" lazy=ʧЧ
     */
    public void demo5() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        // ��ѯ1�ſͻ�
        Customer customer = session.get(Customer.class, 1l);// ����һ�������������Ӳ�ѯ��¼
        System.out.println(customer.getCust_name());

        System.out.println(customer.getLinkMans().size());// ������
        tx.commit();
    }

    @SuppressWarnings("unchecked")
    @Test
    /**
     * ����fetch="subselect" lazy="true"
     */
    public void demo6() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        List<Customer> list = session.createQuery("from Customer").list();// ���Ͳ�ѯ���пͻ���SQL
        for (Customer customer : list) {
            System.out.println(customer.getCust_name());
            System.out.println(customer.getLinkMans().size());// ����һ���Ӳ�ѯ
        }

        tx.commit();
    }

    @SuppressWarnings("unchecked")
    @Test
    /**
     * ����fetch="subselect" lazy="false"
     */
    public void demo7() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        List<Customer> list = session.createQuery("from Customer").list();// ������������ѯ���пͻ���SQL��һ���Ӳ�ѯ
        for (Customer customer : list) {
            System.out.println(customer.getCust_name());
            System.out.println(customer.getLinkMans().size());//
        }

        tx.commit();
    }
}
