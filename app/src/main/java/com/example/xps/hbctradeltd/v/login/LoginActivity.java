package com.example.xps.hbctradeltd.v.login;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xps.hbctradeltd.R;
import com.example.xps.hbctradeltd.c.AppCommond;
import com.example.xps.hbctradeltd.c.UserNetWork;
import com.example.xps.hbctradeltd.d.bean.JpushResp;
import com.example.xps.hbctradeltd.d.bean.LoginResp;
import com.example.xps.hbctradeltd.v.BaseActivity;
import com.example.xps.hbctradeltd.v.main.MainActivity;
import com.example.xps.hbctradeltd.v.utils.SharedPreferencesUtil;
import com.example.xps.hbctradeltd.v.utils.ToastShow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;
import rx.Subscriber;

public class LoginActivity extends BaseActivity {

    private static final int LOGINSUCCESS=0;
    private static final int LOGINFAILD=1;

    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_pass)
    EditText etPass;
    @BindView(R.id.bt_login)
    Button btLogin;

//    Handler handler=new Handler(){
//
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            switch (msg.what) {
//                case LOGINSUCCESS:
//                    loadingDialog.dismiss();
//                    break;
//
//                case LOGINFAILD:
//                    loadingDialog.dismiss();
//                    break;
//
//            }
//        }
//    };

    @Override
    protected int getLayout() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        return R.layout.activity_login;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void init() {
        ButterKnife.bind(this);
    }

    @Override
    public void onReciveEvent(AppCommond a) {

    }

    @OnClick({R.id.et_phone, R.id.et_pass, R.id.bt_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                String phone = etPhone.getText().toString();
                String pass = etPass.getText().toString();
                if (!TextUtils.isEmpty(phone) && !TextUtils.isEmpty(pass)) {
                    if (phone.length() >= 11) {
                        dologin();
                    } else {
                        Toast.makeText(this, "手机号不合法", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "手机号或密码为空", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    void dologin() {
        loadingDialog.show();
        UserNetWork.doLogin(etPhone.getText().toString(), etPass.getText().toString(), new Subscriber<LoginResp>() {
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
//                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                e.printStackTrace();
            }

            @Override
            public void onNext(LoginResp loginResp) {
                Log.e("doLogin", loginResp.toString());
//                Log.e("jpush", JPushInterface.getRegistrationID(getApplicationContext()));
                if (loginResp.getReturn_code().equals("SUCCESS")){
                    SharedPreferencesUtil.setMsg("uid",loginResp.getReturn_body().getUid());
                    SharedPreferencesUtil.setMsg("userName",loginResp.getReturn_body().getTrue_name());
                    SharedPreferencesUtil.setMsg("nickName",loginResp.getReturn_body().getNickname());
                    SharedPreferencesUtil.setLogin(true);
                    loadingDialog.dismiss();
                    ToastShow.getInstance(LoginActivity.this).toastShow(loginResp.getReturn_msg());
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }else {
                    ToastShow.getInstance(LoginActivity.this).toastShow(loginResp.getReturn_msg());
                    loadingDialog.dismiss();
                }
            }
        });
    }
}
