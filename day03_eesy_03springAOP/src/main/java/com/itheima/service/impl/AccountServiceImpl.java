package com.itheima.service.impl;

import com.itheima.service.IAccountService;

/**
 * @description:账户的业务层实现类
 * @author: wll
 * @create: 2019-12-09 17:27
 **/
public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    public void updateAccount(int i) {
        System.out.println("执行了修改" + i);
    }

    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
