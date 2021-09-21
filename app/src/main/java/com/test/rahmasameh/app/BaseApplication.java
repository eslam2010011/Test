package com.test.rahmasameh.app;

import android.app.Application;
import android.content.Context;


import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }


}
