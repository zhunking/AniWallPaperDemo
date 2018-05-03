package com.zn.android.aniwallpaperdemo.ui.activity.welcom;

import android.content.Context;

import javax.inject.Inject;

public class WelcomPresenter implements WelcomContract.Presenter {

    private final Context context;
    private final WelcomContract.View welcomView;

    @Inject
    public WelcomPresenter(Context context, WelcomContract.View view) {
        this.context = context;
        this.welcomView = view;
    }
}
