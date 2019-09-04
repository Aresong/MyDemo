package cn.declaresystem.ssm.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import cn.declaresystem.ssm.mapper.ChartMapper;
import cn.declaresystem.ssm.mapper.ManagerMapper;
import cn.declaresystem.ssm.mapper.registerMapper;
import cn.declaresystem.ssm.pojo.BasicInfo;
import cn.declaresystem.ssm.pojo.Enterprise;
import cn.declaresystem.ssm.pojo.Staff;
import cn.declaresystem.ssm.service.PrintService;
import cn.declaresystem.ssm.util.PrintStaffExcel;

@Service
public class PrintServiceImpl implements PrintService {

    @Resource
    private ChartMapper chartMapper;

    @Resource
    private registerMapper registerMapper;

    @Resource
    private ManagerMapper managerMapper;

    @Override
    public String getChartName(Integer gr_id) {
        return chartMapper.get(gr_id);
    }

    @Override
    public String printExcel(Enterprise enterprise, HttpServletRequest request) {
        Integer gr_id = enterprise.getId();
        HashMap<String, Integer> staffMap = new HashMap<String, Integer>();
        Integer pageIndex = 0;
        Integer totalCount = managerMapper.getCount(gr_id);
        Integer pageSize = totalCount;
        staffMap.put("gr_id", gr_id);
        staffMap.put("pageIndex", pageIndex);
        staffMap.put("pageSize", pageSize);
        BasicInfo info = registerMapper.getById(gr_id);
        List<Staff> managerList = managerMapper.getList(staffMap);
        PrintStaffExcel staffExcel = new PrintStaffExcel();
        staffExcel.writeExcel(request, enterprise, info, managerList, totalCount);
        return null;
    }

}
