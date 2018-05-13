package com.zn.android.aniwallpaperdemo.http;

/**
 *
 *
 * Created by zn on
 */

public class BaseResponse<T> {
    public int status;
    public String message;

    public T data;

    public boolean isSuccess(){
        return status == 200;
    }
}
