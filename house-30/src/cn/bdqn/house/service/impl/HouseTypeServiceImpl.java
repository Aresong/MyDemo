package cn.bdqn.house.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.house.dao.IHouseTypeDao;
import cn.bdqn.house.entity.HouseType;
import cn.bdqn.house.service.IHouseTypeService;

/*
 *@author:Dongming Tian
 *@date:2017-6-9 ����8:52:17
 *version: 1.0
 *description:
 */
public class HouseTypeServiceImpl implements IHouseTypeService {
    private IHouseTypeDao houseTypeDao;

    public IHouseTypeDao getHouseTypeDao() {
        return houseTypeDao;
    }

    public void setHouseTypeDao(IHouseTypeDao houseTypeDao) {
        this.houseTypeDao = houseTypeDao;
    }

    @Override
    public HouseType getById(Serializable id) {
        HouseType houseType = null;
        try {
            houseType = houseTypeDao.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return houseType;
    }

    @Override
    public List<HouseType> getHouseTypes() {
        List<HouseType> _lisTypes = new ArrayList<HouseType>();
        try {
            _lisTypes = houseTypeDao.getHouseTypes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return _lisTypes;
    }

}
