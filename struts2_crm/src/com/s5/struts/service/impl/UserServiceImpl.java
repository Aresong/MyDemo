package com.s5.struts.service.impl;

import com.s5.struts.dao.UserDao;
import com.s5.struts.dao.impl.UserDaoImpl;
import com.s5.struts.entity.User;
import com.s5.struts.service.UserService;

/**
 * 用户业务层实现类
 **/
public class UserServiceImpl implements UserService {

    @Override
    //业务层用户登录的方法：
    public User login(User user) {
        UserDao userDao = new UserDaoImpl();
        return userDao.login(user);
    }

}
