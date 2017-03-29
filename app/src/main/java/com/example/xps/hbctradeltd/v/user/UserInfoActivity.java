package com.example.xps.hbctradeltd.v.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xps.hbctradeltd.R;
import com.example.xps.hbctradeltd.c.AppCommond;
import com.example.xps.hbctradeltd.v.BaseActivity;
import com.example.xps.hbctradeltd.v.login.ResetPassActivity;
import com.example.xps.hbctradeltd.v.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by XPS on 2017/3/13.
 */

public class UserInfoActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phonenumber)
    TextView tvPhonenumber;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_resetpass)
    Button btResetpass;

    @Override
    protected int getLayout() {
        return R.layout.activity_userinfo;
    }

    @Override
    protected void setData() {
        tvName.setText("姓名:"+SharedPreferencesUtil.getMsg("userName"));
        tvPhonenumber.setText("手机号:"+SharedPreferencesUtil.getMsg("phone"));
        tvTitle.setText("职称:"+SharedPreferencesUtil.getMsg("nickName"));
    }

    @Override
    protected void init() {
        ButterKnife.bind(this);
    }

    @Override
    public void onReciveEvent(AppCommond a) {

    }

    @OnClick({R.id.iv_back, R.id.bt_resetpass})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.bt_resetpass:
                startActivity(new Intent(this, ResetPassActivity.class));
                break;
        }
    }
}
