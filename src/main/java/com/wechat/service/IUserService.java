/**
 * Project Name: wechat
 * File Name: IUserService.java
 * Package Name: wechat: com.wechat.service
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.service;

import java.util.List;

import com.wechat.beans.user.Fans;
import com.wechat.beans.user.Subscriber;
import com.wechat.enums.LanguageTypeEnum;
import com.wechat.exceptions.ConvertionException;
import com.wechat.exceptions.HttpRequestException;

/**
 * ClassName: IUserService Description: TODO Date Time: 2017年8月5日 下午6:29:12
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public interface IUserService {

    Fans getFansInfo(String nextOpenId) throws HttpRequestException, ConvertionException;

    Subscriber getSubscriber(String openId, LanguageTypeEnum lang) throws HttpRequestException, ConvertionException;

    List<String> getAllUserOpenIdList() throws HttpRequestException, ConvertionException;
}
