package com.s5.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 自定义拦截器1
 **/
public class InterceptorDemo1 extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        System.out.println("Interceptor1执行了……");
        String obj = invocation.invoke();
        System.out.println("Interceptor1执行结束了……");
        return obj;
    }

}
