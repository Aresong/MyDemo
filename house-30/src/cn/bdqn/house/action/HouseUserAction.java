package cn.bdqn.house.action;

import java.util.List;

import cn.bdqn.house.entity.HouseUser;
import cn.bdqn.house.service.IHouseUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


/*
 *@author:Dongming Tian
 *@date:2017-6-1 ����12:25:24
 *version: 1.0
 *description:
 */

public class HouseUserAction extends ActionSupport {
    private HouseUser user;
    private List<HouseUser> users;
    private IHouseUserService houseUserService;

    public HouseUser getUser() {
        return user;
    }

    public void setUser(HouseUser user) {
        this.user = user;
    }

    public List<HouseUser> getUsers() {
        return users;
    }

    public void setUsers(List<HouseUser> users) {
        this.users = users;
    }

    public IHouseUserService getHouseUserService() {
        return houseUserService;
    }

    public void setHouseUserService(IHouseUserService houseUserService) {
        this.houseUserService = houseUserService;
    }

    //��¼
    public String login() throws Exception {
        System.out.println("*****************ʹ��login����****************************");
        HouseUser _user = houseUserService.getByUser(user.getUsername());
        ActionContext ac = ActionContext.getContext();
        ac.getSession().put("user", user);
        if (user.getUsername().equals("admin") && user.getPassword().equals("111111")) {
            return "ok";
        } else if (null != _user && user.getPassword().equals(_user.getPassword())) {
            ac.getSession().put("_user", _user);
            return SUCCESS;
        } else if ("" != _user.getUsername() && null != _user.getUsername()
                && "" != _user.getPassword() && null != _user.getPassword()
                && user.getPassword() != _user.getPassword()) {
            this.addFieldError("u", "�û����������������������룡");
            return INPUT;
        }

        return INPUT;
    }

    //�û�ע��
    public String register() throws Exception {
        houseUserService.saveHouseUser(user);
        return SUCCESS;
    }

}
