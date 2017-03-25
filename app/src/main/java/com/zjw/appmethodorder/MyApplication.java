package com.zjw.appmethodorder;

import android.app.Application;
import android.content.Context;

/**
 * Created by 二精-霁雪清虹 on 2017/3/25.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
