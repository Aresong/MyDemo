package com.s5.crm.service;

import java.util.List;

import com.s5.crm.pojo.BaseDict;

public interface BaseDictService {
    public List<BaseDict> selectDictByCode(String code);
}
