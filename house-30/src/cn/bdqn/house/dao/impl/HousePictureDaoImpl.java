package cn.bdqn.house.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.bdqn.house.dao.IHousePictureDao;
import cn.bdqn.house.entity.HousePicture;

/*
 *@author:Dongming Tian
 *@date:2017-6-14 ����12:04:02
 *version: 1.0
 *description:
 */
public class HousePictureDaoImpl extends HibernateDaoSupport implements IHousePictureDao {

    @Override
    public void save(HousePicture housePicture) {
        // TODO Auto-generated method stub
        getHibernateTemplate().save(housePicture);
    }

    @Override
    public void update(HousePicture housePicture) {
        // TODO Auto-generated method stub
        /*getHibernateTemplate().getSessionFactory().getCurrentSession().merge(housePicture);*/
        getHibernateTemplate().update(housePicture);
    }

    @Override
    public void delete(HousePicture housePicture) {
        getHibernateTemplate().delete(housePicture);
    }

}
