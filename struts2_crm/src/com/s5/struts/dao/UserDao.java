package com.s5.struts.dao;

import com.s5.struts.entity.User;

/**
 * 用户dao的接口
 **/
public interface UserDao {

    User login(User user);

}
