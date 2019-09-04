package cn.bdqn.house.dao;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.house.entity.House;

/*
 *@author:Dongming Tian
 *@date:2017-6-9 ����4:04:09
 *version: 1.0
 *description:
 */
public interface IHouseDao {
    public void save(House house);

    public void update(House house);

    public void delete(House house);

    public House getById(Serializable id);

    public List<House> getList(House house, int pagestart, int pagesize);

    public int getTotalCount();
}
