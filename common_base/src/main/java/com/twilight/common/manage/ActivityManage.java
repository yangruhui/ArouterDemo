package com.twilight.common.manage;

import android.app.Activity;

import java.util.HashSet;
import java.util.Set;

/**
 * Describe：管理所有的Activity
 * Created by 杨如辉 on 2020/06/28s.
 */

public class ActivityManage {

    private static ActivityManage instance = null;
    private ActivityManage(){}
    public static ActivityManage getInstance(){
        if(null==instance){
            synchronized (ActivityManage.class){
                if(null==instance) instance = new ActivityManage();
            }
        }
        return instance;
    }

    //保存所有创建的Activity
    private Set<Activity> allActivities = new HashSet<>();

    /**
     * 添加Activity到管理器
     *
     * @param activity activity
     */
    public void addActivity(Activity activity) {
        if (activity != null) {
            allActivities.add(activity);
        }
    }


    /**
     * 从管理器移除Activity
     *
     * @param activity activity
     */
    public void removeActivity(Activity activity) {
        if (activity != null) {
            allActivities.remove(activity);
        }
    }

    /**
     * 关闭所有Activity
     */
    public void finishAll() {
        for (Activity activity : allActivities) {
            activity.finish();
        }

    }

}
