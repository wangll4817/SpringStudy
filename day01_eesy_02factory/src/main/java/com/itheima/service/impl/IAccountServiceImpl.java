package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: wll
 * Date: 2019/9/20 20:07
 *账户的业务层实现类
 */
public class IAccountServiceImpl implements IAccountService {

//    private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

//    private int i = 1;

    public void saveAccount() {

        int i = 1;
        accountDao.saveAccount();

        System.out.println(i);
        i++;

    }
}
