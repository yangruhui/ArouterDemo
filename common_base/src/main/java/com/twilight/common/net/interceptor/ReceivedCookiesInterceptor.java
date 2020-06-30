package com.twilight.common.net.interceptor;

import android.text.TextUtils;

import com.alibaba.fastjson.JSONObject;
import com.twilight.common.net.config.HttpsConfig;
import com.twilight.common.utils.SharedPreferencesUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by 杨如辉 on 2020/6/30 15:57.
 * 自定义拦截器刷新sessionId 首次请求的处理
 */
public class ReceivedCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            List<String> cookies = new ArrayList<>();
            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
            }
            String cookieStr = JSONObject.toJSONString(cookies);
            SharedPreferencesUtils.putData(HttpsConfig.SP.SP, HttpsConfig.SP.SESSION_ID, cookieStr);
        }

        //获取token
        if (!TextUtils.isEmpty(originalResponse.header(HttpsConfig.FINALVALUE.AUTHORIZATION))){
            String token = originalResponse.header(HttpsConfig.FINALVALUE.AUTHORIZATION);
            SharedPreferencesUtils.putData(HttpsConfig.SP.SP,HttpsConfig.SP.AUTH,token);
        }

        return originalResponse;
    }
}
