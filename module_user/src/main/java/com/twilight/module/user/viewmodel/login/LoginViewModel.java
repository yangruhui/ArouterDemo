package com.twilight.module.user.viewmodel.login;

import androidx.lifecycle.LiveData;

import com.twilight.common.base.viewmodel.BaseViewModel;
import com.twilight.common.net.base.BaseDto;
import com.twilight.common.net.model.dto.LoginDto;
import com.twilight.common.net.model.vo.LoginVo;
import com.twilight.module.user.repository.ILoginRepository;
import com.twilight.module.user.repository.impl.LoginRepositoryImpl;

/**
 * Created by 杨如辉 on 2020/6/30 9:54.
 */
public class LoginViewModel extends BaseViewModel {

    public LiveData<BaseDto<LoginDto>> login(LoginVo loginVo) {
        ILoginRepository loginRepository = new LoginRepositoryImpl();
        return loginRepository.login(loginVo);
    }
}
