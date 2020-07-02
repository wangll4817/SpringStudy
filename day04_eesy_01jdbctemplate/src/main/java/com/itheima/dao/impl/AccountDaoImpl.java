package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @description:直接继承spring的JdbcDaoSupport类 缺点不能再使用注解，适用xml文件
 * @author: wll
 * @create: 2019-12-10 17:44
 **/
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {


    public Account findAccountById(Integer accountId) {
        List<Account> accounts = getJdbcTemplate().query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class),accountId);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    public Account findAccountByName(String accountName) {
        List<Account> accounts = getJdbcTemplate().query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class),accountName);
        if (accounts.isEmpty()){
            return null;
        }
        if (accounts.size() > 1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    public void updateAccount(Account account) {
        getJdbcTemplate().update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }
}