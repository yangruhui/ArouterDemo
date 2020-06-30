package com.twilight.module.user.repository.impl;

import androidx.lifecycle.LiveData;

import com.twilight.common.net.ApiService;
import com.twilight.common.net.RequetRetrofit;
import com.twilight.common.net.base.BaseDto;
import com.twilight.common.net.base.BaseRepository;
import com.twilight.common.net.model.dto.LoginDto;
import com.twilight.common.net.model.vo.LoginVo;
import com.twilight.module.user.repository.ILoginRepository;

/**
 * Created by 杨如辉 on 2020/6/30 16:34.
 */
public class LoginRepositoryImpl extends BaseRepository implements ILoginRepository {
    @Override
    public LiveData<BaseDto<LoginDto>> login(LoginVo loginVo) {
        return request(RequetRetrofit.getInstance(ApiService.class).login(loginVo)).get();
    }
}
