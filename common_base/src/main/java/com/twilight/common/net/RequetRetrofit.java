package com.twilight.common.net;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.twilight.common.net.config.HttpsConfig;
import com.twilight.common.net.interceptor.AddCookiesInterceptor;
import com.twilight.common.net.interceptor.ReceivedCookiesInterceptor;
import com.twilight.common.utils.LogUtil;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 普通的网络请求用到的Retrofit
 */

public class RequetRetrofit {
    private static final String TAG = "RequetRetrofit";
     /**
     * 创建okhttp相关对象
     */
    private static OkHttpClient okHttpClient;
    /**
     * 创建Retrofit相关对象
     */
    private static Retrofit retrofit;

    public static <T> T getInstance(final Class<T> service) {
        if (okHttpClient == null) {
            synchronized (RequetRetrofit.class) {
                if(okHttpClient == null) {
                    /**
                     * 创建okhttp相关对象
                     */
                    okHttpClient = new OkHttpClient.Builder()
                            .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                                @Override
                                public void log(String message) {   //访问网络请求，和服务端响应请求时。将数据拦截并输出
                                    LogUtil.d(TAG, "log: " + message);
                                }
                            }).setLevel(HttpLoggingInterceptor.Level.BODY))     //Log等级
                            .connectTimeout(HttpsConfig.Server.TIME_OUT, TimeUnit.SECONDS) //超时时间
                            .readTimeout(HttpsConfig.Server.TIME_OUT, TimeUnit.SECONDS)
                            .writeTimeout(HttpsConfig.Server.TIME_OUT, TimeUnit.SECONDS)
                            .addNetworkInterceptor(new StethoInterceptor())
                            .addInterceptor(new AddCookiesInterceptor()) //
                            .addInterceptor(new ReceivedCookiesInterceptor())
                            .build();
                }
            }
        }

        if (retrofit == null) {
            synchronized (RequetRetrofit.class) {
                if(retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(HttpsConfig.Server.ROOT_URL)         //BaseUrl
                            .client(okHttpClient)                       //请求的网络框架
                            .addConverterFactory(GsonConverterFactory.create())     //解析数据格式
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 使用RxJava作为回调适配器
                            .build();
                }
            }
        }
        return retrofit.create(service);
    }



}
