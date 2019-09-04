package com.s5.hibernate.demo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.s5.hibernate.entity.Customer;
import com.s5.hibernate.entity.LinkMan;
import com.s5.hibernate.utils.HibernateUtils;

public class HibernateDemo1 {

    @Test
    public void demo1() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        //����һ���ͻ�
        Customer customer = new Customer();
        customer.setCust_name("������");
        for (int i = 1; i <= 10; i++) {
            LinkMan linkMan = new LinkMan();
            linkMan.setLkm_name("����" + i);
            linkMan.setCustomer(customer);
            customer.getLinkMans().add(linkMan);
            session.save(linkMan);
        }
        session.save(customer);
        tx.commit();

    }

    @Test
    public void demo2() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from Customer");//from com.s5.hibernate.entity.Customer
        List<Customer> list = query.list();

        // sql��֧��*�ŵ�д����select * from cst_customer; ������HQL�в�֧��*�ŵ�д����
        /*
         * Query query = session.createQuery("select * from Customer");// ����
         * List<Customer> list = query.list();
         */

        for (Customer customer : list) {
            System.out.println(customer);
        }

        tx.commit();

    }

    @Test
    /**
     * ������ѯ
     */
    public void demo3() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        // �����Ĳ�ѯ
        /*
         * Query query = session.createQuery("from Customer c"); List<Customer>
         * list = query.list();
         */

        Query query = session.createQuery("select c from Customer c");
        List<Customer> list = query.list();

        for (Customer customer : list) {
            System.out.println(customer);
        }
        tx.commit();
    }

    @Test
    /**
     * �����ѯ
     */
    public void demo4() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        // ����Ĳ�ѯ
        // Ĭ�����
        // List<Customer> list = session.createQuery("from Customer order by
        // cust_id").list();
        // ���ý������� ����ʹ��asc ����ʹ��desc
        List<Customer> list = session.createQuery("from Customer order by cust_id desc").list();

        for (Customer customer : list) {
            System.out.println(customer);
        }
        tx.commit();
    }

    @Test
    /**
     * ������ѯ
     */
    public void demo5() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        // �����Ĳ�ѯ
        // һ����λ�ð󶨣����ݲ�����λ�ý��а󶨡�
        // һ������
        /*
         * Query query = session.createQuery("from Customer where cust_name = ?"
         * ); query.setParameter(0, "���"); List<Customer> list = query.list();
         */

        // �������
        /*
         * Query query = session.createQuery(
         * "from Customer where cust_source = ? and cust_name like ?");
         * query.setParameter(0, "С���"); query.setParameter(1, "��%");
         * List<Customer> list = query.list();
         */

        // ���������ư�
        Query query = session.createQuery("from Customer where cust_source = :aaa and cust_name like :bbb");
        // ���ò���:
        query.setParameter("aaa", "�����Ƽ�");
        query.setParameter("bbb", "��%");
        List<Customer> list = query.list();

        for (Customer customer : list) {
            System.out.println(customer);
        }
        tx.commit();
    }

    @Test
    /**
     * ͶӰ��ѯ
     */
    public void demo6() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        // ͶӰ��ѯ
        // ��������
        /*
         * List<Object> list = session.createQuery(
         * "select c.cust_name from Customer c").list(); for (Object object :
         * list) { System.out.println(object); }
         */

        // �������:
        /*
         * List<Object[]> list = session.createQuery(
         * "select c.cust_name,c.cust_source from Customer c").list(); for
         * (Object[] objects : list) {
         * System.out.println(Arrays.toString(objects)); }
         */

        // ��ѯ������ԣ����������װ�������С�
        List<Customer> list = session.createQuery("select new Customer(cust_name,cust_source) from Customer").list();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        tx.commit();
    }

    @Test
    /**
     * ��ҳ��ѯ
     */
    public void demo7() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        // ��ҳ��ѯ
        Query query = session.createQuery("from LinkMan");
        query.setFirstResult(20);
        query.setMaxResults(10);
        List<LinkMan> list = query.list();

        for (LinkMan linkMan : list) {
            System.out.println(linkMan);
        }
        tx.commit();
    }

    @Test
    /**
     * ����ͳ�Ʋ�ѯ
     */
    public void demo8() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        // �ۺϺ�����ʹ�ã�count(),max(),min(),avg(),sum()
        Object object = session.createQuery("select count(*) from Customer").uniqueResult();
        System.out.println(object);
        // ����ͳ�ƣ�
        List<Object[]> list = session.createQuery("select cust_source,count(*) from Customer group by cust_source")
                .list();
        for (Object[] objects : list) {
            System.out.println(Arrays.toString(objects));
        }
        tx.commit();
    }

    @Test
    /**
     * HQL�Ķ���ѯ
     */
    public void demo9() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        // SQL:SELECT * FROM cst_customer c INNER JOIN cst_linkman l ON
        // c.cust_id = l.lkm_cust_id;
        // HQL:������ from Customer c inner join c.linkMans
		
		 /*List<Object[]> list = session.createQuery(
		 "from Customer c inner join c.linkMans").list(); for (Object[]
		 objects : list) { System.out.println(Arrays.toString(objects)); }*/


        // HQL:���������� ��ʵ������ͨ��������inner join�����һ���ؼ���fetch. from Customer c inner
        // join fetch c.linkMans
        List<Customer> list = session.createQuery("select distinct c from Customer c inner join fetch c.linkMans")
                .list();// ֪ͨhibernate������һ����������ݷ�װ���ö�����

        for (Customer customer : list) {
            System.out.println(customer);
        }
        tx.commit();
    }
}
