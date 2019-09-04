package com.s5.struts2.valuestack;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.s5.struts2.entity.User;

/**
 * 操作值栈：方法二：调用值栈中的方法实现
 **/
public class ValueStackDemo4 extends ActionSupport {
    @Override
    public String execute() throws Exception {
        // 像值栈中保存数据
        //获得值栈对象
        ValueStack valueStack = ActionContext.getContext().getValueStack();
        //使用push(Object obj); set(String key,Object obj);
        User user = new User("赵红", "38");
        //现在user在站的顶部
        valueStack.push(user);

        valueStack.set("username", "邓志龙");//创建了一个map集合，将map压入栈中
        return super.execute();
    }
}
