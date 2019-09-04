package cn.bdqn.house.dao;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.house.entity.Street;


/*
 *@author:Dongming Tian
 *@date:2017-6-6 ����1:56:07
 *version: 1.0
 *description:
 */
public interface IStreetDao {
    public void save(Street street);

    public void update(Street street);

    public void delete(Street street);

    public Street getById(Serializable id);

    public List<Street> getList();
}
