package com.s5.struts2.valuestack;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.s5.struts2.entity.User;

public class ValueStackDemo5 extends ActionSupport {
    @Override
    public String execute() throws Exception {
        // 向值栈中保存一个对象
        User user = new User("aaa", "123");
        ActionContext.getContext().getValueStack().push(user);
        //向值栈中保存一个集合
        List<User> list = new ArrayList<User>();
        list.add(new User("aaa", "111"));
        list.add(new User("bbb", "222"));
        list.add(new User("ccc", "333"));
        ActionContext.getContext().getValueStack().set("list", list);

        //向context中存入数据
        ServletActionContext.getRequest().setAttribute("username", "r李冰");
        ServletActionContext.getRequest().getSession().setAttribute("username", "s李冰");
        ServletActionContext.getServletContext().setAttribute("username", "a李冰");
        return super.execute();
    }
}
