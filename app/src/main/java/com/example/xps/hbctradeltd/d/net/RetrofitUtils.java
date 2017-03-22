package com.example.xps.hbctradeltd.d.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public abstract class RetrofitUtils {

    private static final String HOST = "http://192.168.0.200/v1";

    public static UserApi userapi = null;
    public static ContractApi contractApi=null;
    protected static OkHttpClient okHttpClient = OkhttpUtils.getOkHttpClient();

    protected static UserApi getUserapi() {
        if (null == userapi) {
            Retrofit mRetrofit = new Retrofit.Builder()
                    .baseUrl(HOST + "/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
            userapi = mRetrofit.create(UserApi.class);
        }
        return userapi;
    }
    protected static ContractApi getContractapi() {
        if (null == contractApi) {
            Retrofit mRetrofit = new Retrofit.Builder()
                    .baseUrl(HOST + "/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
            contractApi = mRetrofit.create(ContractApi.class);
        }
        return contractApi;
    }

}