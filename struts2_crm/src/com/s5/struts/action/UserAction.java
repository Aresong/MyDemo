package com.s5.struts.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.s5.struts.entity.User;
import com.s5.struts.service.UserService;
import com.s5.struts.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    //接受数据
    private User user = new User();

    /**
     * 用户登录的方法
     **/
    public String login() {
        System.out.println(user);
        //调用业务层
        UserService userService = new UserServiceImpl();
        User existUser = userService.login(user);
        //根据结果页面跳转
        if (existUser == null) {
            //登录失败
            //ActionError、FieldError、ActionMessage
            this.addActionError("用户名或密码错误");
            return LOGIN;
        } else {
            //登陆成功
            //ActionContext.getContext().getSession().put("existUser", existUser);
            ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
            return SUCCESS;
        }
    }

    @Override
    public User getModel() {
        // TODO Auto-generated method stub
        return user;
    }
}
