package com.s5.struts2.valuestack;
/**
 * ValueStack的内部结构
 **/


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackDemo1 extends ActionSupport {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String execute() throws Exception {
        // 获取值栈
        ValueStack valueStack = ActionContext.getContext().getValueStack();

        return SUCCESS;
    }
}
