package cn.bdqn.house.service;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.house.entity.District;

/*
 *@author:Dongming Tian
 *@date:2017-6-6 ����10:12:39
 *version: 1.0
 *description:
 */
public interface IDistrictService {
    public boolean saveDistrict(District district);

    public boolean updateDistrict(District district);

    public boolean deleteDistrict(District district);

    public District getByDistrictId(Serializable id);

    public List<District> getDistrictList();

}