/**
 * Project Name: wechat
 * File Name: RequestUtil.java
 * Package Name: wechat: com.wechat.util
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.util;

import com.wechat.beans.HttpRequest;
import com.wechat.constants.CommonKeywords;
import com.wechat.constants.WechatAPI;
import com.wechat.enums.LanguageTypeEnum;
import com.wechat.enums.MediaTypeEnum;

/**
 * ClassName: RequestUtil Description: TODO Date Time: 2017年8月2日 下午4:18:33
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class RequestUtil {

    private static final String URL_PARAMETER_LANG = "LANG";
    private static final String URL_PARAMETER_APPID = "APPID";
    private static final String URL_PARAMETER_APPSECRET = "APPSECRET";
    private static final String URL_PARAMETER_ACCESS_TOKEN = "ACCESS_TOKEN";
    private static final String URL_PARAMETER_OPENID = "OPENID";
    private static final String URL_PARAMETER_NEXT_OPENID = "NEXT_OPENID";
    private static final String URL_PARAMETER_TYPE = "TYPE";

    public static HttpRequest getAccessTokenRequest(String appId, String appSecret) {
        String url = WechatAPI.ACCESS_TOKEN_URL.replace(URL_PARAMETER_APPID, appId).replace(URL_PARAMETER_APPSECRET,
                appSecret);

        return getRequest(CommonKeywords.HTTP_METHOD_GET, url);
    }

    public static HttpRequest getSubscriberInfoRequest(String accessToken, String openId, LanguageTypeEnum lang) {
        String url = WechatAPI.SUBSCRIBER_INFO_URL.replace(URL_PARAMETER_ACCESS_TOKEN, accessToken)
                .replace(URL_PARAMETER_OPENID, openId);

        if (null != lang) {
            url = url.replace(URL_PARAMETER_LANG, lang.toString());
        } else {
            url = url.replace(URL_PARAMETER_LANG, LanguageTypeEnum.zh_CN.toString());
        }

        return getRequest(CommonKeywords.HTTP_METHOD_GET, url);
    }

    public static HttpRequest getSubscriberListRequest(String accessToken) {
        String url = WechatAPI.SUBSCRIBER_LIST_URL.replace(URL_PARAMETER_ACCESS_TOKEN, accessToken);

        return getRequest(CommonKeywords.HTTP_METHOD_POST, url);
    }

    public static HttpRequest getFansRequest(String accessToken, String nextOpenId) {
        String url = WechatAPI.FANS_URL.replace(URL_PARAMETER_ACCESS_TOKEN, accessToken)
                .replace(URL_PARAMETER_NEXT_OPENID, nextOpenId);

        return getRequest(CommonKeywords.HTTP_METHOD_GET, url);
    }

    public static HttpRequest getGroupMessageSendByTagRequest(String accessToken) {
        String url = WechatAPI.GROUP_MESSAGE_SEND_BY_TAG_URL.replace(URL_PARAMETER_ACCESS_TOKEN, accessToken);

        return getRequest(CommonKeywords.HTTP_METHOD_POST, url);
    }

    public static HttpRequest getGroupMessageSendByOpenIdRequest(String accessToken) {
        String url = WechatAPI.GROUP_MESSAGE_SEND_BY_OPENID_URL.replace(URL_PARAMETER_ACCESS_TOKEN, accessToken);

        return getRequest(CommonKeywords.HTTP_METHOD_POST, url);
    }

    public static HttpRequest getGroupMessageDeleteRequest(String accessToken) {
        String url = WechatAPI.GROUP_MESSAGE_DELETE_URL.replace(URL_PARAMETER_ACCESS_TOKEN, accessToken);

        return getRequest(CommonKeywords.HTTP_METHOD_POST, url);
    }

    public static HttpRequest getGroupMessagePreviewRequest(String accessToken) {
        String url = WechatAPI.GROUP_MESSAGE_PREVIEW_URL.replace(URL_PARAMETER_ACCESS_TOKEN, accessToken);

        return getRequest(CommonKeywords.HTTP_METHOD_POST, url);
    }

    public static HttpRequest getGroupMessageStatusQueryRequest(String accessToken) {
        String url = WechatAPI.GROUP_MESSAGE_STATUS_QUERY_URL.replace(URL_PARAMETER_ACCESS_TOKEN, accessToken);

        return getRequest(CommonKeywords.HTTP_METHOD_POST, url);
    }

    public static HttpRequest getUploadTemporaryMaterialReuqest(String accessToken, MediaTypeEnum mediaType) {
        String url = WechatAPI.UPLOAD_TEMPORARY_MATERIAL_URL.replace(URL_PARAMETER_ACCESS_TOKEN, accessToken)
                .replace(URL_PARAMETER_TYPE, mediaType.toString());

        return getRequest(CommonKeywords.HTTP_METHOD_POST, url);
    }

    public static HttpRequest getUploadForeverMaterialReuqest(String accessToken, MediaTypeEnum mediaType) {
        String url = WechatAPI.UPLOAD_FOREVER_MATERIAL_URL.replace(URL_PARAMETER_ACCESS_TOKEN, accessToken)
                .replace(URL_PARAMETER_TYPE, mediaType.toString());

        return getRequest(CommonKeywords.HTTP_METHOD_POST, url);
    }

    private static HttpRequest getRequest(String method, String url) {
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.setMethod(method);
        httpRequest.setUrl(url);

        return httpRequest;
    }
}