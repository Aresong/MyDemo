package com.s5.ssh.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.s5.ssh.entity.Customer;
import com.s5.ssh.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SSHDemo1 {

    @Resource(name = "customerService")
    private CustomerService customerService;

    @Test
    //修改
    public void demo1() {
        Customer customer = customerService.findById(1l);
        customer.setCust_name("tom");
        customerService.update(customer);
    }

    @Test
    //修改
    public void demo2() {
        Customer customer = customerService.findById(2l);
        customerService.delete(customer);
    }

    @Test
    //查询1
    public void demo3() {
        List<Customer> list = customerService.findByHQL();
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    @Test
    //查询2
    public void demo4() {
        List<Customer> list = customerService.findByQBC();
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    @Test
    //通过自定义方法名查询2
    public void demo5() {
        List<Customer> list = customerService.findByNameQuery();
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }
}
