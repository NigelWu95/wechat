/**
 * Project Name: wechat
 * File Name: MessageTypeEnum.java
 * Package Name: wechat: com.wechat.enums
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.enums;

/**
 * ClassName: MessageTypeEnum Description: TODO Date Time: 2017年8月3日 下午5:57:53
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public enum MessageTypeEnum {

    /** A text message only contains text. */
    text,
    /** A image message only contains one picture. */
    image,
    /** A voice message only contains one paragraph of voice. */
    voice,
    /** A video message only contains one video. */
    video,
    /** A music message only contains one piece of music. */
    music,
    /** A wxcard message only contains one card coupon. */
    wxcard,
    /** A mpnews message contains articles with text, picture, voice and so on. */
    mpnews;
}