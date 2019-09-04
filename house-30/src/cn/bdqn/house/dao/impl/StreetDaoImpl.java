package cn.bdqn.house.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.bdqn.house.dao.IStreetDao;
import cn.bdqn.house.entity.Street;

/*
 *@author:Dongming Tian
 *@date:2017-6-6 ����1:58:12
 *version: 1.0
 *description:
 */
public class StreetDaoImpl extends HibernateDaoSupport implements IStreetDao {

    @Override
    public void save(Street street) {
        // TODO Auto-generated method stub
        getHibernateTemplate().save(street);
    }

    @Override
    public void update(Street street) {
        // TODO Auto-generated method stub
        getHibernateTemplate().update(street);
    }

    @Override
    public void delete(Street street) {
        // TODO Auto-generated method stub
        getHibernateTemplate().delete(street);
    }

    @Override
    public Street getById(Serializable id) {
        // TODO Auto-generated method stub
        return (Street) super.getHibernateTemplate().get(Street.class, id);
    }

    @Override
    public List<Street> getList() {
        String hql = "from Street";
        Session session = super.getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query = session.createQuery(hql);
        return query.list();
    }

}
