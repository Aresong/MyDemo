package cn.declaresystem.ssm.mapper;

import cn.declaresystem.ssm.pojo.BasicInfo;
import cn.declaresystem.ssm.pojo.Enterprise;

public interface EnterpriseMapper {
    public void add(Enterprise enterprise);

    public void update(Enterprise enterprise);

    public Enterprise getByCode(String code);

    public BasicInfo getGR_FromBaseById(Integer id);
}
