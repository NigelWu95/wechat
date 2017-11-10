/**
 * Project Name: wechat
 * File Name: IMessageService.java
 * Package Name: wechat: com.wechat.service
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.service;

import com.wechat.beans.message.GroupMessageSendResult;
import com.wechat.beans.message.GroupMessageSender;
import com.wechat.exceptions.ConvertionException;
import com.wechat.exceptions.GroupMessageSendException;
import com.wechat.exceptions.HttpRequestException;

/**
 * ClassName: IMessageService Description: TODO Date Time: 2017年8月4日 下午2:13:16
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public interface IMessageService {

    GroupMessageSendResult sendGroupMessage(GroupMessageSender groupMessageSender)
            throws GroupMessageSendException, HttpRequestException, ConvertionException;
}