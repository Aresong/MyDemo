package cn.declaresystem.ssm.mapper;

import java.util.HashMap;
import java.util.List;

import cn.declaresystem.ssm.pojo.Relations;
import cn.declaresystem.ssm.pojo.Staff;

public interface StaffMapper {
    public List<Staff> getList(HashMap<String, Integer> resultMap);

    public int getCount(Integer gr_id);

    public void add(Staff staff);

    public List<Staff> getOther(HashMap<String, String> searchMap);

    public Staff getById(Integer id);

    public void update(Staff staff);

    public void addRe(Relations relations);

    public void delete(HashMap<String, Object> deleteMap);

    public Relations getReById(Integer pe_id);

    public void updateRe(HashMap<String, Object> updateMap);
}
