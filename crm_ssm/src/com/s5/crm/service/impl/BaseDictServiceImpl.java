package com.s5.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.s5.crm.mapper.BaseDictDao;
import com.s5.crm.pojo.BaseDict;
import com.s5.crm.service.BaseDictService;

@Service
public class BaseDictServiceImpl implements BaseDictService {

    @Resource
    private BaseDictDao baseDictDao;

    @Override
    public List<BaseDict> selectDictByCode(String code) {
        return baseDictDao.selectDictByCode(code);
    }

}
