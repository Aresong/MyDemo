package cn.declaresystem.ssm.service;

import cn.declaresystem.ssm.pojo.Enterprise;

public interface EnterpriseUserService {
    public void saveEnterpriseUser(Enterprise enterprise);

    public Enterprise getEnterpriseByCode(String code);

    public void updateEnterprise(Enterprise enterprise);
}
