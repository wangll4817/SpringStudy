package com.itheima.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @description:链接的工具类，它用于从数据源中获取一个链接，并且实现和线程的绑定
 * @author: wll
 * @create: 2019-12-08 18:31
 **/
@Component("connectionUtils")
public class ConnectionUntils {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    @Autowired
    private DataSource dataSource;

    /**获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection(){
        //1.先从ThreadLocal上获取
        Connection conn = tl.get();
        //2.判断当前线程上是否有连接
        if (conn == null){
            //3.从数据源中获取一个连接，并且存入ThreadLocal中
            try {
                conn = dataSource.getConnection();
                conn.setAutoCommit(false);
                tl.set(conn);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return conn;
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        tl.remove();
    }
}
