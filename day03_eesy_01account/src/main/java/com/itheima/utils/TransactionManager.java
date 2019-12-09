package com.itheima.utils;

import java.sql.SQLException;

/**
 * @description:和事务管理相关的工具类，它包含了：开启事务，提交事务，回滚事务和释放连接
 * @author: wll
 * @create: 2019-12-08 18:40
 **/
public class TransactionManager {

    private ConnectionUntils connectionUntils;

    public void setConnectionUntils(ConnectionUntils connectionUntils) {
        this.connectionUntils = connectionUntils;
    }

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
}
