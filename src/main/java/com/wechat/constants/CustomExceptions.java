/**
 * Project Name: wechat
 * File Name: CustomExceptions.java
 * Package Name: wechat: com.wechat.constants
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.constants;

/**
 * ClassName: CustomExceptions Description: TODO Date Time: 2017年8月8日 下午12:56:34
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class CustomExceptions {

    public static final int ERROR_CODE_GET_ACCESS_TOKEN = 10001;
    public static final String ERROR_MESSAGE_GET_ACCESS_TOKEN = "Fail to obtain access token.";

    public static final int ERROR_CODE_APPID_IS_NULL = 10002;
    public static final int ERROR_CODE_APPSECRET_IS_NULL = 10003;
    public static final int ERROR_CODE_NO_CONFIG_FILE = 10004;
    public static final int ERROR_CODE_LOAD_CONFIG = 10005;
    public static final int ERROR_CODE_NO_CUSTOM_SERVER = 10006;
    public static final String ERROR_MESSAGE_APPID_IS_NULL = "The wechat.appid in wechat.properties is necessary.";
    public static final String ERROR_MESSAGE_APPSECRET_IS_NULL = "The wechat.appsecret in wechat.properties is necessary.";
    public static final String ERROR_MESSAGE_NO_CONFIG_FILE = "The wechat.properties configuration file can not be found.";
    public static final String ERROR_MESSAGE_LOAD_CONFIG = "Load configuration from wechat4j.properties error. ";
    public static final String ERROR_MESSAGE_NO_CUSTOM_SERVER = "The system falied to get custom server instance"
            + " because it can not find the custom server class ";

    public static final int ERROR_CODE_SENDER = 10007;
    public static final int ERROR_CODE_SEND_TYPE = 10008;
    public static final int ERROR_CODE_TAG_ID = 10009;
    public static final int ERROR_CODE_IS_TO_ALL = 10010;
    public static final int ERROR_CODE_TO_USER = 10011;
    public static final int ERROR_CODE_MESSAGE_TYPE = 10012;
    public static final int ERROR_CODE_CONTENT = 10013;
    public static final int ERROR_CODE_CARD_ID = 10014;
    public static final int ERROR_CODE_MEDIA_ID = 10015;
    public static final String ERROR_MESSAGE_SENDER = "sender is null. It can not be null.";
    public static final String ERROR_MESSAGE_SEND_TYPE = "sendType is null. The send type of group message can not"
            + " be null, it must be set as filter(by group tag) or touser(by user openid).";
    public static final String ERROR_MESSAGE_TAG_ID = "tagId is null. The tag_id can not be null if you"
            + " choose to send this group message by group tag and set is_to_all as \"false\"";
    public static final String ERROR_MESSAGE_IS_TO_ALL = "isToAll is null. The is_to_all can not be null if you"
            + " choose to send this group message by group tag.";
    public static final String ERROR_MESSAGE_TO_USER = "toUser is null. The touser can not be null if you choose"
            + " to send this group message by user openid";
    public static final String ERROR_MESSAGE_MESSAGE_TYPE = "messageType is null. The message type of group message"
            + " can not be null.";
    public static final String ERROR_MESSAGE_CONTENT = "content is null. The text content can not be null if you"
            + " choose to send text message.";
    public static final String ERROR_MESSAGE_CARD_ID = "cardId is null. The card id can not be null if you"
            + " choose to send wxcard message.";
    public static final String ERROR_MESSAGE_MEDIA_ID = "mediaId is null. The media id can not be null if you"
            + " choose to send media message.";

    public static final int ERROR_CODE_SEND_HTTP_REQUEST = 10016;
    public static final String ERROR_MESSAGE_SEND_HTTP_REQUEST = "Can not send the request because some failure like http IO error occurred. ";

    public static final int ERROR_CODE_CONVERT_TO_OBJECT = 10017;
    public static final String ERROR_MESSAGE_CONVERT_TO_OBJECT = "Fail to convert this json to target object, error occurred. ";

    public static final int ERROR_CODE_UPLOAD_NO_FILE = 10018;
    public static final String ERROR_MESSAGE_UPLOAD_NO_FILE = "No such file exsits, please check file path.";
    public static final int ERROR_CODE_UPLOAD_IO = 10019;
    public static final String ERROR_MESSAGE_UPLOAD_IO = "Fail to upload.";
}