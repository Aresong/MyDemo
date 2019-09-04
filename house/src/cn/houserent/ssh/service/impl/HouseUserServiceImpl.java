package cn.houserent.ssh.service.impl;

import cn.houserent.ssh.dao.IHouseUserDao;
import cn.houserent.ssh.entity.HouseUser;
import cn.houserent.ssh.service.IHouseUserService;

public class HouseUserServiceImpl implements IHouseUserService {

    private IHouseUserDao houseUserDao = null;

    public IHouseUserDao getHouseUserDao() {
        return houseUserDao;
    }

    public void setHouseUserDao(IHouseUserDao houseUserDao) {
        this.houseUserDao = houseUserDao;
    }

    @Override
    public boolean loginHouseUser(String userName, String password) {
        boolean result = false;
        HouseUser user = houseUserDao.getByName(userName);
        if (null != user) {
            if (password.equals(user.getPassword())) {
                result = true;
            }
        }
        return result;
    }

}
