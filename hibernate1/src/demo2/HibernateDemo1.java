package demo2;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import demo1.Customer;
import utils.HibernateUtils;

public class HibernateDemo1 {

    @Test
    public void demo1() {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        //Hibernate���־û����Ϊ����״̬
        Customer customer = new Customer();//#����̬����ʱ�־û���û��Ψһ��ʶOID����û�б�session����
        customer.setCust_name("������2");
        Serializable id = session.save(customer);//#�־�̬����ʱ�־û���ӵ����Ψһ�ı�ʶOID����beisession����
        customer = session.get(Customer.class, id);
        tx.commit();
        session.close();
        System.out.println(customer.getCust_name());//#�й�̬����ʱ�־û���ӵ��Ψһ��ʶ����û�б�session������
    }

    @Test
    //�־û�״̬�����Զ��������ݿ�
    public void demo2() {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        Customer customer = session.get(Customer.class, 1l);
        customer.setCust_name("���");
        tx.commit();//�־û�״̬�����Զ��������ݿ�,������ݿ��ж�Ӧ�ֶ�û�з����ı���ִ��update()����
        session.close();

    }

}
