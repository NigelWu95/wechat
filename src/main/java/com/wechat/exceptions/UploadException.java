/**
 * Project Name: wechat
 * File Name: UploadException.java
 * Package Name: wechat: com.wechat.exceptions
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.exceptions;

import com.wechat.beans.BasicStatus;
import com.wechat.constants.CustomExceptions;

/**
 * ClassName: UploadException Description: TODO Date Time: 2017年8月8日 下午7:52:31
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class UploadException extends Exception {

    private static final long serialVersionUID = 3024682299938891663L;

    private BasicStatus basicStatus;

    public UploadException() {
        basicStatus = new BasicStatus();
    }

    public BasicStatus getErrorFields() {
        return basicStatus;
    }

    public void setNoSuchFileError() {
        basicStatus.setErrorCode(CustomExceptions.ERROR_CODE_UPLOAD_NO_FILE);
        basicStatus.setErrorMessage(CustomExceptions.ERROR_MESSAGE_UPLOAD_NO_FILE);
    }

    public void setUploadIOError() {
        basicStatus.setErrorCode(CustomExceptions.ERROR_CODE_UPLOAD_IO);
        basicStatus.setErrorMessage(CustomExceptions.ERROR_MESSAGE_UPLOAD_IO);
    }

    @Override
    public String getMessage() {
        return basicStatus.toString();
    }
}