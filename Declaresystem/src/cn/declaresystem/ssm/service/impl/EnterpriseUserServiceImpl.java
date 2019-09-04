package cn.declaresystem.ssm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.declaresystem.ssm.mapper.EnterpriseMapper;
import cn.declaresystem.ssm.pojo.Enterprise;
import cn.declaresystem.ssm.service.EnterpriseUserService;

@Service
public class EnterpriseUserServiceImpl implements EnterpriseUserService {

    @Resource
    private EnterpriseMapper enterpriseMapper;

    @Override
    public void saveEnterpriseUser(Enterprise enterprise) {
        enterpriseMapper.add(enterprise);
    }

    @Override
    public Enterprise getEnterpriseByCode(String code) {
        return enterpriseMapper.getByCode(code);
    }

    @Override
    public void updateEnterprise(Enterprise enterprise) {
        enterpriseMapper.update(enterprise);
    }

}
