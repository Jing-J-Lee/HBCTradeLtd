package com.example.xps.hbctradeltd.c;

import com.example.xps.hbctradeltd.d.bean.JpushResp;
import com.example.xps.hbctradeltd.d.bean.LoginResp;
import com.example.xps.hbctradeltd.d.bean.ResetPassResp;
import com.example.xps.hbctradeltd.d.bean.UserList;
import com.example.xps.hbctradeltd.d.net.AwSchedulers;
import com.example.xps.hbctradeltd.d.net.RetrofitUtils;
import com.example.xps.hbctradeltd.d.net.UserApi;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by XPS on 2017/3/10.
 */

public class UserNetWork extends RetrofitUtils {
    private static UserApi userApi = RetrofitUtils.getUserapi();

    public static void doLogin(String mob_phone, String password, Subscriber<LoginResp> sub) {
        userApi.doLogin(mob_phone, password).compose(AwSchedulers.<LoginResp>applySchedulers()).subscribe(sub);
    }
    public static void doLogout(String uid, Subscriber<LoginResp> sub) {
        userApi.doLogout(uid).compose(AwSchedulers.<LoginResp>applySchedulers()).subscribe(sub);
    }
    public static void jpush(String uid, String regid, Subscriber<JpushResp> sub) {
        userApi.jpush(uid, regid).compose(AwSchedulers.<JpushResp>applySchedulers()).subscribe(sub);
    }
    public static void resePass(String uid, String oldPass, String newPass, Subscriber<ResetPassResp> sub) {
        userApi.resetPass(uid, oldPass,newPass).compose(AwSchedulers.<ResetPassResp>applySchedulers()).subscribe(sub);
    }
    public static void searchUserList(String uid, Subscriber<UserList> sub) {
        userApi.searchUserList(uid).compose(AwSchedulers.<UserList>applySchedulers()).subscribe(sub);
    }

}
