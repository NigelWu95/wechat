/**
 * Project Name: wechat
 * File Name: PageUtil.java
 * Package Name: wechat: com.wechat.util
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.util;

import com.wechat.beans.Page;

/**
 * ClassName: PageUtil Description: TODO Date Time: 2017年8月8日 下午4:30:21
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class PageUtil {

    public static int getQueryTimes(Page page) {
        int times = (page.getItemsTotal() - 1) / page.getPageSize() + 1;
        return times;
    }
}