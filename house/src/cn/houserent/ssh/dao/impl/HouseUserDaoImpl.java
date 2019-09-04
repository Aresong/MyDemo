package cn.houserent.ssh.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.houserent.ssh.dao.IHouseUserDao;
import cn.houserent.ssh.entity.HouseUser;

public class HouseUserDaoImpl extends HibernateDaoSupport implements IHouseUserDao {

    @Override
    public HouseUser getByName(String userName) {
        String hql = "from HouseUser where userName=:userName";
        Session session = super.getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query = session.createQuery(hql);
        query.setString("userName", userName);
        return (HouseUser) query.uniqueResult();
    }

}
