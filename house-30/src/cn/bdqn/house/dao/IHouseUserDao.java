package cn.bdqn.house.dao;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.house.entity.HouseUser;

/*
 *@author:Dongming Tian
 *@date:2017-5-25 ����9:25:26
 *version: 1.0
 *description:
 */
public interface IHouseUserDao {
    public void save(HouseUser houseUser);

    public void update(HouseUser houseUser);

    public void delete(HouseUser houseUser);

    public HouseUser getById(Serializable id);

    public List<HouseUser> getList(HouseUser user, int pagestart, int pagesize);

    public int getTotalCount();

    public HouseUser getByUser(String username);
}
