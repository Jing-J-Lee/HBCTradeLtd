package com.example.xps.hbctradeltd.d.net;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class OkhttpUtils {
    private static OkHttpClient mOkHttpClient;

    public static OkHttpClient getOkHttpClient() {
        if (null == mOkHttpClient) {
            mOkHttpClient = new OkHttpClient.Builder()
                    //.cookieJar(cookieJar)
                    //.addInterceptor(new HeaderInterceptors())
                    //.addNetworkInterceptor(new CookiesInterceptor(MyApplication.getIns().getApplicationContext()))
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build();
        }
        return mOkHttpClient;
    }
}
