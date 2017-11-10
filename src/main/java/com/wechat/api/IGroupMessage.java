/**
 * Project Name: wechat
 * File Name: IGroupMessage.java
 * Package Name: wechat: com.wechat.api
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.api;

import com.wechat.beans.message.GroupMessageSendResult;
import com.wechat.exceptions.AccesssTokenException;
import com.wechat.exceptions.ConfigException;
import com.wechat.exceptions.ConvertionException;
import com.wechat.exceptions.GroupMessageSendException;
import com.wechat.exceptions.HttpRequestException;
import com.wechat.exceptions.UploadException;

/**
 * ClassName: IGroupMessage Description: TODO Date Time: 2017年8月9日 上午9:29:24
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public interface IGroupMessage {

    /*
     * This method uses wechat filter to send text message to all user. The message
     * you send will enter the message history. And you can only use it one time one
     * day. If you need not let this message enter the message history, the another
     * method send by openid or by tag are suggested.
     */
    GroupMessageSendResult sendTextToAllUserByFilter(String textContent) throws GroupMessageSendException,
            HttpRequestException, AccesssTokenException, ConfigException, ConvertionException;

    GroupMessageSendResult sendTextToAllUserByOpenId(String textContent) throws GroupMessageSendException,
            HttpRequestException, AccesssTokenException, ConfigException, ConvertionException;

    GroupMessageSendResult sendTextToGroupUserByTag(String tag, String textContent) throws GroupMessageSendException,
            HttpRequestException, AccesssTokenException, ConfigException, ConvertionException;

    GroupMessageSendResult sendImageToAllByFilter(String filePath) throws GroupMessageSendException,
            HttpRequestException, AccesssTokenException, ConfigException, ConvertionException, UploadException;

    GroupMessageSendResult sendImageToAllByOpenId(String filePath) throws GroupMessageSendException,
            HttpRequestException, AccesssTokenException, ConfigException, ConvertionException, UploadException;

    GroupMessageSendResult sendImageToGroupUserByTag(String tag, String filePath) throws AccesssTokenException,
            ConfigException, HttpRequestException, UploadException, ConvertionException, GroupMessageSendException;
}