/**
 * Project Name: wechat
 * File Name: WechatAPIFactory.java
 * Package Name: wechat: com.wechat.central
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.central;

/**
 * ClassName: WechatAPIFactory Description: TODO Date Time: 2017年8月9日 上午9:32:26
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class WechatAPIFactory {

    public Object create(Class<?> clazz) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String className = clazz.getName();
        String implClassName = className + "Impl";
        Class<?> implClass = Class.forName(implClassName);
        Object object = implClass.newInstance();
        return object;
    }
}