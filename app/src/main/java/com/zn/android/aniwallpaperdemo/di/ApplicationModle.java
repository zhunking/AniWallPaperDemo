package com.zn.android.aniwallpaperdemo.di;


import android.content.Context;

import com.zn.android.aniwallpaperdemo.WallpaperApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class ApplicationModle {

    private final WallpaperApplication mContext;

    public ApplicationModle(WallpaperApplication context) {
        mContext = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mContext.getApplicationContext();
    }

    @Provides
    @Singleton
    WallpaperApplication provideApplication() {

        return (WallpaperApplication) mContext.getApplicationContext();
    }

}
