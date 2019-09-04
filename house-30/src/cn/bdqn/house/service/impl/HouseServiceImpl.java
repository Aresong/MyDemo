package cn.bdqn.house.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.house.dao.IHouseDao;
import cn.bdqn.house.dao.IHousePictureDao;
import cn.bdqn.house.entity.House;
import cn.bdqn.house.entity.HousePicture;
import cn.bdqn.house.service.IHouseService;

/*
 *@author:Dongming Tian
 *@date:2017-6-9 ����4:17:26
 *version: 1.0
 *description:
 */
public class HouseServiceImpl implements IHouseService {
    private IHouseDao houseDao;


    public IHouseDao getHouseDao() {
        return houseDao;
    }

    public void setHouseDao(IHouseDao houseDao) {
        this.houseDao = houseDao;
    }

    @Override
    public boolean saveHouse(House house) {
        boolean result = false;
        try {
            houseDao.save(house);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateHouse(House house) {
        boolean result = false;
        try {
            houseDao.update(house);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteHouse(House house) {
        boolean result = false;
        try {

            houseDao.delete(house);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public House getByHouseId(Serializable id) {
        House result = null;
        try {
            result = houseDao.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<House> getHouseList(House house, int pagestart, int pagesize) {
        List<House> _lst = new ArrayList<House>();
        try {
            pagestart = (pagestart - 1) * pagesize;
            if (null != house && null != house.getDescription() && !"".equals(house.getDescription())) {
                house.setDescription("%" + house.getDescription() + "%");
            }
            _lst = houseDao.getList(house, pagestart, pagesize);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return _lst;
    }

    @Override
    public int getTotalCount() {
        int result = 0;
        try {
            result = houseDao.getTotalCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
