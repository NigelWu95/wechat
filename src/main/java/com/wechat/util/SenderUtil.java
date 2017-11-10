/**
 * Project Name: wechat
 * File Name: SenderUtil.java
 * Package Name: wechat: com.wechat.util
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.util;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.wechat.beans.message.GroupMessageSender;
import com.wechat.constants.Characters;
import com.wechat.enums.GroupMessageSendTypeEnum;
import com.wechat.enums.MessageTypeEnum;
import com.wechat.exceptions.GroupMessageSendException;

/**
 * ClassName: SenderUtil Description: TODO Date Time: 2017年8月6日 下午12:51:29
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class SenderUtil {

    public static void validate(GroupMessageSender groupMessageSender) throws GroupMessageSendException {
        if (groupMessageSender == null) {
            GroupMessageSendException groupMessageSendException = new GroupMessageSendException();
            groupMessageSendException.setSenderIsNullError();
            throw groupMessageSendException;
        }
    }

    public static GroupMessageSender getTextToAllByFilterSender(String textContent) {
        GroupMessageSender groupMessageSender = new GroupMessageSender();
        groupMessageSender.setSendType(GroupMessageSendTypeEnum.filter);
        groupMessageSender.setIsToAll(true);
        groupMessageSender.setMessageType(MessageTypeEnum.text);
        groupMessageSender.setContent(textContent);
        groupMessageSender.setClientMessageId(
                UUID.randomUUID().toString().replaceAll(Characters.SYMBOL_DELIMTER_MINUS, StringUtils.EMPTY));

        return groupMessageSender;
    }

    public static GroupMessageSender getTextToAllByOpenIdSender(List<String> openIdList, String textContent) {
        GroupMessageSender groupMessageSender = new GroupMessageSender();
        groupMessageSender.setSendType(GroupMessageSendTypeEnum.touser);
        groupMessageSender.setToUser(openIdList);
        groupMessageSender.setMessageType(MessageTypeEnum.text);
        groupMessageSender.setContent(textContent);
        groupMessageSender.setClientMessageId(
                UUID.randomUUID().toString().replaceAll(Characters.SYMBOL_DELIMTER_MINUS, StringUtils.EMPTY));

        return groupMessageSender;
    }

    public static GroupMessageSender getTextToGroupByTagSender(String tag, String textContent) {
        GroupMessageSender groupMessageSender = new GroupMessageSender();
        groupMessageSender.setSendType(GroupMessageSendTypeEnum.filter);
        groupMessageSender.setIsToAll(false);
        groupMessageSender.setTagId(tag);
        groupMessageSender.setMessageType(MessageTypeEnum.text);
        groupMessageSender.setContent(textContent);
        groupMessageSender.setClientMessageId(
                UUID.randomUUID().toString().replaceAll(Characters.SYMBOL_DELIMTER_MINUS, StringUtils.EMPTY));

        return groupMessageSender;
    }

    public static GroupMessageSender getImageToAllByFilterSender(String mediaId) {
        GroupMessageSender groupMessageSender = new GroupMessageSender();
        groupMessageSender.setSendType(GroupMessageSendTypeEnum.filter);
        groupMessageSender.setIsToAll(true);
        groupMessageSender.setMessageType(MessageTypeEnum.image);
        groupMessageSender.setMediaId(mediaId);
        groupMessageSender.setClientMessageId(
                UUID.randomUUID().toString().replaceAll(Characters.SYMBOL_DELIMTER_MINUS, StringUtils.EMPTY));

        return groupMessageSender;
    }

    public static GroupMessageSender getImageToAllByOpenIdSender(List<String> openIdList, String mediaId) {
        GroupMessageSender groupMessageSender = new GroupMessageSender();
        groupMessageSender.setSendType(GroupMessageSendTypeEnum.touser);
        groupMessageSender.setToUser(openIdList);
        groupMessageSender.setMessageType(MessageTypeEnum.image);
        groupMessageSender.setMediaId(mediaId);
        groupMessageSender.setClientMessageId(
                UUID.randomUUID().toString().replaceAll(Characters.SYMBOL_DELIMTER_MINUS, StringUtils.EMPTY));

        return groupMessageSender;
    }

    public static GroupMessageSender getImageToGroupUserByTagSender(String tag, String mediaId) {
        GroupMessageSender groupMessageSender = new GroupMessageSender();
        groupMessageSender.setSendType(GroupMessageSendTypeEnum.filter);
        groupMessageSender.setIsToAll(false);
        groupMessageSender.setTagId(tag);
        groupMessageSender.setMessageType(MessageTypeEnum.image);
        groupMessageSender.setMediaId(mediaId);
        groupMessageSender.setClientMessageId(
                UUID.randomUUID().toString().replaceAll(Characters.SYMBOL_DELIMTER_MINUS, StringUtils.EMPTY));

        return groupMessageSender;
    }
}