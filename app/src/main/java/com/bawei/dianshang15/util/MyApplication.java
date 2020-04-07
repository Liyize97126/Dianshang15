package com.bawei.dianshang15.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

/**
 * 全局Context和SharedPreferences对象
 * 友盟统计：配置集成
 */
public class MyApplication extends Application {
    private static Context context;
    private static SharedPreferences sharedPreferences;
    public static Context getContext() {
        return context;
    }
    public static SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
        //友盟统计：初始化及通用接口
        UMConfigure.init(context, "5e8be1b2978eea071c37c3bd", "bawei_phone_market", UMConfigure.DEVICE_TYPE_PHONE, null);
        //查看日志
        UMConfigure.setLogEnabled(true);
        // 选用AUTO页面采集模式
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);
    }
}
