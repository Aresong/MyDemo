package com.s5.struts2.demo3;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.s5.struts2.entity.Product;

/**
 * 复杂类型的数据封装：封装到Map集合
 *
 * @author jt
 */
public class ProductAction2 extends ActionSupport {
    private Map<String, Product> products;

    public Map<String, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<String, Product> products) {
        this.products = products;
    }

    @Override
    public String execute() throws Exception {
        for (String key : products.keySet()) {
            System.out.println(key + " " + products.get(key));
        }
        return NONE;
    }
}
