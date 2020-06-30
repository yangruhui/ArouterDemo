package com.twilight.common.net.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.twilight.common.net.config.HttpsConfig;
import com.twilight.common.utils.LogUtil;
import com.twilight.common.utils.SharedPreferencesUtils;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 杨如辉 on 2020/6/30 15:55.
 * 自定义拦截器刷新sessionId  非首次请求的处理
 */
public class AddCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        String cookieStr = SharedPreferencesUtils.getData(HttpsConfig.SP.SP, HttpsConfig.SP.SESSION_ID, String.class, null);
        List<String> cookies = JSONObject.parseArray(cookieStr, String.class);
        if (cookies != null) {
            for (String cookie : cookies) {
                builder.addHeader("Cookie", cookie);
                LogUtil.d("OkHttp", "Adding Header: " + cookie); // This is done so I know which headers are being added; this interceptor is used after the normal logging of OkHttp
            }
        }
        return chain.proceed(builder.build());
    }
}
