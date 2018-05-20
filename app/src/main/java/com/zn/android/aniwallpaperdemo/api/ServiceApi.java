package com.zn.android.aniwallpaperdemo.api;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * created by zn on 2018
 */
public interface ServiceApi {
    @GET("{url}")
    Observable<ResponseBody> executeGet(
            @Path(value = "url", encoded = true) String url,
            @QueryMap Map<String, String> maps);
    @GET("{url}")
    Observable<ResponseBody> get(
            @Path(value = "url", encoded = true) String url,
            @QueryMap Map<String, String> maps);
}
