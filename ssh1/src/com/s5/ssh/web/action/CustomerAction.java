package com.s5.ssh.web.action;

/*import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;*/

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.s5.ssh.entity.Customer;
import com.s5.ssh.service.CustomerService;

/**
 * 客户管理的Action类
 **/
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    private static final long serialVersionUID = 1L;

    //模型驱动使用的对象
    private Customer customer = new Customer();

    //注入CustomerService
    private CustomerService customerService;

    @Override
    public Customer getModel() {
        return customer;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * 保存客户的方法：save
     **/
    public String save() {
        //传统方式
        //如果web层没有使用Struts2，获取业务层的类必须如下进行编写
		/*WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
		CustomerService customerService = (CustomerService) applicationContext.getBean("customerService");*/
        System.out.println("Action中的save方法执行了……");
        System.out.println(customer);
        customerService.save(customer);
        return NONE;
    }

}
