package com.s5.crm.service;

import com.s5.crm.entity.User;

/**
 * @author Aresong
 * 用户管理的Service的接口
 */
public interface UserService {
    public void regist(User user);

    public User login(User user);
}
