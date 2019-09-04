package cn.bdqn.house.dao;

import cn.bdqn.house.entity.HousePicture;

/*
 *@author:Dongming Tian
 *@date:2017-6-14 ����12:02:51
 *version: 1.0
 *description:
 */
public interface IHousePictureDao {
    public void save(HousePicture housePicture);

    public void update(HousePicture housePicture);

    public void delete(HousePicture housePicture);
}
