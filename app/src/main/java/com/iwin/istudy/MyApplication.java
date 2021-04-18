package com.iwin.istudy;

import android.app.Application;

public class MyApplication extends Application {
    private static MyApplication appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
    }
    public static MyApplication getAppContext() {
        return appContext;
    }

}
