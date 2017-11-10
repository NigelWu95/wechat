/**
 * Project Name: wechat
 * File Name: AccessTokenDefaultServer.java
 * Package Name: wechat: com.wechat.central
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.central;

import java.util.Date;

import com.wechat.beans.AccessToken;
import com.wechat.beans.HttpRequest;
import com.wechat.constants.WechatJsonKeys;
import com.wechat.exceptions.AccesssTokenException;
import com.wechat.exceptions.HttpRequestException;
import com.wechat.service.IAccessTokenService;
import com.wechat.util.AccessTokenUtil;
import com.wechat.util.HttpUtil;
import com.wechat.util.RequestUtil;

import net.sf.json.JSONObject;

/**
 * ClassName: AccessTokenDefaultServer Description: TODO Date Time: 2017年8月2日
 * 上午9:45:25
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see *      single instance getter.
 *
 * @return AccessTokenDefaultServer /** Get the current valid acces token.
 *
 * @return
 * @throws AccesssTokenException
 * @throws HttpRequestException
 */
public class AccessTokenDefaultServer implements IAccessTokenService {

    private static AccessTokenDefaultServer accessTokenServer;

    private AccessToken accessToken = new AccessToken();

    private AccessTokenDefaultServer() {
    }

    public static synchronized AccessTokenDefaultServer getInstance() {
        if (accessTokenServer == null) {
            accessTokenServer = new AccessTokenDefaultServer();
        }

        return accessTokenServer;
    }

    public String getAccessToken(String appId, String appSecret, int requestTimes)
            throws AccesssTokenException, HttpRequestException {
        // Validate the token is valid or not. If not then going to set new token value.
        if (!AccessTokenUtil.isValid(accessToken)) {
            boolean flag = false;
            for (int i = 1; i <= requestTimes; i++) {
                HttpRequest httpRequest = RequestUtil.getAccessTokenRequest(appId, appSecret);
                JSONObject jsonObject = HttpUtil.sendRequest(httpRequest);
                String token = jsonObject.get(WechatJsonKeys.ACCESS_TOKEN).toString();
                String expiresIn = jsonObject.get(WechatJsonKeys.EXPIRES_IN).toString();
                this.accessToken.setToken(token);
                this.accessToken.setTokenTime((new Date()).getTime());
                this.accessToken.setExpiresIn(Long.valueOf(expiresIn));

                if (AccessTokenUtil.isValid(accessToken)) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                AccesssTokenException accesssTokenException = new AccesssTokenException();
                accesssTokenException.setGetAccessTokenError();
                throw accesssTokenException;
            }
        }

        return this.accessToken.getToken();
    }
}