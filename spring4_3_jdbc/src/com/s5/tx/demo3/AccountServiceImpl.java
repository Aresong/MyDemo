package com.s5.tx.demo3;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//isolation隔离级别，propagation传播行为
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
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
        //int i = 1/0;
        accountDao.inMoney(to, money);

    }

}
