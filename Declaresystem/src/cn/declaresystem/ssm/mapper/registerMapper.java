package cn.declaresystem.ssm.mapper;

import cn.declaresystem.ssm.pojo.BasicInfo;

public interface registerMapper {
    public void update(BasicInfo basicInfo);

    public BasicInfo getById(Integer id);

    public void add(BasicInfo basicInfo);
}
