package com.s5.tx.demo1;

public interface AccountDao {
    public void outMoney(String from, Double money);

    public void inMoney(String to, Double money);
}
