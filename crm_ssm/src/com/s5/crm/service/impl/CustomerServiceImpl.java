package com.s5.crm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.s5.common.utils.Page;
import com.s5.crm.mapper.CustomerDao;
import com.s5.crm.pojo.Customer;
import com.s5.crm.pojo.QueryVo;
import com.s5.crm.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerDao customerDao;

    //通过四个条件，查询分页对象
    public Page<Customer> selectPageByQueryVo(QueryVo vo) {
        Page<Customer> page = new Page<Customer>();
        //每页数
        page.setSize(10);
        vo.setSize(10);
        //判断当前页
        if (null != vo) {
            // 判断当前页
            if (null != vo.getPage()) {
                page.setPage(vo.getPage());
                vo.setStartRow((vo.getPage() - 1) * vo.getSize());
            }
            if (null != vo.getCustName() && !"".equals(vo.getCustName().trim())) {
                vo.setCustName(vo.getCustName().trim());
            }
            if (null != vo.getCustSource() && !"".equals(vo.getCustSource().trim())) {
                vo.setCustSource(vo.getCustSource().trim());
            }
            if (null != vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())) {
                vo.setCustIndustry(vo.getCustIndustry().trim());
            }
            if (null != vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())) {
                vo.setCustLevel(vo.getCustLevel().trim());
            }
            //总条数

            System.out.println(vo);
            page.setTotal(customerDao.customerCountByQueryVo(vo));
            page.setRows(customerDao.selectCustomerListByQueryVo(vo));
        }
        return page;

    }

    @Override
    public Customer selectCustomerById(Integer id) {
        return customerDao.selectCustomerById(id);
    }

    @Override
    public void updateCustomerById(Customer customer) {
        customerDao.updateCustomerById(customer);
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerDao.deleteCustomerById(id);
    }
}
