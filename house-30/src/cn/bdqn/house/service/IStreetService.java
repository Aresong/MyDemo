package cn.bdqn.house.service;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.house.entity.Street;

/*
 *@author:Dongming Tian
 *@date:2017-6-6 ����2:01:35
 *version: 1.0
 *description:
 */
public interface IStreetService {
    public boolean saveStreet(Street street);

    public boolean updateStreet(Street street);

    public boolean deleteStreet(Street street);

    public Street getByStreetId(Serializable id);

    public List<Street> getStreetList();
}
