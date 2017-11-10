/**
 * Project Name: wechat
 * File Name: UploadMaterialResult.java
 * Package Name: wechat: com.wechat.beans.material
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.beans.material;

import com.wechat.beans.BasicStatus;
import com.wechat.exceptions.ConvertionException;
import com.wechat.util.JSONUtil;

import net.sf.json.JSONObject;

/**
 * ClassName: UploadMaterialResult Description: TODO Date Time: 2017年8月8日
 * 下午5:51:55
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class UploadMaterialResult extends BasicStatus {

    private String type; // 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图）
    private String mediaId; // 媒体文件上传后，获取标识
    private long createdAt; // 媒体文件上传时间戳
    private String url; // 上传图文消息内的图片获取URL

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "UploadMaterialResult [type=" + type + ", mediaId=" + mediaId + ", createdAt=" + createdAt + ", url="
                + url + "]";
    }

    public static UploadMaterialResult fromJson(JSONObject resultJson) throws ConvertionException {
        UploadMaterialResult uploadMaterialResult = new UploadMaterialResult();
        uploadMaterialResult = (UploadMaterialResult) JSONUtil.toObject(uploadMaterialResult, resultJson);

        return uploadMaterialResult;
    }
}