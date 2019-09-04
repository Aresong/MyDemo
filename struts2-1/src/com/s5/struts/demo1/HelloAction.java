package com.s5.struts.demo1;

/**
 * Strust2的入门的Action
 **/
public class HelloAction {

    /**
     * 提供一个方法：
     * * 方法签名固定的
     * 共有的 返回值是String类型 方法名execute 在这个方法中不能传递参数。
     */
    public String save() {
        System.out.println("HelloAction执行了……");
        return "success";
    }
}
