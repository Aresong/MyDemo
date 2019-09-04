package com.s5.struts2.valuestack;

import com.opensymphony.xwork2.ActionSupport;
import com.s5.struts2.entity.User;

/**
 * 操作ValeStack:方式一利用Action本身在值栈中的特性来实现的
 **/
public class ValueStackDemo3 extends ActionSupport {

    private User user;

    public User getUser() {
        return user;
    }

    @Override
    public String execute() throws Exception {
        // 向ValueStack中存值
        //默认情况下，将Action对象压入值栈。Action的属性？（也会在值栈中）
        user = new User("李冰", "222");
        return SUCCESS;
    }
}
