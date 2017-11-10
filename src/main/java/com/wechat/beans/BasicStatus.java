/**
 * Project Name: wechat
 * File Name: BasicStatus.java
 * Package Name: wechat: com.wechat.beans
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.beans;

/**
 * ClassName: BasicStatus Description: TODO Date Time: 2017年8月4日 下午2:25:40
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class BasicStatus {

    private int errorCode;
    private String errorMessage;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "[errorCode: " + errorCode + ", errorMessage: " + errorMessage + "]";
    }
}