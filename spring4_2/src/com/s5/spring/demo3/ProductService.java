package com.s5.spring.demo3;

import javax.annotation.Resource;

public class ProductService {
    @Resource(name = "productDao")
    private ProductDao productDao;
    @Resource(name = "orderDao")
    private OrderDao orderDao;

    public void save() {
        productDao.save();
        orderDao.save();
    }
}
