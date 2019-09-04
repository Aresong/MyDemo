package cn.bdqn.house.dao;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.house.entity.HouseType;

/*
 *@author:Dongming Tian
 *@date:2017-6-9 ����8:42:49
 *version: 1.0
 *description:
 */
public interface IHouseTypeDao {
    public HouseType getById(Serializable id);

    public List<HouseType> getHouseTypes();
}
