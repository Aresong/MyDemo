package com.s5.crm.web.action;

import org.hibernate.criterion.DetachedCriteria;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.s5.crm.entity.Customer;
import com.s5.crm.entity.PageBean;
import com.s5.crm.service.CustomerService;

/**
 * @author Aresong
 * 客户管理的action类
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    //模型驱动使用的对象
    private Customer customer = new Customer();

    //注入service
    private CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    //使用set方法的方式接收数据
    private Integer curPage = 1;
    private Integer pageSize = 3;

    //使用set方法接收每页显示记录数
    public void setCurPage(Integer curPage) {
        if (curPage == null) {
            curPage = 1;
        }
        this.curPage = curPage;
    }


    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            pageSize = 3;
        }
        this.pageSize = pageSize;
    }


    @Override
    public Customer getModel() {
        return customer;
    }

    //客户管理：跳转到页面的方法
    public String saveUI() {
        //查询字典数据
        return "saveUI";
    }

    //保存客户的方法:save
    public String save() {
        customerService.save(customer);
        return NONE;
    }

    //分页查询客户的方法：findAll
    public String findAll() {
        //接受参数：分页参数
        //最好使用DetchedCriteria对象（条件查询--带分页）
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        //调用业务层查询
        PageBean<Customer> pageBean = customerService.findByPage(detachedCriteria, curPage, pageSize);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }

}
