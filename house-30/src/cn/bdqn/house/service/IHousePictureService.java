package cn.bdqn.house.service;

import cn.bdqn.house.entity.HousePicture;

/*
 *@author:Dongming Tian
 *@date:2017-6-14 ����12:06:10
 *version: 1.0
 *description:
 */
public interface IHousePictureService {
    public boolean saveHousePicture(HousePicture housePicture);

    public boolean updateHousePicture(HousePicture housePicture);

    public boolean deleteHousePicture(HousePicture housePicture);
}


