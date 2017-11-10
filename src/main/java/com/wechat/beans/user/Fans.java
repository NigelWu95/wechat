/**
 * Project Name: wechat
 * File Name: UserListRequestResult.java
 * Package Name: wechat: com.wechat.beans.user
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.beans.user;

import com.wechat.beans.BasicStatus;
import com.wechat.exceptions.ConvertionException;
import com.wechat.util.JSONUtil;

import net.sf.json.JSONObject;

/**
 * ClassName: UserListRequestResult Description: TODO Date Time: 2017年8月4日
 * 上午9:59:40
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class Fans extends BasicStatus {

    private int total;
    private int count;
    private JSONObject data;
    private String nextOpenId;

    public int getTotal() {
        return total;
    }

    public int getCount() {
        return count;
    }

    public JSONObject getData() {
        return data;
    }

    public String getNextOpenId() {
        return nextOpenId;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    public void setNextOpenId(String nextOpenId) {
        this.nextOpenId = nextOpenId;
    }

    @Override
    public String toString() {
        return "Fans [total=" + total + ", count=" + count + ", data=" + data + ", nextOpenId=" + nextOpenId + "]";
    }

    public static Fans fromJson(JSONObject resultJson) throws ConvertionException {
        Fans fans = new Fans();
        fans = (Fans) JSONUtil.toObject(fans, resultJson);

        return fans;
    }
}