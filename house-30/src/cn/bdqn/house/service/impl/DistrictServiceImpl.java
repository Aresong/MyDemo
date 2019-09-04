package cn.bdqn.house.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.house.dao.IDistrictDao;
import cn.bdqn.house.entity.District;
import cn.bdqn.house.service.IDistrictService;

/*
 *@author:Dongming Tian
 *@date:2017-6-6 ����10:14:41
 *version: 1.0
 *description:
 */
public class DistrictServiceImpl implements IDistrictService {
    private IDistrictDao districtDao;

    public IDistrictDao getDistrictDao() {
        return districtDao;
    }

    public void setDistrictDao(IDistrictDao districtDao) {
        this.districtDao = districtDao;
    }

    @Override
    public boolean saveDistrict(District district) {
        boolean result = false;
        try {
            districtDao.save(district);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateDistrict(District district) {
        boolean result = false;
        try {
            districtDao.update(district);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteDistrict(District district) {
        boolean result = false;
        try {
            districtDao.delete(district);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public District getByDistrictId(Serializable id) {
        District _d = null;
        try {
            _d = districtDao.getById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return _d;
    }

    @Override
    public List<District> getDistrictList() {
        List<District> _list = new ArrayList<District>();
        try {
            _list = districtDao.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return _list;
    }

}
