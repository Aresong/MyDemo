package cn.bdqn.house.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.bdqn.house.dao.IHouseDao;
import cn.bdqn.house.entity.House;

/*
 *@author:Dongming Tian
 *@date:2017-6-9 ����4:09:04
 *version: 1.0
 *description:
 */
public class HouseDaoImpl extends HibernateDaoSupport implements IHouseDao {

    @Override
    public void save(House house) {
        // TODO Auto-generated method stub
        getHibernateTemplate().save(house);
    }

    @Override
    public void update(House house) {
        // TODO Auto-generated method stub
        getHibernateTemplate().update(house);
    }

    @Override
    public void delete(House house) {
        // TODO Auto-generated method stub
        getHibernateTemplate().delete(house);
    }

    @Override
    public House getById(Serializable id) {
        // TODO Auto-generated method stub
        return (House) getHibernateTemplate().get(House.class, id);
    }

    @Override
    public List<House> getList(House house, int pagestart, int pagesize) {
        StringBuilder hql = new StringBuilder("from House where 1=1 ");
        if (null != house && null != house.getDescription() && !"".equals(house.getDescription())) {
            hql.append(" and description like :description ");
        }
        hql.append(" order by id ");
        Session session = super.getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query = session.createQuery(hql.toString());
        if (null != house) {
            query.setProperties(house);
        }
        query.setFirstResult(pagestart);
        query.setMaxResults(pagesize);
        return query.list();
    }

    @Override
    public int getTotalCount() {
        String hql = "select count(*) from House";
        Session session = super.getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query = session.createQuery(hql);
        return ((Long) query.uniqueResult()).intValue();
    }

}
