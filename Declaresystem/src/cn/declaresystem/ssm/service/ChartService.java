package cn.declaresystem.ssm.service;

import cn.declaresystem.ssm.pojo.OrganizeChart;

public interface ChartService {
    public void saveChartInfo(OrganizeChart chart);

    public String getChartName(Integer gr_id);
}
