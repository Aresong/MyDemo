package com.s5.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.s5.hibernate.entity.Customer;
import com.s5.hibernate.entity.LinkMan;
import com.s5.hibernate.utils.HibernateUtils;

public class hibernateDemo1 {

    @Test
    public void demo1() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        //创建两个客户
        Customer customer1 = new Customer();
        customer1.setCust_name("王冕");
        Customer customer2 = new Customer();
        customer2.setCust_name("王华");

        //创建三个联系人
        LinkMan linkMan1 = new LinkMan();
        linkMan1.setLkm_name("周瑞发");
        LinkMan linkMan2 = new LinkMan();
        linkMan2.setLkm_name("陈景瑞");
        LinkMan linkMan3 = new LinkMan();
        linkMan3.setLkm_name("赵国才");

        //设置关系：
        linkMan1.setCustomer(customer1);
        linkMan2.setCustomer(customer1);
        linkMan3.setCustomer(customer2);
        customer1.getLinkMans().add(linkMan1);
        customer1.getLinkMans().add(linkMan2);
        customer2.getLinkMans().add(linkMan3);

        //保存数据：
        session.save(customer1);
        session.save(customer2);
        session.save(linkMan1);
        session.save(linkMan2);
        session.save(linkMan3);

        tx.commit();
    }

    @Test
    // 一对多关系只保存一边是否可以
    public void demo2() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCust_name("赵洪");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkm_name("如花");
        customer.getLinkMans().add(linkMan);
        linkMan.setCustomer(customer);

        // 只保存一边是否可以：不可以，报一个瞬时对象异常：持久态对象关联了一个瞬时态对象。
        // session.save(customer);
        session.save(linkMan);

        tx.commit();
    }

    @Test
    /**
     *  级联保存或更新操作：
     *  * 保存客户级联联系人，操作的主体是客户对象，需要在Customer.hbm.xml中进行配置
     *  * <set name="linkMans" cascade="save-update">
     */
    public void demo3() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCust_name("赵洪");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkm_name("如花");

        customer.getLinkMans().add(linkMan);
        //linkMan.setCustomer(customer);

        session.save(customer);

        tx.commit();
    }

    @Test
    /**
     *  级联保存或更新操作：
     *  * 保存联系人级联客户，操作的主体是联系人对象，需要在LinkMan.hbm.xml中进行配置
     *  * <many-to-one name="customer" cascade="save-update" class="com.s5.hibernate.domain.Customer" column="lkm_cust_id"/>
     */
    public void demo4() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCust_name("孙悟空");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkm_name("如来");

        //customer.getLinkMans().add(linkMan);
        linkMan.setCustomer(customer);

        session.save(linkMan);

        tx.commit();
    }

    @Test
    /**
     * 测试对象的导航
     * * 前提：一对多的双方都设置cascade="save-update"
     */
    public void demo5() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCust_name("李兵");

        LinkMan linkMan1 = new LinkMan();
        linkMan1.setLkm_name("凤姐");
        LinkMan linkMan2 = new LinkMan();
        linkMan2.setLkm_name("如花");
        LinkMan linkMan3 = new LinkMan();
        linkMan3.setLkm_name("芙蓉");

        // 双方都设置了cascade
//		session.save(linkMan1); // 发送几条insert语句  4条
//		session.save(customer); // 发送几条insert语句  3条
        session.save(linkMan2); // 发送几条insert语句  1条,设置lkm_cust_id不能为空就报错了！

        tx.commit();
    }

    @Test
    /**
     * 级联删除：
     * * 删除客户级联删除联系人，删除的主体是客户，需要在Customer.hbm.xml中配置
     * * <set name="linkMans" cascade="delete">
     */
    public void demo6() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        // 没有设置级联删除，默认情况:修改了联系人的外键，删除客户
		/*Customer customer = session.get(Customer.class, 1l);
		session.delete(customer);*/

        // 删除客户，同时删除联系人
        Customer customer = session.get(Customer.class, 10l);
        session.delete(customer);

        tx.commit();
    }

    @Test
    /**
     * 级联删除：
     * * 删除联系人级联删除客户，删除的主体是联系人，需要在LinkMan.hbm.xml中配置
     * * <many-to-one name="customer" cascade="delete">
     */
    public void demo7() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        // 删除客户，同时删除联系人
        LinkMan linkMan = session.get(LinkMan.class, 13l);
        session.delete(linkMan);

        tx.commit();
    }

    @Test
    /**
     * 将2号联系人原来归1号客户，现在改为2号客户
     */
    public void demo8() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        // 查询2号联系人
        LinkMan linkMan = session.get(LinkMan.class, 2l);
        // 查询2号客户
        Customer customer = session.get(Customer.class, 2l);
        // 双向的关联
        linkMan.setCustomer(customer);
        customer.getLinkMans().add(linkMan);

        tx.commit();
    }

    @Test
    /**
     * 区分cascade和inverse的区别
     */
    public void demo9() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCust_name("李兵");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkm_name("凤姐");

        customer.getLinkMans().add(linkMan);

        // 条件在Customer.hbm.xml上的set中配置了cascade="save-update" inverse="true"
        session.save(customer); // 客户会插入到数据库，联系人也会插入到数据库，但是外键为null

        tx.commit();
    }


}
