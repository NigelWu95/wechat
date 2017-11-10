/**
 * Project Name: wechat
 * File Name: AccessTokenProxy.java
 * Package Name: wechat: com.wechat.central
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.central;

import org.apache.commons.lang.StringUtils;

import com.wechat.exceptions.AccesssTokenException;
import com.wechat.exceptions.ConfigException;
import com.wechat.exceptions.HttpRequestException;
import com.wechat.service.IAccessTokenService;

/**
 * ClassName: AccessTokenProxy Description: TODO Date Time: 2017年8月2日 上午9:30:15
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see    /**
     * Get the valid access token by the access token server.
     *
     * @return String(access token string)
     * @throws AccesssTokenException
     * @throws ConfigException
     * @throws HttpRequestException
    /**
     * Load the custom access token server by reflection.
     *
     * @return IAccessTokenService
     * @throws ConfigException
 */
public class AccessTokenProxy {

    private String appId;
    private String appSecret;
    private int requestTimes;
    private String customerServerClass;

    public AccessTokenProxy() throws ConfigException {
        this.customerServerClass = Config.getInstance().getAccessTokenServer();
        this.appId = Config.getInstance().getAppId();
        this.appSecret = Config.getInstance().getAppSecret();
        this.requestTimes = Integer.valueOf(Config.getInstance().getRequestTimes());
    }

     */
    public String getAccessToken() throws AccesssTokenException, ConfigException, HttpRequestException {
        IAccessTokenService accessTokenServer = null;

        /*
         * If there is a custom server, using it to get access token. Else using default
         * server.
         */
        if (!StringUtils.isBlank(customerServerClass)) {
            accessTokenServer = customerServer();
        } else {
            accessTokenServer = AccessTokenDefaultServer.getInstance();
        }

        return accessTokenServer.getAccessToken(appId, appSecret, requestTimes);
    }

     */
    private IAccessTokenService customerServer() throws ConfigException {
        String className = customerServerClass;
        IAccessTokenService customerServer = null;

        try {
            Class<?> clazz = Class.forName(className);
            customerServer = (IAccessTokenService) clazz.newInstance();
        } catch (Exception e) {
            ConfigException configException = new ConfigException();
            configException.setNoCustomServerError(e.getMessage());
            throw configException;
        }

        return customerServer;
    }
}