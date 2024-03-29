package cn.declaresystem.ssm.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.declaresystem.ssm.mapper.StaffMapper;
import cn.declaresystem.ssm.pojo.Relations;
import cn.declaresystem.ssm.pojo.Staff;
import cn.declaresystem.ssm.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {
    @Resource
    private StaffMapper staffMapper;

    @Override
    public List<Staff> getStaffList(HashMap<String, Integer> resultMap) {
        return staffMapper.getList(resultMap);
    }

    @Override
    public int getStaffCount(Integer gr_id) {
        return staffMapper.getCount(gr_id);
    }

    @Override
    public void saveStaff(Staff staff) {
        staffMapper.add(staff);
    }

    @Override
    public List<Staff> getOtherStaffList(String personName, String personId) {
        HashMap<String, String> searchMap = new HashMap<String, String>();
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
        searchMap.put("personName", personName);
        searchMap.put("personId", personId);
        return staffMapper.getOther(searchMap);
    }

    @Override
    public Staff getStaffById(Integer id) {
        Staff _staff = staffMapper.getById(id);
        return _staff;
    }

    @Override
    public void updateStaff(Staff staff) {
        staffMapper.update(staff);
    }

    @Override
    public void addRelation(Relations relations) {
        staffMapper.addRe(relations);
    }

    @Override
    public void deleteStaff(Date re_deleteDate, Integer pe_id) {
        HashMap<String, Object> deleteMap = new HashMap<String, Object>();
        deleteMap.put("re_deleteDate", re_deleteDate);
        deleteMap.put("pe_id", pe_id);
        staffMapper.delete(deleteMap);
    }

    @Override
    public Relations getRelationById(Integer pe_id) {
        return staffMapper.getReById(pe_id);
    }

    @Override
    public void updateStaffRelation(Integer pe_id, String re_pactNo, Date re_pactDate,
                                    String re_dept) {
        HashMap<String, Object> updateMap = new HashMap<String, Object>();
        updateMap.put("pe_id", pe_id);
        updateMap.put("re_pactNo", re_pactNo);
        updateMap.put("re_pactDate", re_pactDate);
        updateMap.put("re_dept", re_dept);
        staffMapper.updateRe(updateMap);
    }
}
