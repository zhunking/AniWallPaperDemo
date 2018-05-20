package com.zn.android.aniwallpaperdemo.ui.main;

import com.zn.android.aniwallpaperdemo.di.ActivityScope;
import com.zn.android.aniwallpaperdemo.ui.fragment.home.HomeAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModle {

    private MainContract.View view;

    public MainModle(MainContract.View view) {
        this.view = view;
    }


    @Provides
    @ActivityScope
    MainContract.View provideSelectCityContractView() {
        return view;
    }

//    @Provides
//    @ActivityScope
//    HomeAdapter providerAdapter(){
//        return new HomeAdapter(view.getMyContext());
//    }
}
