package com.zn.android.aniwallpaperdemo.ui.main;

import android.content.Context;

import com.zn.android.aniwallpaperdemo.base.BasePresenter;
import com.zn.android.aniwallpaperdemo.base.BaseView;

import javax.inject.Inject;

public interface MainContract {
    interface View extends BaseView {
        Context getMyContext();
    }

    interface Presenter extends BasePresenter {

    }
}
