package cn.bdqn.house.service;

import java.io.Serializable;
import java.util.List;

import cn.bdqn.house.entity.HouseUser;

/*
 *@author:Dongming Tian
 *@date:2017-5-25 ����9:34:48
 *version: 1.0
 *description:
 */
public interface IHouseUserService {
    public boolean saveHouseUser(HouseUser houseUser);

    public boolean updateHouseUser(HouseUser houseUser);

    public boolean deleteHouseUser(HouseUser houseUser);

    public HouseUser getHouseUserById(Serializable id);

    public List<HouseUser> getList(HouseUser user, int pagestart, int pagesize);

    public int getTotalCount();

    public HouseUser getByUser(String username);
}
