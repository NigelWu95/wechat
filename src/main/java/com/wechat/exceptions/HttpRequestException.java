/**
 * Project Name: wechat
 * File Name: AccessTokenException.java
 * Package Name: wechat: com.wechat.exceptions
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.exceptions;

import com.wechat.beans.BasicStatus;
import com.wechat.constants.CustomExceptions;

/**
 * ClassName: AccessTokenException Description: TODO Date Time: 2017年8月6日
 * 下午2:38:28
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class HttpRequestException extends Exception {

    private static final long serialVersionUID = -473078490984034836L;

    private BasicStatus basicStatus;

    public HttpRequestException() {
        basicStatus = new BasicStatus();
    }

    public void setSendHttpRequestError(String message) {
        basicStatus.setErrorCode(CustomExceptions.ERROR_CODE_SEND_HTTP_REQUEST);
        basicStatus.setErrorMessage(CustomExceptions.ERROR_MESSAGE_SEND_HTTP_REQUEST + message);
    }

    public void setErrorFields(BasicStatus basicStatus) {
        this.basicStatus = basicStatus;
    }

    public BasicStatus getErrorFields() {
        return basicStatus;
    }

    @Override
    public String getMessage() {
        return basicStatus.toString();
    }
}