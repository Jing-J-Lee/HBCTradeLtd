package com.example.xps.hbctradeltd.v.login;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
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
import com.example.xps.hbctradeltd.d.bean.LoginResp;
import com.example.xps.hbctradeltd.v.BaseActivity;
import com.example.xps.hbctradeltd.v.LauncherActivity;
import com.example.xps.hbctradeltd.v.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_pass)
    EditText etPass;
    @BindView(R.id.bt_login)
    Button btLogin;

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

                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                e.printStackTrace();
            }

            @Override
            public void onNext(LoginResp loginResp) {
                Log.e("doLogin", loginResp.toString());
            }
        });
    }
}
