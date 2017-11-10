/**
 * Project Name: wechat
 * File Name: HttpUtil.java
 * Package Name: wechat: com.wechat.util
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import com.wechat.beans.HttpRequest;
import com.wechat.central.X509TrustManagerImpl;
import com.wechat.constants.CommonKeywords;
import com.wechat.exceptions.HttpRequestException;
import com.wechat.exceptions.UploadException;

import net.sf.json.JSONObject;

/**
 * ClassName: HttpUtil Description: TODO Date Time: 2017年8月1日 下午7:18:43
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class HttpUtil {

    public static JSONObject sendRequest(HttpRequest httpRequest) throws HttpRequestException {
        HttpRequestException httpRequestException = new HttpRequestException();
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();

        try {
            // Create SSLContext object, and using appointed trust manager to init.
            TrustManager[] tm = { new X509TrustManagerImpl() };
            SSLContext sslContext = SSLContext.getInstance(CommonKeywords.PROTOCOL_SSL,
                    CommonKeywords.PROTOCOL_SSL_PROVIDER_SUN);
            sslContext.init(null, tm, new java.security.SecureRandom());
            // Get the SSLSocketFactory object from SSLContext object.
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(httpRequest.getUrl());
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            httpUrlConn.setRequestMethod(httpRequest.getMethod());
            httpUrlConn.connect();

            /*
             * When there are data to submit, it must get output stream.
             */
            if (null != httpRequest.getRequestBody()) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // Use "UTF-8" to avoid Chinese messy code.
                outputStream.write(httpRequest.getRequestBody().toString().getBytes(CommonKeywords.CODE_FORMAT_UTF_8));
                outputStream.close();
            }

            // Convert return input stream to string.
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, CommonKeywords.CODE_FORMAT_UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;

            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (Exception e) {
            httpRequestException.setSendHttpRequestError(e.getMessage());
            throw httpRequestException;
        }

        return jsonObject;
    }

    public static JSONObject uploadFile(HttpRequest httpRequest, String filePath) throws UploadException {
        UploadException uploadException = new UploadException();
        File file = new File(filePath);

        if (!file.exists() || !file.isFile()) {
            uploadException.setNoSuchFileError();
            throw uploadException;
        }

        BufferedReader reader = null;
        StringBuffer buffer = new StringBuffer();
        String result = null;

        try {
            URL urlObject = new URL(httpRequest.getUrl());
            HttpURLConnection urlConnection = (HttpURLConnection) urlObject.openConnection();
            urlConnection.setRequestMethod(httpRequest.getMethod());
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setUseCaches(false); // post方式不能使用缓存

            // 设置请求头信息
            urlConnection.setRequestProperty("Connection", "Keep-Alive");
            urlConnection.setRequestProperty("Charset", "UTF-8");
            // 设置边界
            String BOUNDARY = "---------------------------" + System.currentTimeMillis();
            urlConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

            // 请求正文信息
            // 第一部分：
            StringBuilder sb = new StringBuilder();
            sb.append("--"); // 必须多两道线
            sb.append(BOUNDARY);
            sb.append("\r\n");
            sb.append("Content-Disposition: form-data;name=\"media\";filename=\"" + file.getName() + "\"\r\n");
            sb.append("Content-Type:application/octet-stream\r\n\r\n");
            byte[] head = sb.toString().getBytes("utf-8");

            // 获得输出流
            OutputStream out = new DataOutputStream(urlConnection.getOutputStream());
            // 输出表头
            out.write(head);
            // 文件正文部分
            // 把文件已流文件的方式 推入到url中
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            int bytes = 0;
            byte[] bufferOut = new byte[1024];

            while ((bytes = in.read(bufferOut)) != -1) {
                out.write(bufferOut, 0, bytes);
            }

            in.close();
            // 结尾部分
            byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
            out.write(foot);

            out.flush();
            out.close();

            // 定义BufferedReader输入流来读取URL的响应
            reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = null;

            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            result = buffer.toString();

            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            uploadException.setNoSuchFileError();
            throw uploadException;
        }

        return result == null ? null : JSONObject.fromObject(result);
    }
}