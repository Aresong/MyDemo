package com.s5.struts2.demo1;

import java.util.Arrays;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RequestDemo1 extends ActionSupport {
    @Override
    public String execute() throws Exception {
        // 1.接收参数：
        //利用Struts2中的对象ActionContext对象
        ActionContext context = ActionContext.getContext();
        //调用ActionContext中的方法
        //类似于request.getParameterMap();
        Map<String, Object> map = context.getParameters();
        for (String key : map.keySet()) {
            String[] values = (String[]) map.get(key);
            System.out.println(key + "" + Arrays.toString(values));
        }

        //2.向域对象中存入数据
        context.put("reqName", "reqValue");//相当于request.setAttribute();
        context.getSession().put("sessName", "sessValue");//相当于session.setAttribute();
        context.getApplication().put("appName", "appValue");//相当于application.setAttribute();
        return SUCCESS;
    }
}
