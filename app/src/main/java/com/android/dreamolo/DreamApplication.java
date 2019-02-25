package com.android.dreamolo;

import android.app.Application;

public class DreamApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        if (BuildConfig.DEBUG) {
//            Timber.plant(new Timber.DebugTree());
//        } else {
//            Timber.plant(new NotLoggingTree());
//        }
    }
}
