/**
 * Project Name: wechat
 * File Name: GroupMessageSendException.java
 * Package Name: wechat: com.wechat.exceptions
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.exceptions;

import com.wechat.beans.BasicStatus;
import com.wechat.constants.CustomExceptions;

/**
 * ClassName: GroupMessageSendException Description: TODO Date Time: 2017年8月3日
 * 下午11:20:33
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class GroupMessageSendException extends Exception {

    private static final long serialVersionUID = 3917940145717508743L;

    private BasicStatus basicStatus;

    public GroupMessageSendException() {
        basicStatus = new BasicStatus();
    }

    public void setSenderIsNullError() {
        basicStatus.setErrorCode(CustomExceptions.ERROR_CODE_SENDER);
        basicStatus.setErrorMessage(CustomExceptions.ERROR_MESSAGE_SENDER);
    }

    public void setSendTypeIsNullError() {
        basicStatus.setErrorCode(CustomExceptions.ERROR_CODE_SEND_TYPE);
        basicStatus.setErrorMessage(CustomExceptions.ERROR_MESSAGE_SEND_TYPE);
    }

    public void setIsToAllIsNullError() {
        basicStatus.setErrorCode(CustomExceptions.ERROR_CODE_IS_TO_ALL);
        basicStatus.setErrorMessage(CustomExceptions.ERROR_MESSAGE_IS_TO_ALL);
    }

    public void setTagIdIsNullError() {
        basicStatus.setErrorCode(CustomExceptions.ERROR_CODE_TAG_ID);
        basicStatus.setErrorMessage(CustomExceptions.ERROR_MESSAGE_TAG_ID);
    }

    public void setToUserIsNullError() {
        basicStatus.setErrorCode(CustomExceptions.ERROR_CODE_TO_USER);
        basicStatus.setErrorMessage(CustomExceptions.ERROR_MESSAGE_TO_USER);
    }

    public void setMessageTypeIsNullError() {
        basicStatus.setErrorCode(CustomExceptions.ERROR_CODE_MESSAGE_TYPE);
        basicStatus.setErrorMessage(CustomExceptions.ERROR_MESSAGE_MESSAGE_TYPE);
    }

    public void setContentIsNullError() {
        basicStatus.setErrorCode(CustomExceptions.ERROR_CODE_CONTENT);
        basicStatus.setErrorMessage(CustomExceptions.ERROR_MESSAGE_CONTENT);
    }

    public void setCardIdIsNullError() {
        basicStatus.setErrorCode(CustomExceptions.ERROR_CODE_CARD_ID);
        basicStatus.setErrorMessage(CustomExceptions.ERROR_MESSAGE_CARD_ID);
    }

    public void setMediaIdIsNullError() {
        basicStatus.setErrorCode(CustomExceptions.ERROR_CODE_MEDIA_ID);
        basicStatus.setErrorMessage(CustomExceptions.ERROR_MESSAGE_MEDIA_ID);
    }

    public BasicStatus getErrorFields() {
        return basicStatus;
    }

    @Override
    public String getMessage() {
        return basicStatus.toString();
    }
}