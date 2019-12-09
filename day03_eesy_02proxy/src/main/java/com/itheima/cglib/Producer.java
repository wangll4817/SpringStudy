package com.itheima.cglib;

import com.itheima.proxy.IProducer;

/**
 * @description:一个生产者
 * @author: wll
 * @create: 2019-12-09 11:06
 **/
public class Producer implements IProducer{

    /**销售
     * @param money
     */
    public void saleProduct(float money){
        System.out.println("销售产品，并拿到钱："+ money);
    }

    /**售后
     * @param money
     */
    public void afterService(float money){
        System.out.println("提供售后服务，并拿到钱：" +money);
    }


}
