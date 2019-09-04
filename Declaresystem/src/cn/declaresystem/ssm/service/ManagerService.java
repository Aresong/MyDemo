package cn.declaresystem.ssm.service;

import java.util.HashMap;
import java.util.List;

import cn.declaresystem.ssm.pojo.Staff;

public interface ManagerService {
    public Integer getManagerCount(Integer gr_id);

    public List<Staff> getStaffList(HashMap<String, Integer> resultMap);

    public List<Staff> getAllStaffList(Integer gr_id, String personName, String personId);

    public void updateStaffJob(Integer pe_id, Integer re_job, Integer gr_id);

    public void cancelStaffJob(Integer pe_id, Integer re_job, Integer gr_id);
}
