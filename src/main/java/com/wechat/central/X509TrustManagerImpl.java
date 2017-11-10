/**
 * Project Name: wechat
 * File Name: X509TrustManagerImpl.java
 * Package Name: wechat: com.wechat.central
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.central;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * ClassName: X509TrustManagerImpl Description: TODO Date Time: 2017年8月1日
 * 下午7:37:05
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class X509TrustManagerImpl implements X509TrustManager {

    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}