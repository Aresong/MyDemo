package com.s5.spring.demo1;

/**
 * 用户管理业务层实现类
 **/
public class UserDaoImpl implements UserDao {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void save() {
        System.out.println("UserDao执行了……" + " " + name);
    }

}
