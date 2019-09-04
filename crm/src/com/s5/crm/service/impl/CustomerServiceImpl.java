package com.s5.crm.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.s5.crm.dao.CustomerDao;
import com.s5.crm.entity.Customer;
import com.s5.crm.entity.PageBean;
import com.s5.crm.service.CustomerService;

/**
 * @author Aresong
 * 客户管理service的实现类
 */

@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    //service中保存客户的方法
    @Override
    public void save(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    //业务层分页查询客户的方法
    public PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer curPage, Integer pageSize) {
        PageBean<Customer> pageBean = new PageBean<Customer>();
        //封装当前页数
        pageBean.setCurPage(curPage);
        //封装每页显示记录数
        pageBean.setPageSize(pageSize);
        //封装总记录数
        //调用dao
        Integer totalCount = customerDao.findCount(detachedCriteria);
        pageBean.setTotalCount(totalCount);
        //封装总页数
        Double tc = totalCount.doubleValue();
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());
        //封装每页显示数据的集合
        Integer begin = (curPage - 1) * pageSize;
        List<Customer> list = customerDao.findByPage(detachedCriteria, begin, pageSize);
        pageBean.setList(list);
        return pageBean;
    }
}
