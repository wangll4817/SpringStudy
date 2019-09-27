package com.itheima.ui;

import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.IAccountServiceImpl;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: wll
 * Date: 2019/9/21 9:07
 *
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args){
//        IAccountService as = new IAccountServiceImpl();
        for (int i = 0; i < 5; i++){
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }

    }
}
