package com.s5.struts2.demo1;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

/**
 *
 * 访问Servlet的API的方式二：原生的方式
 * **/
import com.opensymphony.xwork2.ActionSupport;

public class RequestDemo2 extends ActionSupport {
    @Override
    public String execute() throws Exception {
        //1.接受数据
        //直接获得request对象，通过ServletActionCentext
        HttpServletRequest request = ServletActionContext.getRequest();
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
        ServletActionContext.getServletContext().setAttribute("appName", "appValue");
        return SUCCESS;
    }
}
