package demo1;

import java.util.Arrays;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import utils.HibernateUtils;

/**
 * Hibernate�Ĺ�����Ĳ���
 **/
public class HibernateDemo2 {

    //����
    @Test
    public void demo1() {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        Customer customer = new Customer();
        customer.setCust_name("����");
        session.save(customer);
        tx.commit();
        session.close();
    }

    //��ѯ
    //*****get������load����������

    /**
     * get����
     * * ���õ����������أ�ִ�е����д����ʱ�򣬾ͻ����Ϸ���SQL���ȥ��ѯ��
     * * ��ѯ�󷵻�����ʵ������
     * * ��ѯһ���Ҳ����Ķ����ʱ�򣬷���null
     * <p>
     * load����
     * * ���õ����ӳټ��أ�lazy�����أ���ִ�е����д����ʱ�򣬲��ᷢ��SQL��䣬������ʹ����������ʱ��Żᷢ��SQL��䡣
     * * ��ѯ�󷵻ص��Ǵ������javassist-3.18.1-GA.jar ����javassist���������Ĵ���
     * * ��ѯһ���Ҳ����Ķ����ʱ�򣬷���ObjectNotFoundException
     */
    @Test
    public void demo2() {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        //ʹ��get������ѯ
        //Customer customer = session.get(Customer.class, 1l);
        //ʹ��load������ѯ
        Customer customer = session.load(Customer.class, 2l);
        System.out.println(customer);
        tx.commit();
        session.close();
    }

    //�޸�
    @Test
    public void demo3() {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // ֱ�Ӵ������󣬽����޸�  ����ǹ������
		/*Customer customer = new Customer();
		customer.setCust_id(1l);
		customer.setCust_name("����");
		session.update(customer);*/

        // �Ȳ�ѯ�����޸�(�Ƽ�)
        Customer customer = session.get(Customer.class, 1l);
        customer.setCust_name("��С��");
        session.update(customer);

        tx.commit();
        session.close();
    }

    //ɾ��
    @Test
    public void demo4() {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // ֱ�Ӵ�������ɾ��
	/*	Customer customer = new Customer();
		customer.setCust_id(1l);
		session.delete(customer);*/

        // �Ȳ�ѯ��ɾ��(�Ƽ�)--����ɾ��
        Customer customer = session.get(Customer.class, 2l);
        session.delete(customer);

        tx.commit();
        session.close();
    }

    @Test
    // ��������
    public void demo5() {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
		
		/*Customer customer  = new Customer();
		customer.setCust_name("����");
		session.saveOrUpdate(customer);*/

        Customer customer = new Customer();
        customer.setCust_id(3l);
        customer.setCust_name("���绨");
        session.saveOrUpdate(customer);

        tx.commit();
        session.close();
    }

    @Test
    // ��ѯ����
    public void demo6() {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // ����HQL��Hibernate Query Language �������Ĳ�ѯ����,�������Customer�Ƕ����Ǳ���������
		/*Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}*/

        // ����SQL�������治�Ƕ����Ǳ���������
        SQLQuery query = session.createSQLQuery("select * from cst_customer");
        List<Object[]> list = query.list();
        for (Object[] objects : list) {
            System.out.println(Arrays.toString(objects));
        }
        tx.commit();
        session.close();
    }
}
