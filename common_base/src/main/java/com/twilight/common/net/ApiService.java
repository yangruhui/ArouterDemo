package com.twilight.common.net;

import com.twilight.common.net.base.BaseDto;
import com.twilight.common.net.config.HttpsConfig;
import com.twilight.common.net.model.dto.LoginDto;
import com.twilight.common.net.model.vo.LoginVo;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by 杨如辉 on 2020/6/30 16:26.
 * api接口
 * retrofit的注解学习https://blog.csdn.net/qiang_xi/article/details/53959437
 *
 */
public interface ApiService {

    /**
     * 登录
     * @param loginVo
     * @return
     */
    @POST(HttpsConfig.Server._4001)
    Flowable<BaseDto<LoginDto>> login(@Body LoginVo loginVo);
}
