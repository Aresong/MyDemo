package com.s5.struts2.demo1;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

/**
 * 访问Servlet的API的方式三：接口注入的的方式
 *
 * **/
import com.opensymphony.xwork2.ActionSupport;

public class RequestDemo3 extends ActionSupport implements ServletRequestAware, ServletContextAware {

    private HttpServletRequest request;
    private ServletContext context;

    public RequestDemo3() {
        super();
        System.out.println("RequestDemo3被创建了...");
    }

    @Override
    public String execute() throws Exception {
        //一、接收参数
        //通过接口注入的方式获得request对象
        Map<String, String[]> map = request.getParameterMap();
        for (String key : map.keySet()) {
            String[] values = (String[]) map.get(key);
            System.out.println(key + " " + Arrays.toString(values));
        }

        // 2、向域对象中保存数据
        // 向request中保存数据:
        request.setAttribute("reqName", "reqValue");
        // 向session中保存数据
        request.getSession().setAttribute("sessName", "sessValue");
        // 向application中保存数据
        context.setAttribute("appName", "appValue");
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void setServletContext(ServletContext context) {
        this.context = context;

    }

}
