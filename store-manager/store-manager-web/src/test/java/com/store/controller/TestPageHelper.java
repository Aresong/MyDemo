package com.store.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.store.mapper.TbItemMapper;
import com.store.pojo.TbItem;
import com.store.pojo.TbItemExample;

public class TestPageHelper {
    @Test
    public void testPageHelper() {
        //创建一个Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        //从Spring容器中获得Mapper的代理对象
        TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);
        //执行查询，并分页
        TbItemExample example = new TbItemExample();
        //分页处理
        PageHelper.startPage(2, 10);
        List<TbItem> list = mapper.selectByExample(example);
        for (TbItem tbItem : list) {
            System.out.println(tbItem.getTitle());
        }
        //取分页信息
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        System.out.println("共商品：" + total);
    }
}
