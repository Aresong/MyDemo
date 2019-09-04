package cn.bdqn.house.service.impl;

import cn.bdqn.house.dao.IHousePictureDao;

import cn.bdqn.house.entity.HousePicture;
import cn.bdqn.house.service.IHousePictureService;

/*
 *@author:Dongming Tian
 *@date:2017-6-14 ����9:10:17
 *version: 1.0
 *description:
 */
public class HousePictureServiceImpl implements IHousePictureService {

    private IHousePictureDao housePictureDao;

    public IHousePictureDao getHousePictureDao() {
        return housePictureDao;
    }

    public void setHousePictureDao(IHousePictureDao housePictureDao) {
        this.housePictureDao = housePictureDao;
    }

    @Override
    public boolean saveHousePicture(HousePicture housePicture) {
        boolean result = false;
        try {
            housePictureDao.save(housePicture);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateHousePicture(HousePicture housePicture) {
        boolean result = false;
        try {
            housePictureDao.update(housePicture);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteHousePicture(HousePicture housePicture) {
        boolean result = false;
        try {
            housePictureDao.delete(housePicture);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
