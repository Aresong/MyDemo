package com.s5.crm.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.s5.crm.dao.UserDao;
import com.s5.crm.entity.User;
import com.s5.crm.service.UserService;
import com.s5.crm.utils.MD5Utils;

/**
 * @author Aresong
 * 用户管理的service的实现类
 */

@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void regist(User user) {
        //对密码进行加密的处理
        user.setUser_password(MD5Utils.md5(user.getUser_password()));
        user.setUser_state("1");
        userDao.save(user);
    }

    @Override
    public User login(User user) {
        user.setUser_password(MD5Utils.md5(user.getUser_password()));
        //调用dao
        return userDao.login(user);
    }

}
