package com.itheima.service.impl;

import com.itheima.service.IAccountService;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: wll
 * Date: 2019/9/20 20:07
 *账户的业务层实现类
 */
public class IAccountServiceImpl implements IAccountService {

    //如果是经常变化的数据，并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public IAccountServiceImpl(String name, Integer age, Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount() {

        System.out.println("service中的saveAccount方法执行了......"+name+","+age+","+birthday);

    }
}
