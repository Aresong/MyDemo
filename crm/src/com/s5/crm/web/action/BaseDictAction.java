package com.s5.crm.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.s5.crm.entity.BaseDict;
import com.s5.crm.entity.Customer;
import com.s5.crm.service.BaseDictService;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

/**
 * @author Aresong
 * 数据字典action的类
 */
public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {

    private BaseDictService baseDictService;
    private BaseDict baseDict = new BaseDict();

    public void setBaseDictService(BaseDictService baseDictService) {
        this.baseDictService = baseDictService;
    }

    @Override
    public BaseDict getModel() {
        // TODO Auto-generated method stub
        return baseDict;
    }

    //根据类型名称查询字典的方法：findByTypeCode
    public String findByTypeCode() throws IOException {
        List<BaseDict> list = baseDictService.findByTypeCode(baseDict.getDict_type_code());
        //将list转成json=======jsonlib/fastjson
        /**
         * JSONConfig：转json的配置对象
         * JSONArray：将数组和list集合转成json
         * JSONObject：将对象和map转成json
         * **/
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"dict_sort", "dict_enable", "dict_memo"});
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        //将json打印到页面
        ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
        return NONE;
    }

}
