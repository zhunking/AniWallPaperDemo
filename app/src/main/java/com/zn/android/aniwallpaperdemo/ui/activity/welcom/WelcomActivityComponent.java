package com.zn.android.aniwallpaperdemo.ui.activity.welcom;

import com.zn.android.aniwallpaperdemo.di.ActivityScope;
import com.zn.android.aniwallpaperdemo.di.ApplicationComponent;

import dagger.Component;

@ActivityScope
@Component(modules = WelcomModle.class ,dependencies = ApplicationComponent.class)
public interface WelcomActivityComponent {

    void inject(WelcomActivity welcomActivity);
}