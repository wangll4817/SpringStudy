package com.itheima.service;

/**
 * @description:账户的业务层接口
 * @author: wll
 * @create: 2019-12-09 17:25
 **/
public interface IAccountService {

    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**模拟更新账户
     * @param i
     */
    void updateAccount(int i);

    /**删除账户
     * @return
     */
    int deleteAccount();
}
