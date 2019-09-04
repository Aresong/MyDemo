package com.s5.web.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.s5.entity.Customer;
import com.s5.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    private CustomerService customerService;

    private Customer customer = new Customer();

    @Override
    public Customer getModel() {
        // TODO Auto-generated method stub
        return customer;
    }

    /**
     * 跳转到添加页面的方法
     **/
    public String saveUI() {
        return "saveUI";
    }

    public String save() {
        //创建一个工厂类
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        customerService = (CustomerService) applicationContext.getBean("customerService");
        System.out.println("customerService被执行了……");
        customerService.save(customer);
        return NONE;
    }
}
