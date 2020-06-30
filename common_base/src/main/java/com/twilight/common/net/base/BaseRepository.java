package com.twilight.common.net.base;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 杨如辉 on 2020/6/30 16:07.
 * Repository基类
 */
public class BaseRepository {

    /**
     * 请求网络
     * @param flowable
     * @param <T>
     * @return
     */
    public <T> BaseHttpSubscriber<T> request(Flowable<BaseDto<T>> flowable){
        BaseHttpSubscriber<T> baseHttpSubscriber = new BaseHttpSubscriber<>(); //RxJava Subscriber回调
        flowable.subscribeOn(Schedulers.io()) //解决背压
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(baseHttpSubscriber);
        return baseHttpSubscriber;
    }
}
