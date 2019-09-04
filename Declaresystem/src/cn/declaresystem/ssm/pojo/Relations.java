package cn.declaresystem.ssm.pojo;

import java.util.Date;

public class Relations {
    private Integer re_id;
    private Integer pe_id;
    private Integer gr_id;
    private String re_pactNo;
    private Date re_pactDate;
    private String re_dept;
    private Integer re_job;
    private Date re_deleteDate;

    public Integer getRe_id() {
        return re_id;
    }

    public void setRe_id(Integer re_id) {
        this.re_id = re_id;
    }

    public Integer getPe_id() {
        return pe_id;
    }

    public void setPe_id(Integer pe_id) {
        this.pe_id = pe_id;
    }

    public Integer getGr_id() {
        return gr_id;
    }

    public void setGr_id(Integer gr_id) {
        this.gr_id = gr_id;
    }

    public String getRe_pactNo() {
        return re_pactNo;
    }

    public void setRe_pactNo(String re_pactNo) {
        this.re_pactNo = re_pactNo;
    }

    public Date getRe_pactDate() {
        return re_pactDate;
    }

    public void setRe_pactDate(Date re_pactDate) {
        this.re_pactDate = re_pactDate;
    }

    public String getRe_dept() {
        return re_dept;
    }

    public void setRe_dept(String re_dept) {
        this.re_dept = re_dept;
    }

    public Integer getRe_job() {
        return re_job;
    }

    public void setRe_job(Integer re_job) {
        this.re_job = re_job;
    }

    public Date getRe_deleteDate() {
        return re_deleteDate;
    }

    public void setRe_deleteDate(Date re_deleteDate) {
        this.re_deleteDate = re_deleteDate;
    }

}
