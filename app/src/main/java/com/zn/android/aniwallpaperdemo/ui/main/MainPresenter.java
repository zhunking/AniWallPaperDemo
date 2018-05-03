package com.zn.android.aniwallpaperdemo.ui.main;


import android.content.Context;

import javax.inject.Inject;

import dagger.Provides;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mainView;
    private Context context;

    @Inject
    public MainPresenter(Context context, MainContract.View view) {
        this.context = context;
        this.mainView = view;
    }



}
