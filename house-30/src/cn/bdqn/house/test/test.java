package cn.bdqn.house.test;

import java.util.ArrayList;
import java.util.List;

import cn.bdqn.house.entity.HouseUser;
import cn.bdqn.house.service.IHouseUserService;
import cn.bdqn.house.service.impl.HouseUserServiceImpl;

/*
 *@author:Dongming Tian
 *@date:2017-5-25 ����9:42:31
 *version: 1.0
 *description:
 */
public class test {
    public static void main(String[] args) {
        IHouseUserService ih = new HouseUserServiceImpl();
        HouseUser user = new HouseUser();
        List<HouseUser> _lst = new ArrayList<HouseUser>();

        _lst = ih.getList(user, 1, 10);
        for (HouseUser houseUser : _lst) {
            System.out.println(houseUser.getId() + "\t" + houseUser.getUsername() + "\t" + houseUser.getPassword());
        }


    }
}
