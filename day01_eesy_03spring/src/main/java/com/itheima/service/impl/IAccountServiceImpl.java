package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: wll
 * Date: 2019/9/20 20:07
 *账户的业务层实现类
 */
public class IAccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;


    public IAccountServiceImpl(){
        System.out.println("对象创建了");
    }

    public void saveAccount() {

        accountDao.saveAccount();

    }
}
