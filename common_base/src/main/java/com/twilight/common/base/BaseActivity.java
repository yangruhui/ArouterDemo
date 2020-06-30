package com.twilight.common.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.twilight.common.manage.ActivityManage;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
        initData();
        initView();
        setView();
        //加入Activity管理器
        ActivityManage.getInstance().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //将Activity从管理器移除
        ActivityManage.getInstance().removeActivity(this);
    }

    protected abstract int getLayoutId();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void setView();

}
