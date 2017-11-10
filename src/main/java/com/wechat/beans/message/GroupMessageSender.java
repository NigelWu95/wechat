/**
 * Project Name: wechat
 * File Name: GroupMessageSender.java
 * Package Name: wechat: com.wechat.beans.message
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.beans.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.wechat.constants.WechatJsonKeys;
import com.wechat.enums.GroupMessageSendTypeEnum;
import com.wechat.enums.MessageTypeEnum;
import com.wechat.exceptions.GroupMessageSendException;

import net.sf.json.JSONObject;

/**
 * ClassName: GroupMessageSender Description: TODO Date Time: 2017年8月2日
 * 下午5:54:44
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class GroupMessageSender {

    private GroupMessageSendTypeEnum sendType;
    private Boolean isToAll;
    private String tagId;
    private List<String> toUser;
    private MessageTypeEnum messageType;
    private String content;
    private String mediaId;
    private String cardId;
    private String title;
    private String description;
    private String thumbMediaId;
    private int sendIgnoreReprint;
    private String clientMessageId;

    public GroupMessageSendTypeEnum getSendType() {
        return sendType;
    }

    public void setSendType(GroupMessageSendTypeEnum sendType) {
        this.sendType = sendType;
    }

    public Boolean getIsToAll() {
        return isToAll;
    }

    public void setIsToAll(Boolean isToAll) {
        this.isToAll = isToAll;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public List<String> getToUser() {
        return toUser;
    }

    public void setToUser(List<String> toUser) {
        this.toUser = toUser;
    }

    public MessageTypeEnum getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageTypeEnum messageType) {
        this.messageType = messageType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public int getSendIgnoreReprint() {
        return sendIgnoreReprint;
    }

    public void setSendIgnoreReprint(int sendIgnoreReprint) {
        this.sendIgnoreReprint = sendIgnoreReprint;
    }

    public String getClientMessageId() {
        return clientMessageId;
    }

    public void setClientMessageId(String clientMessageId) {
        this.clientMessageId = clientMessageId;
    }

    public JSONObject toRequestJson() throws GroupMessageSendException {
        GroupMessageSendException groupMessageSendException = new GroupMessageSendException();
        Map<String, Object> senderMap = new HashMap<String, Object>();
        Map<String, Object> messageMap = new HashMap<String, Object>();

        if (GroupMessageSendTypeEnum.filter.equals(this.sendType)) {
            Map<String, Object> filterMap = new HashMap<String, Object>();

            if (null == this.isToAll) {
                groupMessageSendException.setIsToAllIsNullError();
                throw groupMessageSendException;
            } else {
                if (!this.isToAll && StringUtils.isBlank(this.tagId)) {
                    groupMessageSendException.setTagIdIsNullError();
                    throw groupMessageSendException;
                }

                filterMap.put(WechatJsonKeys.IS_TO_ALL, this.isToAll);
                filterMap.put(WechatJsonKeys.TAG_ID, this.tagId);
                senderMap.put(WechatJsonKeys.FILTER, filterMap);
            }
        } else if (GroupMessageSendTypeEnum.touser.equals(this.sendType)) {
            if (null == this.toUser) {
                groupMessageSendException.setToUserIsNullError();
                throw groupMessageSendException;
            }

            if (this.toUser.size() <= 1) {
                this.toUser.add(StringUtils.EMPTY);
            }
            senderMap.put(WechatJsonKeys.TO_USER, this.toUser);
        } else {
            groupMessageSendException.setSendTypeIsNullError();
            throw groupMessageSendException;
        }

        if (null == this.messageType) {
            groupMessageSendException.setMessageTypeIsNullError();
            throw groupMessageSendException;
        } else if (MessageTypeEnum.text.equals(this.messageType)) {
            if (StringUtils.isBlank(this.content)) {
                groupMessageSendException.setContentIsNullError();
                throw groupMessageSendException;
            }
            messageMap.put(WechatJsonKeys.CONTENT, this.content);
        } else if (MessageTypeEnum.wxcard.equals(this.messageType)) {
            if (StringUtils.isBlank(this.cardId)) {
                groupMessageSendException.setCardIdIsNullError();
                throw groupMessageSendException;
            }
            messageMap.put(WechatJsonKeys.CARD_ID, this.cardId);
        } else {
            if (StringUtils.isBlank(this.mediaId)) {
                groupMessageSendException.setMediaIdIsNullError();
                throw groupMessageSendException;
            }
            messageMap.put(WechatJsonKeys.MEDIA_ID, this.mediaId);
        }

        senderMap.put(this.messageType.toString(), messageMap);
        senderMap.put(WechatJsonKeys.MESSAGE_TYPE, this.messageType.toString());

        if (!StringUtils.isBlank(this.title)) {
            senderMap.put(WechatJsonKeys.TITLE, this.title);
        }

        if (!StringUtils.isBlank(this.description)) {
            senderMap.put(WechatJsonKeys.DESCRIPTION, this.description);
        }

        if (!StringUtils.isBlank(this.thumbMediaId)) {
            senderMap.put(WechatJsonKeys.THUMB_MEDIA_ID, this.thumbMediaId);
        }

        if (!StringUtils.isBlank(this.clientMessageId)) {
            senderMap.put(WechatJsonKeys.CLIENT_MESSAGE_ID, this.clientMessageId);
        }

        senderMap.put(WechatJsonKeys.SEND_IGNORE_REPRINT, this.sendIgnoreReprint);
        JSONObject senderJson = JSONObject.fromObject(senderMap);

        return senderJson;
    }
}