package com.itheima.service.impl;

import com.itheima.service.IAccountService;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: wll
 * Date: 2019/9/20 20:07
 *账户的业务层实现类
 */
public class IAccountServiceImpl implements IAccountService {



    public IAccountServiceImpl(){

        System.out.println("对象创建了");
    }

    public void saveAccount() {

        System.out.println("service中的saveAccount方法执行了......");

    }

    public void init() {

        System.out.println("对象初始化了......");

    }

    public void destroy() {

        System.out.println("对象销毁了......");

    }
}
