package com.itheima.dao.impl;

import com.itheima.damain.Account;
import com.itheima.dao.IAccountDao;
import com.itheima.utils.ConnectionUntils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: wll
 * Date: 2019/9/29 10:30
 * 账户持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner runner;
    @Autowired
    private ConnectionUntils connectionUntils;

    public List<Account> findAllAccount() {
        try {
            return runner.query(connectionUntils.getThreadConnection(), "select* from account", new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(Integer accountId) {
        try {
            return runner.query(connectionUntils.getThreadConnection(),"select * from account where id = ?", new BeanHandler<Account>(Account.class), accountId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try {
             runner.update(connectionUntils.getThreadConnection(),"insert into account(name, money)values(?,?)",account.getName(), account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void updateAccount(Account account) {
        try {
            runner.update(connectionUntils.getThreadConnection(),"update account set name=?, money=? where id=?",account.getName(), account.getMoney(),account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteAccount(Integer accountId) {
        try {
            runner.update(connectionUntils.getThreadConnection(),"delete from account where id=?",accountId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountByName(String accountName) {
        try {
            List<Account> accounts = runner.query(connectionUntils.getThreadConnection(),"select * from account where name = ?", new BeanListHandler<Account>(Account.class), accountName);
            if (accounts == null || accounts.size() == 0){
                return null;
            }
            if (accounts.size() > 1){
                throw new RuntimeException("结果集不唯一，数据有问题");
            }
            return accounts.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
