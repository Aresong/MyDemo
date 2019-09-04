package cn.bdqn.house.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.house.dao.IStreetDao;
import cn.bdqn.house.entity.Street;
import cn.bdqn.house.service.IStreetService;

/*
 *@author:Dongming Tian
 *@date:2017-6-6 ����2:02:31
 *version: 1.0
 *description:
 */
public class StreetServiceImpl implements IStreetService {
    private IStreetDao streetDao;

    public IStreetDao getStreetDao() {
        return streetDao;
    }

    public void setStreetDao(IStreetDao streetDao) {
        this.streetDao = streetDao;
    }

    @Override
    public boolean saveStreet(Street street) {
        boolean result = false;
        try {
            streetDao.save(street);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateStreet(Street street) {
        boolean result = false;
        try {
            streetDao.update(street);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteStreet(Street street) {
        boolean result = false;
        try {
            streetDao.delete(street);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Street getByStreetId(Serializable id) {
        Street _street = null;
        try {
            _street = streetDao.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return _street;
    }

    @Override
    public List<Street> getStreetList() {
        List<Street> _lst = new ArrayList<Street>();
        try {
            _lst = streetDao.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return _lst;
    }

}
