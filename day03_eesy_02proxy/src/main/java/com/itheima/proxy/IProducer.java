package com.itheima.proxy;

/**
 * @description:对生产厂家要求的接口
 * @author: wll
 * @create: 2019-12-09 11:16
 **/
public interface IProducer {
    /**销售
     * @param money
     */
    public void saleProduct(float money);

    /**售后
     * @param money
     */
    public void afterService(float money);
}
