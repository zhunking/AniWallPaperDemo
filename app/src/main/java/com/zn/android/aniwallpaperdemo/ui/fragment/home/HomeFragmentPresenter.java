package com.zn.android.aniwallpaperdemo.ui.fragment.home;

import javax.inject.Inject;

import dagger.Provides;

/**
 * created by zn on 2018
 */
public class HomeFragmentPresenter implements HomeFragmentContract.Presenter{

    private final HomeFragment fragment;

    @Inject
    public HomeFragmentPresenter(HomeFragment fragment) {
        this.fragment = fragment;
    }
}
