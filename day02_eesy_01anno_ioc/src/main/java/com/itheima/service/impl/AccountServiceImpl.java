package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: wll
 * Date: 2019/9/20 20:07
 *账户的业务层实现类
 *曾经xml配置
 *  <bean id="accountService" class="com.itheima.service.impl.IAccountServiceImpl"
 *        scope="" init-method="" destroy-method="" >
 *        <property name ="" value="" /ref=""></property>
 *        </bean>
 *  用于创建对象的
 *      他们的作用就和在xml配置文件中编写一个<bean>标签实现的功能是一样的
 *      @component:
 *             作用：用于把当前类对象存入spring容器中
 *             属性：
 *                  value:用于指定bean的id。当不写时，它的默认值是当前类名，且首字母改小写
 *  用于注入数据的
 *      他们的作用就是和在xml配置文件中的bean标签中写一个<property>标签的功能室一样的
 *  用于改变作用范围的
 *      他们的作用就和在bean标签中使用scope属性实现的功能是一样的
 *  和生命周期相关
 *      他们的作用就和在bean标签中使用init-method和destroy-method的作用是一样的
 */
@Component(value = "accountService")
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;


    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

    public void saveAccount() {

        accountDao.saveAccount();

    }
}
