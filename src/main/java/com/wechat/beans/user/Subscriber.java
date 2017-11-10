/**
 * Project Name: wechat
 * File Name: Subscriber.java
 * Package Name: wechat: com.wechat.beans.user
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.beans.user;

import java.util.List;

import com.wechat.beans.BasicStatus;
import com.wechat.exceptions.ConvertionException;
import com.wechat.util.JSONUtil;

import net.sf.json.JSONObject;

/**
 * ClassName: Subscriber Description: TODO Date Time: 2017年8月7日 下午3:41:21
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see    /**
     * 用户是否订阅该公众号标识 值为0时，代表此用户没有关注该公众号，拉取不到其余信息
    /**
     * 用户的标识，对当前公众号唯一
    /**
     * 用户的昵称
    /**
     * 用户的性别， 值为1时是男性， 值为2时是女性， 值为0时是未知
    /**
     * 用户所在城市
    /**
     * 用户所在国家
    /**
     * 用户所在省份
    /**
     * 用户的语言
    /**
     * 用户头像， 最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像）， 用户没有头像时该项为空。
     * 若用户更换头像，原有头像URL将失效。
    /**
     * 用户关注时间，为时间戳。 如果用户曾多次关注，则取最后关注时间
    /**
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。 详见：获取用户个人信息（UnionID机制）
    /**
     * 公众号运营者对粉丝的备注， 公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
    /**
     * 用户所在的分组ID
 */
public class Subscriber extends BasicStatus {

    private int subscribe;// 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
    private String openId;// 用户的标识，对当前公众号唯一
    private String nickname;// 用户的昵称
    private int sex;// 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
    private String city;// 用户所在城市
    private String country;// 用户所在国家
    private String province;// 用户所在省份
    private String language;// 用户的语言，简体中文为zh_CN
    private String headImgUrl;// 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
    private long subscribeTime;// 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
    private String unionId;// 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。详见：获取用户个人信息（UnionID机制）
    private String remark;// 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
    private int groupId;// 用户所在的分组ID
    private List<String> tagIdList;

     */
    public int getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(int subscribe) {
        this.subscribe = subscribe;
    }

     */
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

     */
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

     */
    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

     */
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

     */
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

     */
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

     */
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

     */
    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

     */

    public long getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(long subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

     */
    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

     */
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

     */
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public List<String> getTagIdList() {
        return tagIdList;
    }

    public void setTagIdList(List<String> tagIdList) {
        this.tagIdList = tagIdList;
    }

    @Override
    public String toString() {
        return "Subscriber [subscribe=" + subscribe + ", openId=" + openId + ", nickName=" + nickname + ", sex=" + sex
                + ", city=" + city + ", country=" + country + ", province=" + province + ", language=" + language
                + ", headimgUrl=" + headImgUrl + ", subscribeTime=" + subscribeTime + ", unionId=" + unionId
                + ", remark=" + remark + ", groupId=" + groupId + ", tagIdList=" + tagIdList + "]";
    }

    public static Subscriber fromJson(JSONObject resultJson) throws ConvertionException {
        Subscriber subscriber = new Subscriber();
        subscriber = (Subscriber) JSONUtil.toObject(subscriber, resultJson);

        return subscriber;
    }
}