/**
 * Project Name: wechat
 * File Name: ConfigException.java
 * Package Name: wechat: com.wechat.exceptions
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.exceptions;

import com.wechat.beans.BasicStatus;
import com.wechat.constants.CustomExceptions;

/**
 * ClassName: ConfigException Description: TODO Date Time: 2017年8月6日 下午4:21:19
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class ConfigException extends Exception {

    private static final long serialVersionUID = 815972475343655939L;
    private BasicStatus basicStatus;

    public ConfigException() {
        basicStatus = new BasicStatus();
    }

    public void setAppIdIsNullError() {
        basicStatus.setErrorCode(CustomExceptions.ERROR_CODE_APPID_IS_NULL);
        basicStatus.setErrorMessage(CustomExceptions.ERROR_MESSAGE_APPID_IS_NULL);
    }

    public void setAppSecretIsNullError() {
        basicStatus.setErrorCode(CustomExceptions.ERROR_CODE_APPSECRET_IS_NULL);
        basicStatus.setErrorMessage(CustomExceptions.ERROR_MESSAGE_APPSECRET_IS_NULL);
    }

    public void setNoConfigFileError() {
        basicStatus.setErrorCode(CustomExceptions.ERROR_CODE_NO_CONFIG_FILE);
        basicStatus.setErrorMessage(CustomExceptions.ERROR_MESSAGE_NO_CONFIG_FILE);
    }

    public void setLoadConfigError(String message) {
        basicStatus.setErrorCode(CustomExceptions.ERROR_CODE_LOAD_CONFIG);
        basicStatus.setErrorMessage(CustomExceptions.ERROR_MESSAGE_LOAD_CONFIG + message);
    }

    public void setNoCustomServerError(String message) {
        basicStatus.setErrorCode(CustomExceptions.ERROR_CODE_NO_CUSTOM_SERVER);
        basicStatus.setErrorMessage(CustomExceptions.ERROR_MESSAGE_NO_CUSTOM_SERVER + message);
    }

    public BasicStatus getErrorFields() {
        return basicStatus;
    }

    @Override
    public String getMessage() {
        return basicStatus.toString();
    }
}