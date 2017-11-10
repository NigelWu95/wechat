/**
 * Project Name: wechat
 * File Name: IAccessTokenService.java
 * Package Name: wechat: com.wechat.service
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.service;

import com.wechat.exceptions.AccesssTokenException;
import com.wechat.exceptions.HttpRequestException;

/**
 * ClassName: IAccessTokenService Description: TODO Date Time: 2017年8月2日
 * 上午9:30:33
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see *
 *      Method: getAccessToken Function: TODO
 *
 * @param appId
 * @param appSecret
 * @param requestTimes
 *            It means if access token request failed it can request these times
 *            again.
 * @return
 * @throws AccesssTokenException
 * @throws HttpRequestException
 */
public interface IAccessTokenService {

    String getAccessToken(String appId, String appSecret, int requestTimes)
            throws AccesssTokenException, HttpRequestException;
}