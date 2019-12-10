package com.itheima.dao;

import com.itheima.domain.Account;

/**
 * @description:账户的持久层接口
 * @author: wll
 * @create: 2019-12-10 17:41
 **/
public interface IAccountDao {

    /**根据Id查询账户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**根据名称查询账户
     * @param accountName
     * @return
     */
    Account findAccountByName(String accountName);

    /**更新账户
     * @param account
     */
    void updateAccount(Account account);
}
