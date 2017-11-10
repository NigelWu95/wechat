/**
 * Project Name: wechat
 * File Name: GroupMessageSendTypeEnum.java
 * Package Name: wechat: com.wechat.enums
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.enums;

/**
 * ClassName: GroupMessageSendTypeEnum Description: TODO Date Time: 2017年8月3日
 * 下午6:50:52
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public enum GroupMessageSendTypeEnum {

    /** Send group message by tag. */
    filter,
    /** Send group message by openid. */
    touser;
}