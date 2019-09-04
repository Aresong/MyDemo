package com.s5.crm.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.s5.crm.dao.BaseDictDao;
import com.s5.crm.entity.BaseDict;
import com.s5.crm.service.BaseDictService;

/**
 * @author Aresong
 * 数据字典service的实现类
 */

@Transactional
public class BaseDictServiceImpl implements BaseDictService {

    private BaseDictDao baseDictDao;

    public void setBaseDictDao(BaseDictDao baseDictDao) {
        this.baseDictDao = baseDictDao;
    }

    @Override
    public List<BaseDict> findByTypeCode(String dict_type_code) {
        return baseDictDao.findByTypeCode(dict_type_code);
    }

}
