package cn.declaresystem.ssm.service;

import javax.servlet.http.HttpServletRequest;

import cn.declaresystem.ssm.pojo.Enterprise;

public interface PrintService {
    public String getChartName(Integer gr_id);

    public String printExcel(Enterprise enterprise, HttpServletRequest request);
}
