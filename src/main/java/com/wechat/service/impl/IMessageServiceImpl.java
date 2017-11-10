/**
 * Project Name: wechat
 * File Name: IMessageServiceImpl.java
 * Package Name: wechat: com.wechat.service.impl
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.service.impl;

import com.wechat.beans.HttpRequest;
import com.wechat.beans.message.GroupMessageSendResult;
import com.wechat.beans.message.GroupMessageSender;
import com.wechat.central.AccessTokenProxy;
import com.wechat.enums.GroupMessageSendTypeEnum;
import com.wechat.exceptions.AccesssTokenException;
import com.wechat.exceptions.ConfigException;
import com.wechat.exceptions.ConvertionException;
import com.wechat.exceptions.GroupMessageSendException;
import com.wechat.exceptions.HttpRequestException;
import com.wechat.service.IMessageService;
import com.wechat.util.HttpUtil;
import com.wechat.util.RequestUtil;
import com.wechat.util.SenderUtil;

import net.sf.json.JSONObject;

/**
 * ClassName: IMessageServiceImpl Description: TODO Date Time: 2017年8月4日
 * 下午2:30:11
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class IMessageServiceImpl implements IMessageService {

    private String accessToken;

    public IMessageServiceImpl() throws AccesssTokenException, ConfigException, HttpRequestException {
        AccessTokenProxy accessTokenProxy = new AccessTokenProxy();
        accessToken = accessTokenProxy.getAccessToken();
    }

    public GroupMessageSendResult sendGroupMessage(GroupMessageSender groupMessageSender)
            throws GroupMessageSendException, HttpRequestException, ConvertionException {
        GroupMessageSendResult groupMessageSendResult = null;
        HttpRequest httpRequest = null;
        SenderUtil.validate(groupMessageSender);

        if (GroupMessageSendTypeEnum.filter.equals(groupMessageSender.getSendType())) {
            httpRequest = RequestUtil.getGroupMessageSendByTagRequest(accessToken);
        } else if (GroupMessageSendTypeEnum.touser.equals(groupMessageSender.getSendType())) {
            httpRequest = RequestUtil.getGroupMessageSendByOpenIdRequest(accessToken);
        }

        httpRequest.setRequestBody(groupMessageSender.toRequestJson());
        JSONObject resultJson = HttpUtil.sendRequest(httpRequest);
        groupMessageSendResult = GroupMessageSendResult.fromJson(resultJson);

        return groupMessageSendResult;
    }
}