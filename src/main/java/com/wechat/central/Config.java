/**
 * Project Name: wechat
 * File Name: Config.java
 * Package Name: wechat: com.wechat.central
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.central;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

import com.wechat.constants.CommonKeywords;
import com.wechat.exceptions.ConfigException;

/**
 * ClassName: Config Description: TODO Date Time: 2017年8月2日 上午9:45:25
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class Config {

    private static Config config;

    private String url;
    private String token;
    private String encodingAESKey;
    private String appId;
    private String appSecret;
    private String requestTimes;
    private String accessTokenServer;

    private Config() throws ConfigException {
        ConfigException configException = new ConfigException();
        Properties p = new Properties();
        InputStream inStream = this.getClass().getResourceAsStream(CommonKeywords.CONFIG_FILE);

        if (inStream == null) {
            configException.setNoConfigFileError();
            throw configException;
        }

        try {
            p.load(inStream);

            this.url = p.getProperty(CommonKeywords.WECHAT_URL);
            if (StringUtils.isNotBlank(url))
                this.url = this.url.trim();

            this.encodingAESKey = p.getProperty(CommonKeywords.WECHAT_ENCODING_AES_KEY);
            if (StringUtils.isNotBlank(encodingAESKey))
                this.encodingAESKey = this.encodingAESKey.trim();

            this.token = p.getProperty(CommonKeywords.WECHAT_TOKEN);
            if (StringUtils.isNotBlank(token))
                this.token = this.token.trim();

            this.appId = p.getProperty(CommonKeywords.WECHAT_APP_ID);
            if (StringUtils.isNotBlank(appId))
                this.appId = this.appId.trim();

            this.appSecret = p.getProperty(CommonKeywords.WECHAT_APP_SECRET);
            if (StringUtils.isNotBlank(appSecret))
                this.appSecret = this.appSecret.trim();

            this.requestTimes = p.getProperty(CommonKeywords.WECHAT_ACCESS_TOKEN_REQQUEST_TIMES);
            if (StringUtils.isNotBlank(requestTimes)) {
                if (StringUtils.isNumericSpace(requestTimes)) {
                    this.requestTimes = this.requestTimes.trim();
                } else {
                    this.requestTimes = CommonKeywords.DEFAULT_ACCESS_TOKEN_REQUEST_TIMES;
                }
            } else {
                this.requestTimes = CommonKeywords.DEFAULT_ACCESS_TOKEN_REQUEST_TIMES;
            }

            this.accessTokenServer = p.getProperty(CommonKeywords.WECHAT_ACCESS_TOKEN_SERVER_CLASS);
            if (StringUtils.isNotBlank(accessTokenServer))
                this.accessTokenServer = this.accessTokenServer.trim();

            inStream.close();
        } catch (IOException e) {
            configException.setLoadConfigError(e.getMessage());
            throw configException;
        }
    }

    public static synchronized Config getInstance() throws ConfigException {
        if (config == null) {
            config = new Config();
        }

        return config;
    }

    public String getToken() {
        return token;
    }

    public String getAppId() throws ConfigException {
        if (StringUtils.isBlank(appId)) {
            ConfigException configException = new ConfigException();
            configException.setAppIdIsNullError();
            throw configException;
        }

        return appId;
    }

    public String getAppSecret() throws ConfigException {
        if (StringUtils.isBlank(appSecret)) {
            ConfigException configException = new ConfigException();
            configException.setAppSecretIsNullError();
            throw configException;
        }

        return appSecret;
    }

    public String getRequestTimes() {
        return requestTimes;
    }

    public String getUrl() {
        return url;
    }

    public String getEncodingAESKey() {
        return encodingAESKey;
    }

    public String getAccessTokenServer() {
        return accessTokenServer;
    }
}