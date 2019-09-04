package com.s5.tx.demo2;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImpl implements AccountService {

    //注入Dao：
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    /**
     * from:转出账户
     * to:转入账户
     * money:转移金额
     * **/
    public void transfer(String from, String to, Double money) {

        accountDao.outMoney(from, money);
        //要是出错了呢？
        int i = 1 / 0;
        accountDao.inMoney(to, money);

    }

}
