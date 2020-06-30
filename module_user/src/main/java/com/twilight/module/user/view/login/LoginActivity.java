package com.twilight.module.user.view.login;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.twilight.common.base.BaseActivity;
import com.twilight.common.constants.ARouterConfig;
import com.twilight.common.net.base.BaseDto;
import com.twilight.common.net.config.HttpsConfig;
import com.twilight.common.net.model.dto.LoginDto;
import com.twilight.common.net.model.vo.LoginVo;
import com.twilight.module.user.R;
import com.twilight.module.user.viewmodel.login.LoginViewModel;

/**
 * Created by 杨如辉 on 2020/6/30 9:47.
 */
@Route(path = ARouterConfig.USER_LOGIN)
public class LoginActivity extends BaseActivity {

    private LoginViewModel viewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.user_activity_login;
    }

    @Override
    protected void initData() {
        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setView() {
        login();
    }

    private void login(){
        LoginVo loginVo = new LoginVo();
        loginVo.setUserName("admin");
        loginVo.setPassWord("123456");
        viewModel.login(loginVo).observe(this, new Observer<BaseDto<LoginDto>>() {
            @Override
            public void onChanged(BaseDto<LoginDto> loginDtoBaseDto) {
                if(loginDtoBaseDto.getStatusCode().equals(HttpsConfig.RespCode.R000)){

                }else{

                }
            }
        });
    }
}
