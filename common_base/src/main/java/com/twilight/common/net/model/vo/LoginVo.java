package com.twilight.common.net.model.vo;

import com.twilight.common.base.bean.BaseBean;

/**
 * Created by 杨如辉 on 2020/6/30 16:29.
 */
public class LoginVo extends BaseBean {
    private String userName; //用户名
    private String passWord; //密码

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
