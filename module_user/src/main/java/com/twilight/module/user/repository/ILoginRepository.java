package com.twilight.module.user.repository;

import androidx.lifecycle.LiveData;

import com.twilight.common.net.base.BaseDto;
import com.twilight.common.net.model.dto.LoginDto;
import com.twilight.common.net.model.vo.LoginVo;

/**
 * Created by 杨如辉 on 2020/6/30 16:33.
 */
public interface ILoginRepository {

    /**
     * 登录
     * @param loginVo
     * @return
     */
    LiveData<BaseDto<LoginDto>> login(LoginVo loginVo);
}
