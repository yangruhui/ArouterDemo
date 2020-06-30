package com.twilight.common.utils;

import android.text.TextUtils;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;
import com.twilight.common.base.bean.BaseBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 杨如辉 on 2020/6/30 10:35.
 * Activity跳转
 */
public class ActivityToActivity {

    /**
     * ARouter跳转Activity
     *
     * @param url    目标Activity Url
     * @param params 参数
     */
    public static void toActivity(String url, Map<String, ?> params) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        Postcard postcard = ARouter.getInstance()
                .build(url);
        if (params != null) {
            for (Map.Entry<String, ?> entry : params.entrySet()) {
                String key = entry.getKey();
                Object value = params.get(key);
                if (value instanceof String) {
                    postcard.withString(key, (String) value);
                } else if (value instanceof Boolean) {
                    postcard.withBoolean(key, (boolean) value);
                } else if (value instanceof Integer) {
                    postcard.withInt(key, (int) value);
                } else if (value instanceof Float) {
                    postcard.withFloat(key, (float) value);
                } else if (value instanceof Double) {
                    postcard.withDouble(key, (double) value);
                } else if (value instanceof Long) {
                    postcard.withLong(key, (long) value);
                } else if (value instanceof Short) {
                    postcard.withShort(key, (short) value);
                } else if (value instanceof BaseBean) {
                    postcard.withSerializable(key, (BaseBean) value);
                } else if (value instanceof ArrayList) {
                    postcard.withSerializable(key, (ArrayList) value);
                } else if (value instanceof HashMap) {
                    postcard.withSerializable(key, (HashMap) value);
                }
            }
        }
        postcard.navigation();
    }
}
