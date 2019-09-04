package cn.declaresystem.ssm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import cn.declaresystem.ssm.pojo.Enterprise;
import cn.declaresystem.ssm.service.EnterpriseUserService;

@Controller
@RequestMapping("/EnterpriseUser/")
public class loginController {
    @Resource
    private EnterpriseUserService userService;

    @RequestMapping(value = "login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "loginEnterpriseUser")
    public String loginEnterpriseUser(@RequestParam(value = "code") String code, @RequestParam(value = "password") String password, Model model, HttpSession session) {
        Enterprise enterprise = userService.getEnterpriseByCode(code);
        if (null == enterprise) {
            model.addAttribute("codeerr", "�û������벻��ȷ");
            return "login";
        } else {
            if (password.equals(enterprise.getPassword())) {
                session.setAttribute("enterpriseObject", enterprise);
                return "redirect:/listCtrl/getState";
            } else {
                model.addAttribute("passworderr", "�������벻��ȷ");
                return "login";
            }
        }
    }

    @RequestMapping(value = "register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "add")
    public String add(Enterprise enterprise, String checkPassword, Model model, HttpSession session) {
        boolean result = true;
        if (null == enterprise.getCode() || "".equals(enterprise.getCode())) {
            result = false;
        }
        if (null != userService.getEnterpriseByCode(enterprise.getCode())) {
            result = false;
        }
        if (null == enterprise.getName() || "".equals(enterprise.getName())) {
            result = false;
        }
        if (null == enterprise.getLicense() || "".equals(enterprise.getLicense())) {
            result = false;
        }
        if (null == enterprise.getPassword() || "".equals(enterprise.getPassword())) {
            result = false;
        }
        if (!checkPassword.equals(enterprise.getPassword())) {
            result = false;
        }
        if (true == result) {
            userService.saveEnterpriseUser(enterprise);
            Enterprise _enterprise = userService.getEnterpriseByCode(enterprise.getCode());
            session.setAttribute("enterpriseObject", _enterprise);
            return "redirect:/listCtrl/getState";
        } else {
            model.addAttribute("registerErr", "ע��ʧ�ܣ���˶Ժ�����ע����Ϣ�Ƿ���ȷ!");
            return "register";
        }
    }

    @RequestMapping(value = "checkEnterprise")
    @ResponseBody
    //produces={"application/json;charset=UTF-8"}���������������
    public Object checkEnterprise(@RequestParam(value = "code") String code) {
        boolean result = false;
//		System.out.println(code);
//		Enterprise enterprise = userService.getEnterpriseByCode(code);
//		System.out.println(enterprise.getPassword());
        if (null != userService.getEnterpriseByCode(code)) {
            result = true;
        }
//		model.addAttribute("error", "�û�������");
        return JSONArray.toJSONString(result);
    }

    @RequestMapping(value = "ErrorPage")
    public String ErrorPage() {
        return "401";
    }
}


