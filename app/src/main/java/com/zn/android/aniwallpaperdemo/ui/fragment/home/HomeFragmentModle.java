package com.zn.android.aniwallpaperdemo.ui.fragment.home;

import com.zn.android.aniwallpaperdemo.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * created by zn on 2018
 */

@Module
public class HomeFragmentModle {

    private static final String IMAGE_URL = "http://gank.io/api/data/福利/50/1";
    private static final String TAG = "WpImageLoader";


    private HomeFragmentContract.View view;


    public HomeFragmentModle(HomeFragmentContract.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    HomeFragmentContract.View provideHomeFragmentContractView() {
        return view;
    }





}
