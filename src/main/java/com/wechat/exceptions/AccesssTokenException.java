/**
 * Project Name: wechat
 * File Name: AccesssTokenException.java
 * Package Name: wechat: com.wechat.exceptions
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.exceptions;

import com.wechat.beans.BasicStatus;
import com.wechat.constants.CustomExceptions;

/**
 * ClassName: AccesssTokenException Description: TODO Date Time: 2017年8月6日
 * 下午3:35:22
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class AccesssTokenException extends Exception {

    private static final long serialVersionUID = 9156444766165416525L;

    private BasicStatus basicStatus;

    public AccesssTokenException() {
        basicStatus = new BasicStatus();
    }

    public void setGetAccessTokenError() {
        basicStatus.setErrorCode(CustomExceptions.ERROR_CODE_GET_ACCESS_TOKEN);
        basicStatus.setErrorMessage(CustomExceptions.ERROR_MESSAGE_GET_ACCESS_TOKEN);
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