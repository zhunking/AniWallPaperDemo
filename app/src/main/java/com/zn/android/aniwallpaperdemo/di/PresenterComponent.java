package com.zn.android.aniwallpaperdemo.di;

import com.zn.android.aniwallpaperdemo.ui.activity.welcom.WelcomActivity;
import com.zn.android.aniwallpaperdemo.ui.activity.welcom.WelcomPresenter;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {ApplicationModle.class})
public interface PresenterComponent {

    void inject(WelcomPresenter presenter);

//    void inject(SelectCityPresenter presenter);
//
//    void inject(DrawerMenuPresenter presenter);
}

