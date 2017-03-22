package com.example.xps.hbctradeltd.d.net;

import com.example.xps.hbctradeltd.d.bean.JpushResp;
import com.example.xps.hbctradeltd.d.bean.LoginResp;
import com.example.xps.hbctradeltd.d.bean.ResetPassResp;
import com.example.xps.hbctradeltd.d.bean.UserList;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface UserApi {

    @FormUrlEncoded
    @POST("user/user_login")//登录
    Observable<LoginResp> doLogin(@Field("mob_phone") String mob_phone, @Field("password") String password);

    @FormUrlEncoded
    @POST("user/user_logout")//退出登录
    Observable<LoginResp> doLogout(@Field("uid") String uid);
    @FormUrlEncoded
    @POST("user/query_send")//查询用户列表
    Observable<UserList> searchUserList(@Field("uid") String uid);

    @FormUrlEncoded
    @POST("user/create_reg")//提交极光ID
    Observable<JpushResp> jpush(@Field("uid") String uid, @Field("reg_id") String regId);

    @FormUrlEncoded
    @POST("user/reset_pwd")//修改密码
    Observable<ResetPassResp> resetPass(@Field("uid") String uid, @Field("old_pwd") String oldPwd,@Field("new_pwd") String newPwd);

}
