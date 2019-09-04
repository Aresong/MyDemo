package com.s5.spring.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * 用户Dao实现类
 **/
//@Component(value="userDao")//相当于<bean id="userDao" class="com.s5.spring.demo1.UserDaoImpl">
@Repository("userDao222")//在这里相当于@Component(value="userDao")
public class UserDaoImpl implements UserDao {

    /**
     * 没有set方法，直接把Value注解放在定义上面
     **/
    @Value("王东")//相当于<bean id="userDao" class="com.s5.spring.demo1.UserDaoImpl" p:name="王东">
    private String name;

    /**
     * 这是有set方法的情况
     **/
//	@Value("王东")
//	public void setName(String name) {
//		this.name = name;
//	}
    @Override
    public void save() {
        System.out.println("保存用户的方法执行了！" + "" + name);
    }

}
