package com.itheima.factory;

import com.itheima.service.IAccountService;
import com.itheima.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:用于创建Service的代理对象的工厂
 * @author: wll
 * @create: 2019-12-09 15:55
 **/
public class BeanFactory {
    private IAccountService accountService;
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    /**获取Service代理对象
     * @return
     */
    public IAccountService getAccountService(){
        Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**添加事务的支持
                     * @param o
                     * @param method
                     * @param objects
                     * @return
                     * @throws Throwable
                     */
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        Object rtValue = null;
                        try {
                            //1.开启事务
                            txManager.beginTransaction();
                            //2.执行操作
                            rtValue = method.invoke(accountService, objects);
                            //3.提交事务
                            txManager.commit();
                            //4.返回结果
                            return rtValue;
                        }catch (Exception e){
                            //5.回滚操作
                            txManager.rollback();
                            throw new RuntimeException(e);
                        }finally {
                            //6.释放资源
                            txManager.release();
                        }
                    }
                });
        return accountService;
    }
}
