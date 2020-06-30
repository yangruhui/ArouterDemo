package com.twilight.module.main.view.main;

import android.view.View;

import androidx.lifecycle.ViewModelProviders;

import com.twilight.common.base.BaseActivity;
import com.twilight.common.constants.ARouterConfig;
import com.twilight.common.utils.ActivityToActivity;
import com.twilight.module.main.R;
import com.twilight.module.main.viewmodel.main.MainViewModel;

/**
 * Created by 杨如辉 on 2020/6/30 9:47.
 */
public class MainActivity extends BaseActivity {

    private MainViewModel viewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.main_activity_main;
    }

    @Override
    protected void initData() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setView() {

    }

    /**
     * 登录
     * @param view
     */
    public void onLogin(View view){
        ActivityToActivity.toActivity(ARouterConfig.USER_LOGIN,null);
    }
}
