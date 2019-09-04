package cn.declaresystem.ssm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.declaresystem.ssm.pojo.Enterprise;

import cn.declaresystem.ssm.service.PrintService;

@Controller
@RequestMapping("/printCtrl/")
public class PrintController {

    @Resource
    private PrintService printService;


    @RequestMapping(value = "printChart")
    public String printChart(HttpSession session, Model model) {
        Integer gr_id = ((Enterprise) session.getAttribute("enterpriseObject")).getId();
        String chartName = printService.getChartName(gr_id);
        model.addAttribute("chartName", chartName);
        return "printChart";
    }

    @RequestMapping(value = "printExcel")
    public String printExcel(HttpSession session, HttpServletRequest request) {
        Enterprise enterprise = (Enterprise) session.getAttribute("enterpriseObject");
        printService.printExcel(enterprise, request);
        return "print";
    }
}
