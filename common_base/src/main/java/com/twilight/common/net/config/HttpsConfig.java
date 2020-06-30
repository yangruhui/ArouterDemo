package com.twilight.common.net.config;

/**
 * Created by 杨如辉 on 2020/6/30 15:50.
 */
public class HttpsConfig {

    /**
     * 请求后台的所有API接口都在这里配置;统一管理
     */
    public static class Server {
        //服务器超时时间 16 秒
        public final static int TIME_OUT = 16;
        //测试服务器地址
        public static final String ROOT_URL = "https://payapi.fuxunpayuat.com/hibi-pos-adapter/rest/merchant/app/";

        //登录
        public static final String _4001 = "4001";
    }

    /**
     * 服务器返回的状态码
     */
    public static class RespCode {
        //处理成功
        public static final String R000 = "R000";
    }

    /**
     * sp 常量
     */
    public static class SP {

        public static final String SP = "https_sp";//sp
        public static final String SESSION_ID = "session_id";//
        public static final String AUTH = "Authorization";

    }

    /**
     * 全局常量
     */
    public static class FINALVALUE {
        public static final String AUTHORIZATION = "authorization"; //token
    }
}
