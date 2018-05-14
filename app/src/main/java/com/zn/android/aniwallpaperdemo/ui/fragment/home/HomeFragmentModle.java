package com.zn.android.aniwallpaperdemo.ui.fragment.home;

import com.zn.android.aniwallpaperdemo.di.ActivityScope;
import com.zn.android.aniwallpaperdemo.di.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * created by zn on 2018
 */

@Module
public class HomeFragmentModle {



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
