package com.s5.spring.demo2;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo2 {

    @Test
    public void demo1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        CustomerService customerService1 = (CustomerService) applicationContext.getBean("customerService");
        System.out.println(customerService1);

        CustomerService customerService2 = (CustomerService) applicationContext.getBean("customerService");
        System.out.println(customerService2);

        System.out.println(customerService1 == customerService2);
        applicationContext.close();
    }
}

