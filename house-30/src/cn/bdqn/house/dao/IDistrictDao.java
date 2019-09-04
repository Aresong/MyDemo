package cn.bdqn.house.dao;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.house.entity.District;


/*
 *@author:Dongming Tian
 *@date:2017-6-6 ����10:03:59
 *version: 1.0
 *description:
 */
public interface IDistrictDao {
    public void save(District district);

    public void update(District district);

    public void delete(District district);

    public District getById(Serializable id);

    public List<District> getList();

}
