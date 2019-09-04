package cn.bdqn.house.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.bdqn.house.dao.IDistrictDao;
import cn.bdqn.house.entity.District;

/*
 *@author:Dongming Tian
 *@date:2017-6-6 ����10:06:10
 *version: 1.0
 *description:
 */
public class DistrictDaoImpl extends HibernateDaoSupport implements IDistrictDao {

    @Override
    public void save(District district) {
        // TODO Auto-generated method stub
        getHibernateTemplate().save(district);
    }

    @Override
    public void update(District district) {
        // TODO Auto-generated method stub
        getHibernateTemplate().update(district);
    }

    @Override
    public void delete(District district) {
        // TODO Auto-generated method stub
        getHibernateTemplate().delete(district);
    }

    @Override
    public District getById(Serializable id) {
        // TODO Auto-generated method stub
        return (District) super.getHibernateTemplate().get(District.class, id);
    }

    @Override
    public List<District> getList() {
        String hql = "from District";
        Session session = super.getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query = session.createQuery(hql);
        return query.list();
    }


}
