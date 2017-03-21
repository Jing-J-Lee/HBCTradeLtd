package com.example.xps.hbctradeltd.d.net;

import com.example.xps.hbctradeltd.d.bean.LoginResp;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface UserApi {

    @FormUrlEncoded
    @POST("user/user_login")
    Observable<LoginResp> doLogin(@Field("mob_phone") String mob_phone, @Field("password") String password);

}
