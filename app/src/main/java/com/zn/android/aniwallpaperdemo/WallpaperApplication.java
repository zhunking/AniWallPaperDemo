package com.zn.android.aniwallpaperdemo;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.zn.android.aniwallpaperdemo.di.ApplicationComponent;
import com.zn.android.aniwallpaperdemo.di.ApplicationModle;
import com.zn.android.aniwallpaperdemo.di.DaggerApplicationComponent;

public class WallpaperApplication extends Application {

    private static final String TAG = "WallpaperApplication";

//    private static WallpaperApplication application;

    private ApplicationComponent applicationComponent;

    private static WallpaperApplication WallpaperApplicationInstance;

    public static WallpaperApplication getInstance() {

        return WallpaperApplicationInstance;
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "app onCreate");

        WallpaperApplicationInstance = this;

        applicationComponent= DaggerApplicationComponent.builder()
                .applicationModle(new ApplicationModle(this))
                .build();

    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }
}
