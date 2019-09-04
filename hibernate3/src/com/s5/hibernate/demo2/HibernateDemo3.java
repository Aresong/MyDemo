package com.s5.hibernate.demo2;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.s5.hibernate.entity.LinkMan;
import com.s5.hibernate.utils.HibernateUtils;

public class HibernateDemo3 {
    @Test
    /**
     * Ĭ��ֵ
     */
    public void demo1() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        LinkMan linkMan = session.get(LinkMan.class, 1l);// ����һ����ѯ��ϵ�����
        System.out.println(linkMan.getLkm_name());
        System.out.println(linkMan.getCustomer().getCust_name());// ����һ��select����ѯ��ϵ���������Ŀͻ�

        tx.commit();
    }

    @Test
    /**
     * fetch="select" lazy="proxy"
     */
    public void demo2() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        LinkMan linkMan = session.get(LinkMan.class, 1l);// ����һ����ѯ��ϵ�����
        System.out.println(linkMan.getLkm_name());
        System.out.println(linkMan.getCustomer().getCust_name());// ����һ��select����ѯ��ϵ���������Ŀͻ�

        tx.commit();
    }

    @Test
    /**
     * fetch="select" lazy="false"
     */
    public void demo3() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        LinkMan linkMan = session.get(LinkMan.class, 1l);// ����һ����ѯ��ϵ�����,����һ��select����ѯ��ϵ���������Ŀͻ�
        System.out.println(linkMan.getLkm_name());
        System.out.println(linkMan.getCustomer().getCust_name());//

        tx.commit();
    }

    @Test
    /**
     * fetch="join" lazy=ʧЧ
     */
    public void demo4() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        LinkMan linkMan = session.get(LinkMan.class, 1l);// ����һ�������������Ӳ�ѯ��ϵ���������Ŀͻ���
        System.out.println(linkMan.getLkm_name());
        System.out.println(linkMan.getCustomer().getCust_name());//

        tx.commit();
    }
}
