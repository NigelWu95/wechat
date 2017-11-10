/**
 * Project Name: wechat
 * File Name: IUserServiceImpl.java
 * Package Name: wechat: com.wechat.service.impl
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.wechat.beans.HttpRequest;
import com.wechat.beans.Page;
import com.wechat.beans.user.Fans;
import com.wechat.beans.user.Subscriber;
import com.wechat.central.AccessTokenProxy;
import com.wechat.constants.WechatJsonKeys;
import com.wechat.enums.LanguageTypeEnum;
import com.wechat.exceptions.AccesssTokenException;
import com.wechat.exceptions.ConfigException;
import com.wechat.exceptions.ConvertionException;
import com.wechat.exceptions.HttpRequestException;
import com.wechat.service.IUserService;
import com.wechat.util.HttpUtil;
import com.wechat.util.PageUtil;
import com.wechat.util.RequestUtil;

import net.sf.json.JSONObject;

/**
 * ClassName: IUserServiceImpl Description: TODO Date Time: 2017年8月5日 下午6:29:27
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class IUserServiceImpl implements IUserService {

    private String accessToken;

    public IUserServiceImpl() throws AccesssTokenException, ConfigException, HttpRequestException {
        AccessTokenProxy accessTokenProxy = new AccessTokenProxy();
        accessToken = accessTokenProxy.getAccessToken();
    }

    public Fans getFansInfo(String nextOpenId) throws HttpRequestException, ConvertionException {
        HttpRequest httpRequest = RequestUtil.getFansRequest(accessToken, nextOpenId);
        JSONObject resultJson = HttpUtil.sendRequest(httpRequest);
        Fans fans = Fans.fromJson(resultJson);

        return fans;
    }

    public Subscriber getSubscriber(String openId, LanguageTypeEnum lang)
            throws HttpRequestException, ConvertionException {
        HttpRequest httpRequest = RequestUtil.getSubscriberInfoRequest(accessToken, openId, lang);
        JSONObject resultJson = HttpUtil.sendRequest(httpRequest);
        Subscriber subscriber = Subscriber.fromJson(resultJson);

        return subscriber;
    }

    @SuppressWarnings("unchecked")
    public List<String> getAllUserOpenIdList() throws HttpRequestException, ConvertionException {
        Fans fans = getFansInfo(StringUtils.EMPTY);
        int total = fans.getTotal();
        int count = fans.getCount();
        String nextOpenId = fans.getNextOpenId();
        JSONObject data = fans.getData();
        List<String> openIdList = (List<String>) data.get(WechatJsonKeys.USER_OPEN_ID);

        if (count < total) {
            Page page = new Page();
            page.setItemsTotal(total);
            page.setPageSize(10000);
            int queryTimes = PageUtil.getQueryTimes(page);

            for (int i = 1; i < queryTimes; i++) {
                fans = getFansInfo(nextOpenId);
                List<String> openIdTemp = (List<String>) fans.getData().get(WechatJsonKeys.USER_OPEN_ID);
                openIdList.addAll(openIdTemp);
            }
        }

        return openIdList;
    }
}