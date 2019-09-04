package com.s5.jdbc.demo1;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * jdbc模板的使用
 **/
public class JdbcDemo1 {

    @Test
    public void demo1() {
        //创建连接池
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///spring4_3?useUnicode=true&amp;characterEncoding=UTF-8";
        dataSource.setUrl(url);
        dataSource.setUsername("root");
        dataSource.setPassword("PSPs5776371");
        //创建jdbc模板
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("insert into account values (null,?,?)", "王兰花秀丽", 10000d);
    }
}
