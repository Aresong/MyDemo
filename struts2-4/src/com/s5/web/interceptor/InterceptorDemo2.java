package com.s5.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 自定义拦截器1
 **/
public class InterceptorDemo2 extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        System.out.println("Interceptor2执行了……");
        String obj = invocation.invoke();
        System.out.println("Interceptor2执行结束了……");
        return obj;
    }

}
