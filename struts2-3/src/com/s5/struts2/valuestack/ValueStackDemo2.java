package com.s5.struts2.valuestack;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
/**
 *
 * 获得ValueStack对象
 *
 * **/
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackDemo2 extends ActionSupport {
    @Override
    public String execute() throws Exception {
        //第一种:通过ActionContext获得：
        ActionContext context = ActionContext.getContext();
        ValueStack valueStack1 = context.getValueStack();
        //第二种:通过request对象获得
        //ServletActionContext.getRequest().getAttribute("struts.valueStack");
        ValueStack valueStack2 = (ValueStack) ServletActionContext.getRequest().getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
        System.out.println(valueStack1 == valueStack2);
        return NONE;
    }
}
