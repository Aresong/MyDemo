package com.s5.struts.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.s5.struts.entity.Customer;
import com.s5.struts.service.CustomerService;
import com.s5.struts.service.impl.CustomerServiceImpl;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    Customer customer = new Customer();

    public String find() {
        CustomerService customerService = new CustomerServiceImpl();
        List<Customer> list = customerService.find();
        //ServletActionContext.getRequest().setAttribute("list", list);
        //将查询到的list放到值栈中
        ActionContext.getContext().getValueStack().set("list", list);
        return "findSuccess";
    }

    public String saveUI() {
        return "saveUI";
    }

    public String save() {
        CustomerService customerService = new CustomerServiceImpl();
        customerService.save(customer);
        return "saveSuccess";
    }

    @Override
    public Customer getModel() {
        return customer;
    }
}
