package cn.declaresystem.ssm.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.declaresystem.ssm.mapper.ManagerMapper;
import cn.declaresystem.ssm.pojo.Staff;
import cn.declaresystem.ssm.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private ManagerMapper managerMapper;

    @Override
    public Integer getManagerCount(Integer gr_id) {
        return managerMapper.getCount(gr_id);
    }

    @Override
    public List<Staff> getStaffList(HashMap<String, Integer> resultMap) {
        return managerMapper.getList(resultMap);
    }

    @Override
    public List<Staff> getAllStaffList(Integer gr_id, String personName, String personId) {
        HashMap<String, Object> searchMap = new HashMap<String, Object>();
        if (null == personName || "".equals(personName)) {
            personName = "%%";
        } else {
            personName = "%" + personName + "%";
        }
        if (null == personId || "".equals(personId)) {
            personId = "%%";
        } else {
            personId = "%" + personId + "%";
        }
        searchMap.put("gr_id", gr_id);
        searchMap.put("personName", personName);
        searchMap.put("personId", personId);
        return managerMapper.getAllList(searchMap);
    }

    @Override
    public void updateStaffJob(Integer pe_id, Integer re_job, Integer gr_id) {
        HashMap<String, Integer> updateMap = new HashMap<String, Integer>();
        updateMap.put("pe_id", pe_id);
        updateMap.put("re_job", re_job);
        updateMap.put("gr_id", gr_id);
        managerMapper.update(updateMap);
    }

    @Override
    public void cancelStaffJob(Integer pe_id, Integer re_job, Integer gr_id) {
        HashMap<String, Integer> updateMap = new HashMap<String, Integer>();
        updateMap.put("pe_id", pe_id);
        updateMap.put("re_job", re_job);
        updateMap.put("gr_id", gr_id);
        managerMapper.cancelJob(updateMap);
    }
}
