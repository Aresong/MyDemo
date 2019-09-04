package cn.bdqn.house.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.house.dao.IHouseUserDao;
import cn.bdqn.house.entity.HouseUser;
import cn.bdqn.house.service.IHouseUserService;


/*
 *@author:Dongming Tian
 *@date:2017-5-25 ����9:35:35
 *version: 1.0
 *description:
 */
public class HouseUserServiceImpl implements IHouseUserService {
    private IHouseUserDao houseUserDao;

    public IHouseUserDao getHouseUserDao() {
        return houseUserDao;
    }

    public void setHouseUserDao(IHouseUserDao houseUserDao) {
        this.houseUserDao = houseUserDao;
    }

    public boolean saveHouseUser(HouseUser houseUser) {
        boolean result = false;

        try {

            houseUserDao.save(houseUser);

            result = true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }

    @Override
    public boolean updateHouseUser(HouseUser houseUser) {
        boolean result = false;

        try {

            houseUserDao.update(houseUser);

            result = true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }

    @Override
    public boolean deleteHouseUser(HouseUser houseUser) {
        boolean result = false;

        try {

            houseUserDao.delete(houseUser);

            result = true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }

    @Override
    public HouseUser getHouseUserById(Serializable id) {
        HouseUser _user = null;
        try {
            _user = houseUserDao.getById(id);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return _user;
    }

    @Override
    public List<HouseUser> getList(HouseUser user, int pagestart, int pagesize) {
        List<HouseUser> _lst = new ArrayList<HouseUser>();

        try {

			/*if(!"".equals(user.getUsername())&&null!=user.getUsername()){
				user.setUsername("%"+user.getUsername()+"%");
			}*/
            pagestart = (pagestart - 1) * pagesize;
            _lst = houseUserDao.getList(user, pagestart, pagesize);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return _lst;
    }

    @Override
    public int getTotalCount() {
        int result = 0;

        try {

            result = houseUserDao.getTotalCount();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }

    @Override
    public HouseUser getByUser(String username) {
        HouseUser _user = null;
        try {
            _user = houseUserDao.getByUser(username);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return _user;
    }

}
