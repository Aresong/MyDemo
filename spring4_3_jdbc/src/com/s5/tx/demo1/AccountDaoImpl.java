package com.s5.tx.demo1;

//import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

//	private JdbcTemplate jdbcTemplate;
//	
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}

    @Override
    public void outMoney(String from, Double money) {
        this.getJdbcTemplate().update("update account set money=money-? where name=?", money, from);
    }

    @Override
    public void inMoney(String to, Double money) {
        this.getJdbcTemplate().update("update account set money=money+? where name=?", money, to);
    }

}
