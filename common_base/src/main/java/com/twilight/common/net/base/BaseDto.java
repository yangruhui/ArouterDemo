package com.twilight.common.net.base;

import com.twilight.common.base.bean.BaseBean;

/**
 * Created by 杨如辉 on 2020/6/30 16:05.
 * 服务器返回公共实体
 */
public class BaseDto<T> extends BaseBean {
    private String statusCode;
    private String statusDesc;
    private T data;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
