/**
 * Project Name: wechat
 * File Name: GroupMessageSendResult.java
 * Package Name: wechat: com.wechat.beans.message
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.beans.message;

import com.wechat.beans.BasicStatus;
import com.wechat.exceptions.ConvertionException;
import com.wechat.util.JSONUtil;

import net.sf.json.JSONObject;

/**
 * ClassName: GroupMessageSendResult Description: TODO Date Time: 2017年8月4日
 * 下午2:17:22
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class GroupMessageSendResult extends BasicStatus {

    private String type;
    private long messageId;
    private String messageDateId;
    private String messageStatus;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getMessageDateId() {
        return messageDateId;
    }

    public void setMessageDateId(String messageDateId) {
        this.messageDateId = messageDateId;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }

    public static GroupMessageSendResult fromJson(JSONObject resultJson) throws ConvertionException {
        GroupMessageSendResult groupMessageRequestResult = new GroupMessageSendResult();
        groupMessageRequestResult = (GroupMessageSendResult) JSONUtil.toObject(groupMessageRequestResult, resultJson);

        return groupMessageRequestResult;
    }
}