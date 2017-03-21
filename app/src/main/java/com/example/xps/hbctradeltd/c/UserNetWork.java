package com.example.xps.hbctradeltd.c;

import com.example.xps.hbctradeltd.d.bean.LoginResp;
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

}
