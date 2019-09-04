package cn.bdqn.house.service;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.house.entity.House;


/*
 *@author:Dongming Tian
 *@date:2017-6-9 ����4:07:37
 *version: 1.0
 *description:
 */
public interface IHouseService {
    public boolean saveHouse(House house);

    public boolean updateHouse(House house);

    public boolean deleteHouse(House house);

    public House getByHouseId(Serializable id);

    public List<House> getHouseList(House house, int pagestart, int pagesize);

    public int getTotalCount();
}
