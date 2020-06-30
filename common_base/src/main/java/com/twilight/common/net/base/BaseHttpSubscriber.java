package com.twilight.common.net.base;

import androidx.lifecycle.MutableLiveData;

import com.twilight.common.net.config.HttpsConfig;
import com.twilight.common.net.exception.ApiException;
import com.twilight.common.net.exception.ExceptionEngine;
import com.twilight.common.net.exception.ServerException;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by 杨如辉 on 2020/6/30 16:09.
 * 自定义请服务器被观察者
 */
public class BaseHttpSubscriber<T> implements Subscriber<BaseDto<T>> {

    //异常类
    private ApiException ex;

    public BaseHttpSubscriber() {
        data = new MutableLiveData();
    }

    private MutableLiveData<BaseDto<T>> data;

    public MutableLiveData<BaseDto<T>> get() {
        return data;
    }

    public void set(BaseDto<T> t) {
        this.data.setValue(t);
    }

    public void onFinish(BaseDto<T> t) {
        set(t);
    }

    @Override
    public void onSubscribe(Subscription s) {
        // 观察者接收事件 = 1个
        s.request(1);
    }

    @Override
    public void onNext(BaseDto<T> t) {
        if (t.getStatusCode().equals(HttpsConfig.RespCode.R000)) {
            onFinish(t);
        } else{
            ex = ExceptionEngine.handleException(new ServerException(t.getStatusCode(), t.getStatusDesc()));
            getErrorDto(ex);
        }
    }

    @Override
    public void onError(Throwable t) {
        ex = ExceptionEngine.handleException(t);
        getErrorDto(ex);
    }

    @Override
    public void onComplete() {

    }

    /**
     * 初始化错误的dto
     *
     * @param ex
     */
    private void getErrorDto(ApiException ex) {
        BaseDto dto = new BaseDto();
        dto.setStatusCode(ex.getStatusCode());
        dto.setStatusDesc(ex.getStatusDesc());
        onFinish((BaseDto<T>) dto);
    }
}
