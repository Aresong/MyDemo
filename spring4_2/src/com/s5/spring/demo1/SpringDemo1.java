package com.s5.spring.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring注解开发的测试类
 **/
public class SpringDemo1 {
    @Test
    /**
     * 传统方式
     * **/
    public void demo1() {
        UserDaoImpl userDao = new UserDaoImpl();
        //userDao.setName("oliver");
        userDao.save();
    }

    @Test
    /**
     * Spring的IOC注解方式
     * 使用注解方式是可以没有set方法的！！！
     * 属性如果有set方法，需要将属性注入的注解添加到set方法
     * **/
    public void demo2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.save();
    }

    @Test
    /**
     * Spring的IOC注解方式
     * 使用注解方式是可以没有set方法的！！！
     * 属性如果有set方法，需要将属性注入的注解添加到set方法
     * **/
    public void demo3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
    }
}


