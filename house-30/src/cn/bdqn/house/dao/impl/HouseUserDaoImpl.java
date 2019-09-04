package cn.bdqn.house.dao.impl;

import java.io.Serializable;
import java.util.List;

import oracle.net.aso.s;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.bdqn.house.dao.IHouseUserDao;
import cn.bdqn.house.entity.HouseUser;


/*
 *@author:Dongming Tian
 *@date:2017-5-25 ����9:28:02
 *version: 1.0
 *description:
 */
public class HouseUserDaoImpl extends HibernateDaoSupport implements IHouseUserDao {

    @Override
    public void save(HouseUser houseUser) {
        // TODO Auto-generated method stub
        super.getHibernateTemplate().save(houseUser);
    }

    @Override
    public void update(HouseUser houseUser) {
        // TODO Auto-generated method stub
        super.getHibernateTemplate().update(houseUser);
    }

    @Override
    public void delete(HouseUser houseUser) {
        // TODO Auto-generated method stub
        super.getHibernateTemplate().delete(houseUser);
    }

    @Override
    public HouseUser getById(Serializable id) {
        // TODO Auto-generated method stub
        return (HouseUser) super.getHibernateTemplate().get(HouseUser.class, id);
    }

    @Override
    public List<HouseUser> getList(HouseUser user, int pagestart, int pagesize) {
        StringBuilder hqlBuilder = new StringBuilder("from HouseUser where 1=1");
		/*if(!"".equals(user.getUsername())&& null!=user.getUsername()){
			hqlBuilder.append(" and username like :username");
		}*/
        Session session = super.getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query = session.createQuery(hqlBuilder.toString());
        //query.setProperties(user);
        query.setFirstResult(pagestart);
        query.setMaxResults(pagesize);
        return query.list();

    }

    @Override
    public int getTotalCount() {
        String hql = "select count(*) from HouseUser";
        Session session = super.getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query = session.createQuery(hql);
        return ((Long) query.uniqueResult()).intValue();

    }

    @Override
    public HouseUser getByUser(String username) {
        String hql = "from HouseUser where username=:username";
        Session session = super.getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query = session.createQuery(hql);
        query.setString("username", username);
        return (HouseUser) query.uniqueResult();
        //	return (HouseUser)getHibernateTemplate().find("from HouseUser where username = ?",  username).get(0);
    }

}
