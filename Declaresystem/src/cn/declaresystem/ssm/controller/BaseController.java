package cn.declaresystem.ssm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.declaresystem.ssm.pojo.BasicInfo;
import cn.declaresystem.ssm.pojo.Enterprise;
import cn.declaresystem.ssm.service.BaseService;

@Controller
@RequestMapping("/register/")
public class BaseController {
    @Resource
    private BaseService baseService;

    @RequestMapping(value = "base")
    public String base(HttpSession session, Model model, String pe_id) {
        Integer id = ((Enterprise) session.getAttribute("enterpriseObject")).getId();
        BasicInfo basicInfo = baseService.getBasicByGR_Id(id);
        if (null == basicInfo) {
            basicInfo = new BasicInfo();
            basicInfo.setGr_id(id);
        }
        model.addAttribute("basicInfo", basicInfo);
        return "base";
    }

    @RequestMapping(value = "update")
    public String update(BasicInfo basicInfo) {
        baseService.updateBasicInfo(basicInfo);
        return "redirect:/listCtrl/getState";
    }
}
