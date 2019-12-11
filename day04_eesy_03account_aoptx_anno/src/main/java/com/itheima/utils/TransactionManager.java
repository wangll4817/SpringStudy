package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @description:和事务管理相关的工具类，它包含了：开启事务，提交事务，回滚事务和释放连接
 * @author: wll
 * @create: 2019-12-08 18:40
 **/
@Component("txManager")
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUntils connectionUntils;

    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    private void pt1(){}

    /**
     * 开启事务
     */
    public  void beginTransaction(){
        try {
            connectionUntils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public  void commit(){
        try {
            connectionUntils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public  void rollback(){
        try {
            connectionUntils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */
    public  void release(){
        try {
            connectionUntils.getThreadConnection().close();//还回连接池中
            connectionUntils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            //1.获取参数
            Object [] args = pjp.getArgs();
            //2.开启事务
            this.beginTransaction();
            //3.执行方法
             rtValue = pjp.proceed(args);
            //4.提交事务
            this.commit();

            //返回结果
            return rtValue;
        } catch (Throwable throwable) {
            //5.回滚事务
            this.rollback();
            throw new RuntimeException(throwable);
        }finally {
            //6.释放连接
            this.release();
        }
    }
}
