package com.zn.android.aniwallpaperdemo.ui.fragment.home;

import android.nfc.Tag;
import android.util.Log;

import com.zn.android.aniwallpaperdemo.api.ApiConfig;
import com.zn.android.aniwallpaperdemo.base.ServiceHelper;
import com.zn.android.aniwallpaperdemo.entity.ImageEntity;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import dagger.Provides;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * created by zn on 2018
 */
public class HomeFragmentPresenter implements HomeFragmentContract.Presenter{

    public static final String TAG = "HomeFragmentPresenter";
    private static final String MEIZI_URL = "http://gank.io/api/data/福利/50/1";

    private final HomeFragment mHomeFragment;
    private ServiceHelper mServiceHelper;

    @Inject
    public HomeFragmentPresenter(HomeFragment fragment,ServiceHelper serviceHelper) {
        this.mHomeFragment = fragment;
        this.mServiceHelper =serviceHelper;
    }


    //    public Observable<List<ImageEntity.ResultsBean>> getGankList() {
//        return observe(ServiceHelper.getImages(IMAGE_URL)).map(new Function<ImageEntity, List<ImageEntity.ResultsBean>>() {
//            @Override
//            public List<ImageEntity.ResultsBean> apply(ImageEntity imageEntity) throws Exception {
//                Log.d(TAG, "apply: imageEntity =="+imageEntity.getResults().toString());
//                return imageEntity.getResults();
//
//            }
//        });
//    }
    public void loadImage(){
        Map<String, String> params = new HashMap<>();
        mServiceHelper.get(MEIZI_URL, params, ImageEntity.class, new Observer<ImageEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

                Log.d(TAG, "onSubscribe");
            }

            @Override
            public void onNext(ImageEntity imageEntity) {
                Log.d(TAG, "onNext");
//                imageEntity.getResults();

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        }).subscribe();

    }






}
