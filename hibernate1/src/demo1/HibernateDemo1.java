package demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


public class HibernateDemo1 {

    @Test
    //����ͻ��İ���
    public void demo1() {
        //1.����hibernate���������ļ�
        Configuration configuration = new Configuration().configure();
        //2.����һ��sessionFactory������JDBC�е����ӳ�
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //3.ͨ��SessionFactory��ȡ��Session����������JDBC�е�Connection
        Session session = sessionFactory.openSession();
        //4.�ֶ���������
        Transaction transaction = session.beginTransaction();
        //5.��д����
        Customer customer = new Customer();
        customer.setCust_name("�Դ���2");
        session.save(customer);
        System.out.println("����2");
        //6.�ύ����
        transaction.commit();
        //7.�ͷ���Դ
        session.close();
    }
}
