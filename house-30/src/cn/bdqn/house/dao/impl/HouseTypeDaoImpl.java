package cn.bdqn.house.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.bdqn.house.dao.IHouseTypeDao;
import cn.bdqn.house.entity.HouseType;

/*
 *@author:Dongming Tian
 *@date:2017-6-9 ����8:46:03
 *version: 1.0
 *description:
 */
public class HouseTypeDaoImpl extends HibernateDaoSupport implements IHouseTypeDao {

    @Override
    public HouseType getById(Serializable id) {
        // TODO Auto-generated method stub
        return (HouseType) getHibernateTemplate().get(HouseType.class, id);
    }

    @Override
    public List<HouseType> getHouseTypes() {
        StringBuilder hql = new StringBuilder("from HouseType");
        Session session = super.getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query = session.createQuery(hql.toString());
        return query.list();
    }

}
