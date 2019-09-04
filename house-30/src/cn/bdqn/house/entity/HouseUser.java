package cn.bdqn.house.entity;


public class HouseUser implements java.io.Serializable {

    private Integer id;
    private String username;
    private String password;
    private String telephone;
    private String realname;
    private String isadmin;


    public HouseUser() {
    }

    public HouseUser(Integer id) {
        this.id = id;
    }

    public HouseUser(Integer id, String username, String password,
                     String telephone, String realname, String isadmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.realname = realname;
        this.isadmin = isadmin;

    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRealname() {
        return this.realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIsadmin() {
        return this.isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin;
    }

}