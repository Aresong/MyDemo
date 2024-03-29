package com.s5.crm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.s5.common.utils.Page;
import com.s5.crm.pojo.BaseDict;
import com.s5.crm.pojo.Customer;
import com.s5.crm.pojo.QueryVo;
import com.s5.crm.service.BaseDictService;
import com.s5.crm.service.CustomerService;

@Controller
@RequestMapping(value = "/customer/")
public class CustomerController {

    @Value("${BaseDict.fromTypeCode}")
    private String fromTypeCode;

    @Resource
    private BaseDictService baseDictService;
    @Resource
    private CustomerService customerService;

    //入口
    @RequestMapping(value = "list")
    public String list(QueryVo vo, Model model) {

        List<BaseDict> fromType = baseDictService.selectDictByCode(fromTypeCode);
        List<BaseDict> industryType = baseDictService.selectDictByCode("001");
        List<BaseDict> levelType = baseDictService.selectDictByCode("006");

        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);


        //通过四个条件查询分页对象
        Page<Customer> page = customerService.selectPageByQueryVo(vo);
        model.addAttribute("page", page);

        return "customer";
    }

    //去修改页面
    @RequestMapping(value = "edit.action")
    public @ResponseBody
    Customer edit(Integer id) {
        Customer customer = customerService.selectCustomerById(id);
        return customer;
    }

    //修改保存
    @RequestMapping(value = "update.action")
    public @ResponseBody
    String update(Customer customer) {
        customerService.updateCustomerById(customer);
        return "OK";
    }

    //删除
    @RequestMapping(value = "delete.action")
    public @ResponseBody
    String delete(Integer id) {
        customerService.deleteCustomerById(id);
        return "OK";
    }

}
