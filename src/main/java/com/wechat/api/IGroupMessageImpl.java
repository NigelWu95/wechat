/**
 * Project Name: wechat
 * File Name: IGroupMessageImpl.java
 * Package Name: wechat: com.wechat.api
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.api;

import java.util.List;

import com.wechat.beans.material.UploadMaterialResult;
import com.wechat.beans.message.GroupMessageSendResult;
import com.wechat.beans.message.GroupMessageSender;
import com.wechat.exceptions.AccesssTokenException;
import com.wechat.exceptions.ConfigException;
import com.wechat.exceptions.ConvertionException;
import com.wechat.exceptions.GroupMessageSendException;
import com.wechat.exceptions.HttpRequestException;
import com.wechat.exceptions.UploadException;
import com.wechat.service.IMaterialService;
import com.wechat.service.IMessageService;
import com.wechat.service.IUserService;
import com.wechat.service.impl.IMaterialServiceImpl;
import com.wechat.service.impl.IMessageServiceImpl;
import com.wechat.service.impl.IUserServiceImpl;
import com.wechat.util.SenderUtil;

/**
 * ClassName: IGroupMessageImpl Description: TODO Date Time: 2017年8月9日 上午9:29:05
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class IGroupMessageImpl implements IGroupMessage {

    public GroupMessageSendResult sendTextToAllUserByFilter(String textContent) throws GroupMessageSendException,
            HttpRequestException, AccesssTokenException, ConfigException, ConvertionException {
        GroupMessageSendResult groupMessageRequestResult = new GroupMessageSendResult();
        IMessageService messageService = new IMessageServiceImpl();
        GroupMessageSender groupMessageSender = SenderUtil.getTextToAllByFilterSender(textContent);
        groupMessageRequestResult = messageService.sendGroupMessage(groupMessageSender);

        return groupMessageRequestResult;
    }

    public GroupMessageSendResult sendTextToAllUserByOpenId(String textContent) throws GroupMessageSendException,
            HttpRequestException, AccesssTokenException, ConfigException, ConvertionException {
        GroupMessageSendResult groupMessageRequestResult = new GroupMessageSendResult();
        IMessageService messageService = new IMessageServiceImpl();
        IUserService userService = new IUserServiceImpl();
        List<String> userList = userService.getAllUserOpenIdList();
        GroupMessageSender groupMessageSender = SenderUtil.getTextToAllByOpenIdSender(userList, textContent);
        groupMessageRequestResult = messageService.sendGroupMessage(groupMessageSender);

        return groupMessageRequestResult;
    }

    public GroupMessageSendResult sendTextToGroupUserByTag(String tag, String textContent)
            throws GroupMessageSendException, HttpRequestException, AccesssTokenException, ConfigException,
            ConvertionException {
        GroupMessageSendResult groupMessageRequestResult = new GroupMessageSendResult();
        IMessageService messageService = new IMessageServiceImpl();
        GroupMessageSender groupMessageSender = SenderUtil.getTextToGroupByTagSender(tag, textContent);
        groupMessageRequestResult = messageService.sendGroupMessage(groupMessageSender);

        return groupMessageRequestResult;
    }

    public GroupMessageSendResult sendImageToAllByFilter(String filePath) throws GroupMessageSendException,
            HttpRequestException, AccesssTokenException, ConfigException, ConvertionException, UploadException {
        GroupMessageSendResult groupMessageRequestResult = new GroupMessageSendResult();
        IMaterialService materialService = new IMaterialServiceImpl();
        UploadMaterialResult uploadMaterialResult = materialService.uploadForeverImageMaterial(filePath);
        String mediaId = uploadMaterialResult.getMediaId();
        IMessageService messageService = new IMessageServiceImpl();
        GroupMessageSender groupMessageSender = SenderUtil.getImageToAllByFilterSender(mediaId);
        groupMessageRequestResult = messageService.sendGroupMessage(groupMessageSender);

        return groupMessageRequestResult;
    }

    public GroupMessageSendResult sendImageToAllByOpenId(String filePath) throws GroupMessageSendException,
            HttpRequestException, AccesssTokenException, ConfigException, ConvertionException, UploadException {
        GroupMessageSendResult groupMessageRequestResult = new GroupMessageSendResult();
        IMaterialService materialService = new IMaterialServiceImpl();
        UploadMaterialResult uploadMaterialResult = materialService.uploadTemporaryImageMaterial(filePath);
        String mediaId = uploadMaterialResult.getMediaId();
        IMessageService messageService = new IMessageServiceImpl();
        IUserService userService = new IUserServiceImpl();
        List<String> userList = userService.getAllUserOpenIdList();
        GroupMessageSender groupMessageSender = SenderUtil.getImageToAllByOpenIdSender(userList, mediaId);
        groupMessageRequestResult = messageService.sendGroupMessage(groupMessageSender);

        return groupMessageRequestResult;
    }

    public GroupMessageSendResult sendImageToGroupUserByTag(String tag, String filePath)
            throws AccesssTokenException, ConfigException, HttpRequestException, UploadException, ConvertionException,
            GroupMessageSendException {
        GroupMessageSendResult groupMessageRequestResult = new GroupMessageSendResult();
        IMaterialService materialService = new IMaterialServiceImpl();
        UploadMaterialResult uploadMaterialResult = materialService.uploadTemporaryImageMaterial(filePath);
        String mediaId = uploadMaterialResult.getMediaId();
        IMessageService messageService = new IMessageServiceImpl();
        GroupMessageSender groupMessageSender = SenderUtil.getImageToGroupUserByTagSender(tag, mediaId);
        groupMessageRequestResult = messageService.sendGroupMessage(groupMessageSender);

        return groupMessageRequestResult;
    }
}