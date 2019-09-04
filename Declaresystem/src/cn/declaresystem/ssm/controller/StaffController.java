package cn.declaresystem.ssm.controller;

import java.text.ParseException;
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
import cn.declaresystem.ssm.pojo.Relations;
import cn.declaresystem.ssm.pojo.Staff;
import cn.declaresystem.ssm.service.StaffService;
/*import cn.declaresystem.ssm.util.ExportStaffExcel;*/
import cn.declaresystem.ssm.util.ExportStaffExcel;
import cn.declaresystem.ssm.util.PageSupport;

@Controller
@RequestMapping("/staffCtrl/")
public class StaffController {

    @Resource
    private StaffService staffService;

    @InitBinder
    public void initBinder(WebDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @RequestMapping(value = "getStaffList")
    public String getStaffList(HttpSession session, Model model, Integer index) {
        HashMap<String, Integer> resultMap = new HashMap<String, Integer>();
        Integer gr_id = ((Enterprise) session.getAttribute("enterpriseObject")).getId();
        Integer totalCount = staffService.getStaffCount(gr_id);
        if (null == index) {
            index = 1;
        }
        Integer pageIndex = index;
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
        List<Staff> staffList = staffService.getStaffList(resultMap);
        model.addAttribute("list", staffList);
        return "staff";
    }

    @RequestMapping(value = "gotoChoice")
    public String gotoChoice() {
        return "redirect:getOtherStaff";
    }

    @RequestMapping(value = "gotoAddPerson")
    public String gotoAddPerson() {
        return "addPerson";
    }

    @RequestMapping(value = "gotoUpdateOtherStaff")
    public String gotoUpdateOtherStaff(String updateId, Model model) {
        Integer id = Integer.parseInt(updateId);
        Staff staff = staffService.getStaffById(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String pe_birthday = sdf.format(staff.getPe_birthday());
        String pe_finish_school = sdf.format(staff.getPe_finish_school());
        String pe_assess_date = sdf.format(staff.getPe_assess_date());
        model.addAttribute("pe_birthday", pe_birthday);
        model.addAttribute("pe_finish_school", pe_finish_school);
        model.addAttribute("pe_assess_date", pe_assess_date);
        model.addAttribute("staff", staff);
        return "updateOtherPerson";
    }

    @RequestMapping(value = "addPerson")
    public String addPerson(Staff staff) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date _date1 = staff.getPe_birthday();
            Date _date2 = staff.getPe_finish_school();
            Date _date3 = staff.getPe_assess_date();
            Date date1 = null;
            Date date2 = null;
            Date date3 = null;
            if (null != _date1) {
                date1 = sdf.parse(sdf.format(staff.getPe_birthday()));
                staff.setPe_birthday(date1);
            }
            if (null != _date2) {
                date2 = sdf.parse(sdf.format(staff.getPe_finish_school()));
                staff.setPe_finish_school(date2);
            }
            if (null != _date3) {
                date3 = sdf.parse(sdf.format(staff.getPe_assess_date()));
                staff.setPe_assess_date(date3);
            }

//			System.out.println(staff.getPe_name());
//			System.out.println(staff.getPe_sex());
//			System.out.println(sdf.format(staff.getPe_birthday()));
//			System.out.println(staff.getPe_school());
//			System.out.println(staff.getPe_record());
//			System.out.println(staff.getPe_professional());
//			System.out.println(sdf.format(staff.getPe_finish_school()));
//			System.out.println(staff.getPe_technical());
//			System.out.println(sdf.format(staff.getPe_assess_date()));
//			System.out.println(staff.getPe_cardid());
//			System.out.println(staff.getPe_address());
//			System.out.println(staff.getPe_tel());
//			System.out.println(staff.getPe_speciality());
            staffService.saveStaff(staff);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "redirect:getOtherStaff";
    }

    @RequestMapping(value = "getOtherStaff")
    public String getOtherStaff(Model model, String personName, String personId) {
        List<Staff> otherList = staffService.getOtherStaffList(personName, personId);
        model.addAttribute("otherList", otherList);
        return "choice";
    }

    @RequestMapping(value = "updateOtherStaff")
    public String updateOtherStaff(Staff staff) {
        staffService.updateStaff(staff);
        return "redirect:gotoChoice";
    }

    @RequestMapping(value = "addRelation")
    public String addRelation(HttpSession session, Relations relations) {
        Integer id = ((Enterprise) session.getAttribute("enterpriseObject")).getId();
        relations.setGr_id(id);
        relations.setRe_job(13);
        staffService.addRelation(relations);
        return "redirect:getStaffList";
    }

    @RequestMapping(value = "deleteRelation")
    public String deleteRelation(String date, String deleteId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Integer pe_id = Integer.parseInt(deleteId);
        try {
            Date re_deleteDate = sdf.parse(date);
            staffService.deleteStaff(re_deleteDate, pe_id);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "redirect:getStaffList";
    }

    @RequestMapping(value = "exportStaffExcel")
    public String exportStaffExcel(HttpSession session) {
        HashMap<String, Integer> resultMap = new HashMap<String, Integer>();
        Integer gr_id = ((Enterprise) session.getAttribute("enterpriseObject")).getId();
        Integer totalCount = staffService.getStaffCount(gr_id);
        resultMap.put("gr_id", gr_id);
        resultMap.put("pageIndex", 0);
        resultMap.put("pageSize", totalCount);
        List<Staff> staffList = staffService.getStaffList(resultMap);
        ExportStaffExcel staffExcel = new ExportStaffExcel();
        staffExcel.Export(staffList);
        return "redirect:getStaffList";
    }

    @RequestMapping(value = "updateStaff")
    public String updateStaff(Integer updateId, Model model) {
        Relations relation = new Relations();
        relation = staffService.getRelationById(updateId);
        model.addAttribute("relation", relation);
        return "updatePerson";
    }

    @RequestMapping(value = "saveUpdateStaff")
    public String saveUpdateStaff(Integer pe_id, String re_pactNo, Date re_pactDate, String re_dept) {
        staffService.updateStaffRelation(pe_id, re_pactNo, re_pactDate, re_dept);
        return "redirect:getStaffList";
    }
}
