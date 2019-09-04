package cn.houserent.ssh.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.houserent.ssh.service.IHouseUserService;

public class HouseUserAction extends ActionSupport {

    private static final long serialVersionUID = -2471999088200539085L;

    private IHouseUserService houseUserService = null;

    private String userName;
    private String password;

    public IHouseUserService getHouseUserService() {
        return houseUserService;
    }

    public void setHouseUserService(IHouseUserService houseUserService) {
        this.houseUserService = houseUserService;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        boolean result = houseUserService.loginHouseUser(userName, password);
        if (result) {
            return SUCCESS;
        } else {
            ActionContext ac = ActionContext.getContext();
            HttpServletRequest request = (HttpServletRequest) ac.get(ServletActionContext.HTTP_REQUEST);
            request.setAttribute("err", "�������");
            return INPUT;
        }
    }
}
