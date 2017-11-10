/**
 * Project Name: wechat
 * File Name: AccessToken.java
 * Package Name: wechat: com.wechat.beans
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.beans;

/**
 * ClassName: AccessToken Description: TODO Date Time: 2017年8月2日 上午10:50:52
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class AccessToken {

    private String token; // Access token string.
    private long expiresIn; // Access token valid seconds.
    private long tokenTime; // The token producted time.

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public long getTokenTime() {
        return tokenTime;
    }

    public void setTokenTime(long tokenTime) {
        this.tokenTime = tokenTime;
    }

    @Override
    public String toString() {
        return "AccessToken [token=" + token + ", expiresIn=" + expiresIn + "]";
    }
}