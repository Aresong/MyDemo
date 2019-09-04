package com.s5.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * @author Aresong
 *	用户管理的DAO的实现类
 */
import com.s5.crm.dao.UserDao;
import com.s5.crm.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Override
    //dao中保存用户的方法
    public void save(User user) {
        this.getHibernateTemplate().save(user);
    }

    @Override
    //dao中根据用户名和密码进行查询的方法
    public User login(User user) {
        List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code=? and user_password=?", user.getUser_code(), user.getUser_password());
        //判断一下：
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;

    }

}
