/**
 * Project Name: wechat
 * File Name: MediaTypeEnum.java
 * Package Name: wechat: com.wechat.enums
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.enums;

/**
 * ClassName: MediaTypeEnum Description: TODO Date Time: 2017年8月8日 下午6:18:15
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public enum MediaTypeEnum {

    /** 图片（image）: 2M，支持bmp/png/jpeg/jpg/gif格式 */
    image,
    /** 语音（voice）：2M，播放长度不超过60s，mp3/wma/wav/amr格式 */
    voice,
    /** 视频（video）：10MB，支持MP4格式 */
    video,
    /** 缩略图（thumb）：64KB，支持JPG格式 */
    thumb;
}