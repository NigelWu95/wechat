/**
 * Project Name: wechat
 * File Name: JSONUtil.java
 * Package Name: wechat: com.wechat.util
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

import com.wechat.constants.Characters;
import com.wechat.constants.CommonKeywords;
import com.wechat.constants.DataConverters;
import com.wechat.exceptions.ConvertionException;

import net.sf.json.JSONObject;

/**
 * ClassName: JSONUtil Description: TODO Date Time: 2017年8月8日 上午11:17:03
 *
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class JSONUtil {

    @SuppressWarnings("unchecked")
    public static <T> Object toObject(T t, JSONObject sourceJson) throws ConvertionException {
        Class<?> targetClazz = t.getClass();
        String objectName = targetClazz.getName();
        String fieldName = objectName.substring(objectName.lastIndexOf(Characters.SYMBOL_CLASSIFIED_DOT) + 1,
                objectName.length());
        String ownFieldName = fieldName.substring(0, 1).toLowerCase() + fieldName.substring(1);
        Class<?> clazzParam = DataConverters.class;

        try {
            Field field = clazzParam.getDeclaredField(ownFieldName);
            Map<String, String> map = (Map<String, String>) field.get(clazzParam.newInstance());
            String setMthodName = null;
            Method setMthod = null;

            for (String key : map.keySet()) {
                if (null != sourceJson.get(map.get(key))) {
                    if (CommonKeywords.FIELD_ERROR_CODE.equals(key) || CommonKeywords.FIELD_ERROR_MESSAGE.equals(key)) {
                        field = targetClazz.getSuperclass().getDeclaredField(key);
                    } else {
                        field = targetClazz.getDeclaredField(key);
                    }

                    Class<?> clazz = field.getType();
                    setMthodName = CommonKeywords.SETTER_METHOD_PREFIX + field.getName().substring(0, 1).toUpperCase()
                            + field.getName().substring(1);

                    if (CommonKeywords.FIELD_ERROR_CODE.equals(key) || CommonKeywords.FIELD_ERROR_MESSAGE.equals(key)) {
                        setMthod = targetClazz.getSuperclass().getDeclaredMethod(setMthodName, clazz);
                    } else {
                        setMthod = targetClazz.getDeclaredMethod(setMthodName, clazz);
                    }

                    setMthod.invoke(t, sourceJson.get(map.get(key)));
                }
            }
        } catch (Exception e) {
            ConvertionException convertionException = new ConvertionException();
            convertionException.setConvertToObjectError(e.getMessage());
            throw convertionException;
        }

        return t;
    }
}