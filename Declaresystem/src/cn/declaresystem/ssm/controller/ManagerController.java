package cn.declaresystem.ssm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.declaresystem.ssm.pojo.Enterprise;
import cn.declaresystem.ssm.pojo.Staff;
import cn.declaresystem.ssm.service.ManagerService;
import cn.declaresystem.ssm.service.StaffService;
import cn.declaresystem.ssm.util.PageSupport;

@Controller
@RequestMapping("/ManagerCtrl/")

public class ManagerController {

    @Resource
    private ManagerService managerService;

    @Resource
    private StaffService staffService;

    @InitBinder
    public void initBinder(WebDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @RequestMapping(value = "getStaffList")
    public String getStaffList(HttpSession session, Model model, String index) {
        HashMap<String, Integer> resultMap = new HashMap<String, Integer>();
        Integer gr_id = ((Enterprise) session.getAttribute("enterpriseObject")).getId();
        Integer totalCount = managerService.getManagerCount(gr_id);
        if (null == index || "".equals(index)) {
            index = "1";
        }
        session.setAttribute("index", index);
        Integer pageIndex = Integer.parseInt(index);
        Integer pageSize = 3;
        PageSupport pageSupport = new PageSupport();
        pageSupport.setTotalCount(totalCount);
        pageSupport.setPageSize(pageSize);
        Integer totalPage = pageSupport.getTotalpage();
        pageSupport.setTotalpage(totalPage);
        pageSupport.setPageIndex(pageIndex);
        pageIndex = pageSupport.getPageIndex();
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currentPageIndex", pageIndex);
        model.addAttribute("totalPage", totalPage);
        resultMap.put("gr_id", gr_id);
        pageIndex = (pageIndex - 1) * pageSize;
        resultMap.put("pageIndex", pageIndex);
        resultMap.put("pageSize", pageSize);
        List<Staff> staffList = managerService.getStaffList(resultMap);
        model.addAttribute("list", staffList);
        return "manager";
    }

    @RequestMapping(value = "managerChoice")
    public String managerChoice(HttpSession session, Model model, String personName, String personId) {
        Integer gr_id = ((Enterprise) session.getAttribute("enterpriseObject")).getId();
        List<Staff> staffList = managerService.getAllStaffList(gr_id, personName, personId);
        model.addAttribute("list", staffList);
        return "managerChoice";
    }

    @RequestMapping(value = "updateJob")
    public String updateJob(HttpSession session, Integer pe_id, Integer re_job) {
        Integer gr_id = ((Enterprise) session.getAttribute("enterpriseObject")).getId();
        managerService.updateStaffJob(pe_id, re_job, gr_id);
        return "redirect:getStaffList";
    }

    @RequestMapping(value = "deleteRelation")
    public String deleteRelation(HttpSession session, Integer deleteId) {
        Integer gr_id = ((Enterprise) session.getAttribute("enterpriseObject")).getId();
        Integer re_job = 13;
        managerService.cancelStaffJob(deleteId, re_job, gr_id);
        return "redirect:getStaffList";
    }
}
