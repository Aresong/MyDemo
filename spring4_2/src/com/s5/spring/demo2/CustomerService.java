package com.s5.spring.demo2;
/**
 * 生命周期相关的注解
 **/

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("customerService")
@Scope("prototype")
public class CustomerService {
    @PostConstruct//相当于init-method
    public void init() {
        System.out.println("CustomerService的被初始化了……");
    }

    public void save() {
        System.out.println("Service的save方法执行了……");
    }

    @PreDestroy//相当于destroy-method
    public void destroy() {
        System.out.println("CustomerService的被销毁了……");
    }
}
