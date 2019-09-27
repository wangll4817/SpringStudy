package com.itheima.factory;

import com.itheima.service.IAccountService;
import com.itheima.service.impl.IAccountServiceImpl;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: wll
 * Date: 2019/9/25 17:20
 *
 * 模拟一个工厂类（该类可能存在于jar包中，我们无法通过修改密码的方式来提供默认构造函数）
 */
public class StaticFactory {

    public static IAccountService getAccountService(){

        return new IAccountServiceImpl();
    }
}
