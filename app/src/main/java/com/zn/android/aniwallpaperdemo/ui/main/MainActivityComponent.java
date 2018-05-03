package com.zn.android.aniwallpaperdemo.ui.main;

import com.zn.android.aniwallpaperdemo.di.ActivityScope;
import com.zn.android.aniwallpaperdemo.di.ApplicationComponent;

import dagger.Component;

@ActivityScope
@Component(modules = MainModle.class, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);
}
