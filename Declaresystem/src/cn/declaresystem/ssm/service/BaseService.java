package cn.declaresystem.ssm.service;

import cn.declaresystem.ssm.pojo.BasicInfo;

public interface BaseService {
    public BasicInfo getBasicByGR_Id(Integer id);

    public void updateBasicInfo(BasicInfo basicInfo);
}
