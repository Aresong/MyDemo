package com.s5.crm.dao;

import com.s5.crm.entity.User;

/**
 * @author Aresong
 * 用户管理的DAO的接口
 */
public interface UserDao {
    public void save(User user);

    public User login(User user);
}
