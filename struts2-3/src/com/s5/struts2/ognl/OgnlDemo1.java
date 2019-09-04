package com.s5.struts2.ognl;

import org.junit.Test;

import com.s5.struts2.entity.User;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

/**
 * OGNL在java环境下的使用
 **/
public class OgnlDemo1 {

    //OGNL调用对象的方法
    @Test
    public void demo1() throws OgnlException {
        //获得context
        OgnlContext context = new OgnlContext();
        //获得根对象
        Object root = context.getRoot();
        //执行表达式
        Object object = Ognl.getValue("'helloworld'.length()", context, root);
        System.out.println(object);

    }

    //访问静态方法
    @Test
    public void demo2() throws OgnlException {
        //获得context
        OgnlContext context = new OgnlContext();
        //获得根对象
        Object root = context.getRoot();
        //执行表达式
        Object object = Ognl.getValue("@java.lang.Math@random()", context, root);
        System.out.println(object);

    }

    //访问root中的数据 不需要加#
    @Test
    public void demo3() throws OgnlException {
        //获得context
        OgnlContext context = new OgnlContext();
        //执行表达式:@类名@方法名
        User user = new User("aaa", "123");
        context.setRoot(user);
        //获得根对象
        Object root = context.getRoot();
        Object name = Ognl.getValue("name", context, root);
        Object password = Ognl.getValue("password", context, root);
        System.out.println(name + " " + password);

    }

    //访问context中的数据 不需要加#
    @Test
    public void demo4() throws OgnlException {
        //获得context
        OgnlContext context = new OgnlContext();
        //获得根对象
        Object root = context.getRoot();
        //向context中存入数据
        context.put("name", "赵红");
        //执行表达式:@类名@方法名

        Object obj = Ognl.getValue("#name", context, root);
        System.out.println(obj);

    }

}
