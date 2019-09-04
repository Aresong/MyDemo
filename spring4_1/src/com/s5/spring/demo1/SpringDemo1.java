package com.s5.spring.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Spring的入门
 **/
public class SpringDemo1 {
    @Test
    /**
     *	传统方式的调用
     * **/
    public void demo1() {
        UserDao userDao = new UserDaoImpl();
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        userDaoImpl.setName("王尼玛");
        userDaoImpl.save();
    }

    @Test
    /**
     *	Spring方式的调用
     * **/
    public void demo2() {
        //创建Spring的工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.save();

    }

    @Test
    /**
     * 加载磁盘上的配置文件
     */
    public void demo3() {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("C:\\applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.save();
    }
}
