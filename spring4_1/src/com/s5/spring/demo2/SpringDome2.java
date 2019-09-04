package com.s5.spring.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDome2 {

    @Test
    /**
     *
     * 生命周期的配置
     *
     * **/

    public void demo1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerDao customerDao = (CustomerDao) applicationContext.getBean("customerDao");
        customerDao.save();
        applicationContext.close();
    }

    @Test
    /**
     *
     * Bean的作用范围的配置
     *
     * **/

    public void demo2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerDao customerDao1 = (CustomerDao) applicationContext.getBean("customerDao");
        System.out.println(customerDao1);
        CustomerDao customerDao2 = (CustomerDao) applicationContext.getBean("customerDao");
        System.out.println(customerDao2);
        System.out.println(customerDao1 == customerDao2);
        applicationContext.close();//多例工厂关闭也不销毁
    }
}
