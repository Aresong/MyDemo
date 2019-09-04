package cn.declaresystem.ssm.mapper;

import cn.declaresystem.ssm.pojo.OrganizeChart;

public interface ChartMapper {
    public void add(OrganizeChart chart);

    public void delete(Integer gr_id);

    public String get(Integer gr_id);
}
