package com.s5.crm.service;

import java.util.List;

import com.s5.crm.entity.BaseDict;

/**
 * @author Aresong
 * 数据字典service的接口
 */
public interface BaseDictService {

    List<BaseDict> findByTypeCode(String dict_type_code);

}
