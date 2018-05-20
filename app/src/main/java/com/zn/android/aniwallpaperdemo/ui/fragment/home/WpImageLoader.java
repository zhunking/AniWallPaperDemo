package com.zn.android.aniwallpaperdemo.ui.fragment.home;

import android.util.Log;

import com.zn.android.aniwallpaperdemo.entity.ImageEntity;
import com.zn.android.aniwallpaperdemo.http.RetrofitServiceManager;

import java.util.List;

import com.zn.android.aniwallpaperdemo.http.ObjectLoader;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * created by zn on 2018
 */
public class WpImageLoader extends ObjectLoader {

    private static final String IMAGE_URL = "http://gank.io/api/data/福利/50/1";
    private static final String TAG = "WpImageLoader";
    private ImageService mImageService;

    public WpImageLoader() {
        mImageService = RetrofitServiceManager.getInstance().create(ImageService.class);
    }


    /**
     * 获取干货列表
     *
     * @return
     */

    public Observable<List<ImageEntity.ResultsBean>> getGankList() {
        return observe(mImageService.getImage(IMAGE_URL)).map(new Function<ImageEntity, List<ImageEntity.ResultsBean>>() {
            @Override
            public List<ImageEntity.ResultsBean> apply(ImageEntity imageEntity) throws Exception {
                Log.d(TAG, "apply: imageEntity =="+imageEntity.getResults().toString());
                return imageEntity.getResults();

            }
        });
    }



    public interface ImageService {
        /**
         * @param url
         * @param
         * @param
         * @return
         */
        @GET
        Observable<ImageEntity> getImage(@Url String url/*, @Path("count")int count,@Path("page")int page*/);
    }
}
