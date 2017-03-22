package com.example.xps.hbctradeltd.v;

import android.app.Application;
import android.util.Log;

import com.example.xps.hbctradeltd.c.UserNetWork;
import com.example.xps.hbctradeltd.d.bean.JpushResp;
import com.example.xps.hbctradeltd.d.bean.LoginResp;
import com.example.xps.hbctradeltd.v.utils.SharedPreferencesUtil;
import com.jude.utils.JUtils;

import cn.jpush.android.api.JPushInterface;
import rx.Subscriber;


public class App extends Application {

    private static App INSTANCE;
    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE=this;
        JUtils.initialize(this);
        //注册极光
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        if (SharedPreferencesUtil.isLogin()) {
            jpush();//提交registrationID
//            Log.e("ss","isLogin"+SharedPreferencesUtil.isLogin());
        }
    }

    public static App getINSTANCE() {
        return INSTANCE;
    }


    void jpush(){
        UserNetWork.jpush(SharedPreferencesUtil.getMsg("uid"), JPushInterface.getRegistrationID(getApplicationContext()), new Subscriber<JpushResp>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(JpushResp jpushResp) {
//                Log.e("ss","jpush"+jpushResp.toString());
            }
        });
    }
}
