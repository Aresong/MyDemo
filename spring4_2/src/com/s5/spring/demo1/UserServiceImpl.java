package com.s5.spring.demo1;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService")//相当于//相当于<bean id="userService" class="com.s5.spring.demo1.UserDaoServiceImpl">
public class UserServiceImpl implements UserService {

    //Autowired设置对象类型的属性的值。但是按照类型完成属性的注入。
    //因为UserDaoImpl的类型是UseDao，而UserService中需要的类型也是UserDao，他就会把UserDaoImpl所生成的对象的实例设置到UserDao
    //我们的习惯是按照名称完成属性注入：必须让@Autowired注解和

    //@Autowired
    //@Qualifier(value="userDao222")//强制按名称来完成属性的注入

    //以上两个注解有一个替代的注解，这个注解不是由Spring提供的，而是由Spring的一套规范提供的
    //@Resource完成对象类型的属性的注入，按照名称完成属性注入
    @Resource(name = "userDao222")
    private UserDao userDao;

    @Override
    public void save() {
        System.out.println("UserService的save方法被执行了！！");
        userDao.save();
    }

}
