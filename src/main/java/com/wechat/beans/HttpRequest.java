/**
 * Project Name: wechat
 * File Name: HttpRequest.java
 * Package Name: wechat: com.wechat.beans
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.beans;

import net.sf.json.JSONObject;

/**
 * ClassName: HttpRequest Description: TODO Date Time: 2017年8月4日 上午12:35:47
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class HttpRequest {

    private String method;
    private String url;
    private JSONObject requestBody;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JSONObject getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(JSONObject requestBody) {
        this.requestBody = requestBody;
    }
}