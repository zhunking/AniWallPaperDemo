package com.zn.android.aniwallpaperdemo.di;

import android.content.Context;

import com.zn.android.aniwallpaperdemo.WallpaperApplication;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {ApplicationModle.class})
public interface ApplicationComponent {

    WallpaperApplication getApplication();

    Context getContext();
}
