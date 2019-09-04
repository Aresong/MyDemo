package com.s5.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.s5.crm.dao.CustomerDao;
import com.s5.crm.entity.Customer;

/**
 * @author Aresong
 * 客户管理dao的实现类
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

    @Override
    //dao中保存客户的方法
    public void save(Customer customer) {
        this.getHibernateTemplate().save(customer);
    }

    @Override
    //dao中带条件统计个数的方法
    public Integer findCount(DetachedCriteria detachedCriteria) {
        //select count(*) from xxx where 条件
        detachedCriteria.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        if (list.size() > 0) {
            return list.get(0).intValue();
        }
        return null;
    }

    @Override
    //dao中条件查询客户的方法
    public List<Customer> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {

        detachedCriteria.setProjection(null);
        return (List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
    }

}
