package com.s5.crm.mapper;

import java.util.List;

import com.s5.crm.pojo.BaseDict;

public interface BaseDictDao {

    //查询
    public List<BaseDict> selectDictByCode(String code);

}
