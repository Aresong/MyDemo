package cn.declaresystem.ssm.pojo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Staff {
    private Integer pe_id;
    private String pe_name;
    private String pe_sex;

    @JSONField(format = "yyyy-MM-dd")
    private Date pe_birthday;

    private String pe_school;
    private Integer pe_professional;
    private Integer pe_record;
    @JSONField(format = "yyyy-MM-dd")
    private Date pe_finish_school;
    private String pe_cardid;
    private Integer pe_technical;
    @JSONField(format = "yyyy-MM-dd")
    private Date pe_assess_date;
    private String pe_address;
    private String pe_tel;
    private String pe_speciality;

    private Relations relation;

    private DataDictionary dd1;
    private DataDictionary dd2;
    private DataDictionary dd3;
    private DataDictionary dd4;

    public Integer getPe_id() {
        return pe_id;
    }

    public void setPe_id(Integer pe_id) {
        this.pe_id = pe_id;
    }

    public String getPe_name() {
        return pe_name;
    }

    public void setPe_name(String pe_name) {
        this.pe_name = pe_name;
    }

    public String getPe_sex() {
        return pe_sex;
    }

    public void setPe_sex(String pe_sex) {
        this.pe_sex = pe_sex;
    }

    public Date getPe_birthday() {
        return pe_birthday;
    }

    public void setPe_birthday(Date pe_birthday) {
        this.pe_birthday = pe_birthday;
    }

    public String getPe_school() {
        return pe_school;
    }

    public void setPe_school(String pe_school) {
        this.pe_school = pe_school;
    }

    public Integer getPe_professional() {
        return pe_professional;
    }

    public void setPe_professional(Integer pe_professional) {
        this.pe_professional = pe_professional;
    }

    public Integer getPe_record() {
        return pe_record;
    }

    public void setPe_record(Integer pe_record) {
        this.pe_record = pe_record;
    }

    public Date getPe_finish_school() {
        return pe_finish_school;
    }

    public void setPe_finish_school(Date pe_finish_school) {
        this.pe_finish_school = pe_finish_school;
    }

    public String getPe_cardid() {
        return pe_cardid;
    }

    public void setPe_cardid(String pe_cardid) {
        this.pe_cardid = pe_cardid;
    }

    public Integer getPe_technical() {
        return pe_technical;
    }

    public void setPe_technical(Integer pe_technical) {
        this.pe_technical = pe_technical;
    }

    public Date getPe_assess_date() {
        return pe_assess_date;
    }

    public void setPe_assess_date(Date pe_assess_date) {
        this.pe_assess_date = pe_assess_date;
    }

    public String getPe_address() {
        return pe_address;
    }

    public void setPe_address(String pe_address) {
        this.pe_address = pe_address;
    }

    public String getPe_tel() {
        return pe_tel;
    }

    public void setPe_tel(String pe_tel) {
        this.pe_tel = pe_tel;
    }

    public String getPe_speciality() {
        return pe_speciality;
    }

    public void setPe_speciality(String pe_speciality) {
        this.pe_speciality = pe_speciality;
    }

    public Relations getRelation() {
        return relation;
    }

    public void setRelation(Relations relation) {
        this.relation = relation;
    }

    public DataDictionary getDd1() {
        return dd1;
    }

    public void setDd1(DataDictionary dd1) {
        this.dd1 = dd1;
    }

    public DataDictionary getDd2() {
        return dd2;
    }

    public void setDd2(DataDictionary dd2) {
        this.dd2 = dd2;
    }

    public DataDictionary getDd3() {
        return dd3;
    }

    public void setDd3(DataDictionary dd3) {
        this.dd3 = dd3;
    }

    public DataDictionary getDd4() {
        return dd4;
    }

    public void setDd4(DataDictionary dd4) {
        this.dd4 = dd4;
    }
}
