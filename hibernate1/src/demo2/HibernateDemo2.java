package demo2;

import java.io.Serializable;

/**
 *
 * ����Hibernate��һ������
 *
 * **/
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import demo1.Customer;
import utils.HibernateUtils;

public class HibernateDemo2 {
    @Test
    public void demo1() {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        Customer customer1 = session.get(Customer.class, 1l);//����SQL���
        System.out.println(customer1);
        Customer customer2 = session.get(Customer.class, 1l);//������SQL���
        System.out.println(customer2);
        System.out.println(customer1 == customer2);

        Customer customer3 = new Customer();
        customer3.setCust_name("����������");
        Serializable id = session.save(customer3);
        Customer customer4 = session.get(Customer.class, id);//������SQL���
        System.out.println(customer4);

        tx.commit();
        session.close();
    }

    @Test
    //һ������Ŀ�����
    public void demo2() {

        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        Customer customer = session.get(Customer.class, 1l);
        customer.setCust_name("������");

        tx.commit();
        session.close();

    }
}
