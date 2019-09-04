package cn.houserent.ssh.dao;

import cn.houserent.ssh.entity.HouseUser;

public interface IHouseUserDao {
    public HouseUser getByName(String userName);
}
