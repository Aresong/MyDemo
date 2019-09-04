package com.s5.struts.demo2;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action的编写方式三： Action类集成ActionSupport类
 * 推荐使用ActionSupport方式
 * *ActionSupport中提供了数据校验，国际化等一系列操作方式
 **/
public class ActionDemo3 extends ActionSupport {
    @Override
    public String execute() throws Exception {
        System.out.println("ActionDemo3被执行了……");
        return NONE;
    }
}
