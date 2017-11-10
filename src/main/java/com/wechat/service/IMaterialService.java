/**
 * Project Name: wechat
 * File Name: IMaterialService.java
 * Package Name: wechat: com.wechat.service
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.service;

import com.wechat.beans.material.UploadMaterialResult;
import com.wechat.exceptions.ConvertionException;
import com.wechat.exceptions.UploadException;

/**
 * ClassName: IMaterialService Description: TODO Date Time: 2017年8月8日 下午5:44:38
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public interface IMaterialService {

    UploadMaterialResult uploadTemporaryImageMaterial(String filePath) throws UploadException, ConvertionException;

    UploadMaterialResult uploadForeverImageMaterial(String filePath) throws UploadException, ConvertionException;
}