/**
 * Project Name: wechat
 * File Name: IMaterialServiceImpl.java
 * Package Name: wechat: com.wechat.service.impl
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.service.impl;

import com.wechat.beans.HttpRequest;
import com.wechat.beans.material.UploadMaterialResult;
import com.wechat.central.AccessTokenProxy;
import com.wechat.enums.MediaTypeEnum;
import com.wechat.exceptions.AccesssTokenException;
import com.wechat.exceptions.ConfigException;
import com.wechat.exceptions.ConvertionException;
import com.wechat.exceptions.HttpRequestException;
import com.wechat.exceptions.UploadException;
import com.wechat.service.IMaterialService;
import com.wechat.util.HttpUtil;
import com.wechat.util.RequestUtil;

import net.sf.json.JSONObject;

/**
 * ClassName: IMaterialServiceImpl Description: TODO Date Time: 2017年8月8日
 * 下午5:44:24
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class IMaterialServiceImpl implements IMaterialService {

    private String accessToken;

    public IMaterialServiceImpl() throws AccesssTokenException, ConfigException, HttpRequestException {
        AccessTokenProxy accessTokenProxy = new AccessTokenProxy();
        accessToken = accessTokenProxy.getAccessToken();
    }

    public UploadMaterialResult uploadTemporaryImageMaterial(String filePath)
            throws UploadException, ConvertionException {
        UploadMaterialResult uploadMaterialResult = null;
        HttpRequest httpRequest = RequestUtil.getUploadTemporaryMaterialReuqest(accessToken, MediaTypeEnum.image);
        JSONObject resultJson = HttpUtil.uploadFile(httpRequest, filePath);
        uploadMaterialResult = UploadMaterialResult.fromJson(resultJson);

        return uploadMaterialResult;
    }

    public UploadMaterialResult uploadForeverImageMaterial(String filePath)
            throws UploadException, ConvertionException {
        UploadMaterialResult uploadMaterialResult = null;
        HttpRequest httpRequest = RequestUtil.getUploadForeverMaterialReuqest(accessToken, MediaTypeEnum.image);
        JSONObject resultJson = HttpUtil.uploadFile(httpRequest, filePath);
        uploadMaterialResult = UploadMaterialResult.fromJson(resultJson);

        return uploadMaterialResult;
    }
}