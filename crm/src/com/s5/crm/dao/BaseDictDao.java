package com.s5.crm.dao;

import java.util.List;

import com.s5.crm.entity.BaseDict;

/**
 * @author Aresong
 * 数据字典dao的接口
 */
public interface BaseDictDao {

    List<BaseDict> findByTypeCode(String dict_type_code);

}
