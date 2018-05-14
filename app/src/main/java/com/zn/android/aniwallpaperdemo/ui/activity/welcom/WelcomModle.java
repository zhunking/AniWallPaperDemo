package com.zn.android.aniwallpaperdemo.ui.activity.welcom;

import com.zn.android.aniwallpaperdemo.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class WelcomModle {

    private WelcomContract.View view;

    public WelcomModle(WelcomContract.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    WelcomContract.View provideWelcomContractView() {
        return view;
    }
}
