/**
 * Project Name: wechat
 * File Name: JSONConverter.java
 * Package Name: wechat: com.wechat.constants
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.constants;

import java.util.Hashtable;
import java.util.Map;

/**
 * ClassName: JSONConverter Description: TODO Date Time: 2017年8月7日 下午4:40:35
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class DataConverters {

    public static final Map<String, String> basicStatus = new Hashtable<String, String>() {

        private static final long serialVersionUID = 5769886253805392893L;
        {
            put("errorCode", "errcode");
            put("errorMessage", "errmsg");
        }
    };

    public static final Map<String, String> fans = new Hashtable<String, String>() {

        private static final long serialVersionUID = -5449995054887720980L;
        {
            putAll(basicStatus);
            put("total", "total");
            put("count", "count");
            put("data", "data");
            put("nextOpenId", "next_openid");
        }
    };

    public static final Map<String, String> subscriber = new Hashtable<String, String>() {

        private static final long serialVersionUID = 5769886253805392893L;
        {
            putAll(basicStatus);
            put("subscribe", "subscribe");
            put("openId", "openid");
            put("nickname", "nickname");
            put("sex", "sex");
            put("city", "city");
            put("country", "country");
            put("province", "province");
            put("language", "language");
            put("headImgUrl", "headimgurl");
            put("subscribeTime", "subscribe_time");
            put("unionId", "unionid");
            put("remark", "remark");
            put("groupId", "groupid");
            put("tagIdList", "tagid_list");
        }
    };

    public static final Map<String, String> groupMessageSendResult = new Hashtable<String, String>() {

        private static final long serialVersionUID = -4970013234568086214L;
        {
            putAll(basicStatus);
            put("type", "type");
            put("messageId", "msg_id");
            put("messageDataId", "msg_data_id");
            put("messageStatus", "msg_status");
        }
    };

    public static final Map<String, String> uploadMaterialResult = new Hashtable<String, String>() {

        private static final long serialVersionUID = 5467251264342624670L;
        {
            putAll(basicStatus);
            put("type", "type");
            put("mediaId", "media_id");
            put("createdAt", "created_at");
            put("url", "url");
        }
    };
}