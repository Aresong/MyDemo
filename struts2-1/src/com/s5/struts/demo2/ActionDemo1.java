package com.s5.struts.demo2;

/**
 * Action的编写方式：Action类是一个POJO的类
 **/
public class ActionDemo1 {

    public String execute() {
        System.out.println("ActionDemo1被执行了……");
        return null;
    }

}
