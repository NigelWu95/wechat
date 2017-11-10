/**
 * Project Name: wechat
 * File Name: ConvertionException.java
 * Package Name: wechat: com.wechat.exceptions
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.exceptions;

import com.wechat.beans.BasicStatus;
import com.wechat.constants.CustomExceptions;

/**
 * ClassName: ConvertionException Description: TODO Date Time: 2017年8月8日
 * 下午12:55:21
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class ConvertionException extends Exception {

    private static final long serialVersionUID = -1459816683072103047L;

    private BasicStatus basicStatus;

    public ConvertionException() {
        basicStatus = new BasicStatus();
    }

    public void setConvertToObjectError(String message) {
        basicStatus.setErrorCode(CustomExceptions.ERROR_CODE_CONVERT_TO_OBJECT);
        basicStatus.setErrorMessage(CustomExceptions.ERROR_MESSAGE_CONVERT_TO_OBJECT + message);
    }

    public BasicStatus getErrorFields() {
        return basicStatus;
    }

    @Override
    public String getMessage() {
        return basicStatus.toString();
    }
}