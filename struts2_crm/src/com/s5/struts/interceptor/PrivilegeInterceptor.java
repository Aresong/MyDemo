package com.s5.struts.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.s5.struts.entity.User;

/**
 * 权限拦截器
 **/
public class PrivilegeInterceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation invocation) throws Exception {
        // 判断session中是否存在数据
        User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
        //判断从Session中获得的用户信息是否为空
        if (existUser == null) {
            //没有登录
            //给出提示信息
            ActionSupport actionSupport = (ActionSupport) invocation.getAction();
            actionSupport.addActionError("没有登录！没有权限访问！");
            //跳到登录页面
            return actionSupport.LOGIN;
        } else {
            //已登录
            return invocation.invoke();
        }
    }

}
