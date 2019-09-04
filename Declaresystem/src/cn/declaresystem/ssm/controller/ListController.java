package cn.declaresystem.ssm.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import cn.declaresystem.ssm.pojo.BasicInfo;
import cn.declaresystem.ssm.pojo.Enterprise;
import cn.declaresystem.ssm.service.BaseService;
import cn.declaresystem.ssm.service.ChartService;
import cn.declaresystem.ssm.service.EnterpriseUserService;
import cn.declaresystem.ssm.service.ManagerService;
import cn.declaresystem.ssm.service.StaffService;

@Controller
@RequestMapping("/listCtrl/")
public class ListController {
    @Resource
    private EnterpriseUserService userService;
    @Resource
    private BaseService baseService;
    @Resource
    private ChartService chartService;
    @Resource
    private StaffService staffService;
    @Resource
    private ManagerService managerService;

    @RequestMapping(value = "getState")
	
	/*@ResponseBody
	public Object getBaseState(HttpSession session){
		HashMap<String, String> resultMap = new HashMap<String, String>();
		Integer id = ((Enterprise)session.getAttribute("enterpriseObject")).getId();
		BasicInfo info = baseService.getBasicByGR_Id(id);
		if(null==info || null==session){
			resultMap.put("baseState", "haveno");
		}else{
				if( 
					null==info.getAddress() || "".equals(info.getAddress()) ||
				    null==info.getPostcode() || "".equals(info.getPostcode()) ||
				    null==info.getTel() || "".equals(info.getTel()) ||
				    null==info.getFax() || "".equals(info.getFax()) ||
				    null==info.getEmail() || "".equals(info.getEmail()) ||
				    null==info.getType() || "".equals(info.getType()) ||
				    null==info.getArea() || "".equals(info.getArea()) 
				  ){
					   resultMap.put("baseState", "notall");		
				   }else{
					   resultMap.put("baseState", "all");
				   }
		} 
		return JSONArray.toJSONString(resultMap); 
	}*/

    public String getState(HttpSession session, Model model) {
        Integer gr_id = ((Enterprise) session.getAttribute("enterpriseObject")).getId();
        BasicInfo info = baseService.getBasicByGR_Id(gr_id);
        String chartName = chartService.getChartName(gr_id);
        Integer totalStaff = staffService.getStaffCount(gr_id);
        Integer totalManager = managerService.getManagerCount(gr_id);
        if (null == info || null == session) {
            model.addAttribute("baseState", "��δ��д��");
        } else {
            if (
                    null == info.getAddress() || "".equals(info.getAddress()) ||
                            null == info.getPostcode() || "".equals(info.getPostcode()) ||
                            null == info.getTel() || "".equals(info.getTel()) ||
                            null == info.getFax() || "".equals(info.getFax()) ||
                            null == info.getEmail() || "".equals(info.getEmail()) ||
                            null == info.getType() || "".equals(info.getType()) ||
                            null == info.getArea() || "".equals(info.getArea())
            ) {
                model.addAttribute("baseState", "��δ��ɣ�");
            } else {
                model.addAttribute("baseState", "������д��");
            }
        }

        if (null == chartName) {
            model.addAttribute("chartState", "��δ�ϴ���");
        } else {
            model.addAttribute("chartState", "�����ϴ���");
        }

        if (totalStaff < 1) {
            model.addAttribute("totalStaff", "");
        } else {
            model.addAttribute("totalStaff", "��" + totalStaff + "�ˣ�");
        }

        if (totalStaff < 1) {
            model.addAttribute("totalManager", "");
        } else {
            model.addAttribute("totalManager", "��" + totalManager + "�ˣ�");
        }
        return "list";
    }

    @RequestMapping(value = "checkBaseState")
    @ResponseBody
    public Object checkBaseState(HttpSession session) {
        boolean result = true;
        Integer id = ((Enterprise) session.getAttribute("enterpriseObject")).getId();
        BasicInfo info = baseService.getBasicByGR_Id(id);
        if (
                null == info ||
                        null == info.getAddress() || "".equals(info.getAddress()) ||
                        null == info.getPostcode() || "".equals(info.getPostcode()) ||
                        null == info.getTel() || "".equals(info.getTel()) ||
                        null == info.getFax() || "".equals(info.getFax()) ||
                        null == info.getEmail() || "".equals(info.getEmail()) ||
                        null == info.getType() || "".equals(info.getType()) ||
                        null == info.getArea() || "".equals(info.getArea())
        ) {
            result = false;
        }
        return JSONArray.toJSONString(result);
    }

    @RequestMapping(value = "gotoUpdateInfo")
    public String gotoUpdateInfo(HttpSession session, Model model) {
        Enterprise enterprise = (Enterprise) session.getAttribute("enterpriseObject");
        enterprise = userService.getEnterpriseByCode(enterprise.getCode());
        model.addAttribute("enterprise", enterprise);
        return "updateInfo";
    }

    @RequestMapping(value = "updateInfo")
    public String updateInfo(HttpSession session, Enterprise enterprise) {
        Integer gr_id = ((Enterprise) session.getAttribute("enterpriseObject")).getId();
        enterprise.setId(gr_id);
        userService.updateEnterprise(enterprise);
        return "redirect:getState";
    }

    @RequestMapping(value = "exit")
    public String exit(HttpSession session) {
        session.invalidate();
        return "login";
    }

    @RequestMapping(value = "gotoList")
    public String gotoList() {
        return "list";
    }

    @RequestMapping(value = "gotoChart")
    public String gotoChart() {
        return "redirect:/chartCtrl/getChart";
    }

    @RequestMapping(value = "gotoStaff")
    public String gotoStaff() {
        return "redirect:/staffCtrl/getStaffList";
    }

    @RequestMapping(value = "gotoManager")
    public String gotoManager() {
        return "redirect:/ManagerCtrl/getStaffList";
    }

    @RequestMapping(value = "gotoPrint")
    public String gotoPrint() {
        return "print";
    }
}
