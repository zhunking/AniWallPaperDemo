package com.zn.android.aniwallpaperdemo.base;

import android.content.Context;

import com.google.gson.Gson;
import com.zn.android.aniwallpaperdemo.api.ApiConfig;
import com.zn.android.aniwallpaperdemo.api.ServiceApi;
import com.zn.android.aniwallpaperdemo.entity.ImageEntity;

import org.reactivestreams.Subscriber;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * created by zn on 2018
 */
public class ServiceHelper {
    private ServiceApi mServiceApi;
    private Context mContext;


    protected ServiceHelper(Context mContext, ServiceApi serviceApi) {
        this.mContext = mContext;
        this.mServiceApi = serviceApi;
    }

    public <T> Observable<T> get(final String url, Map<String, String> params, final Class<T> repClass, Observer<T> observer) {

        return mServiceApi.executeGet(url, getParam(params))
                .onErrorReturn(new Function<Throwable, ResponseBody>() {
                    @Override
                    public ResponseBody apply(Throwable throwable) throws Exception {

                        return null;
                    }
                }).map(new Function<ResponseBody, String>() {

                    @Override
                    public String apply(ResponseBody responseBody) throws Exception {
                        String jsonStr = "";
                        jsonStr = responseBody.string();
                        return jsonStr;
                    }
                }).map(new Function<String, T>() {
                    @Override
                    public T apply(String s) throws Exception {
                        return new Gson().fromJson(s, repClass);
                    }
                });


    }

    private Map<String,String> getParam(Map<String, String> p) {
        Map<String, String> params = new HashMap<>();
        String data = new Gson().toJson(p, HashMap.class);
        params.put("data", data);
        return params;
    }


}
