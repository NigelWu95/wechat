/**
 * Project Name: wechat
 * File Name: AccessTokenUtil.java
 * Package Name: wechat: com.wechat.util
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.util;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.wechat.beans.AccessToken;

/**
 * ClassName: AccessTokenUtil Description: TODO Date Time: 2017年8月1日 下午7:43:19
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class AccessTokenUtil {

    public static boolean isValid(AccessToken accessToken) {
        if (StringUtils.isBlank(accessToken.getToken())) {
            return false;
        }

        if (StringUtils.isBlank(Long.toString(accessToken.getExpiresIn())) || accessToken.getExpiresIn() <= 0) {
            return false;
        }

        /*
         * Using effective time to subtract ten seconds so that it can request new token
         * before expiration.
         */
        long expiresTime = (accessToken.getExpiresIn() - 10) * 1000;
        if ((accessToken.getTokenTime() + expiresTime) < (new Date()).getTime()) {
            return false;
        }

        return true;
    }
}