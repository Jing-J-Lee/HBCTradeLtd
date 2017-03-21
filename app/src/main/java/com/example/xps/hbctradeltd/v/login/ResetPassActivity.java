package com.example.xps.hbctradeltd.v.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.xps.hbctradeltd.R;
import com.example.xps.hbctradeltd.c.AppCommond;
import com.example.xps.hbctradeltd.v.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by XPS on 2017/3/13.
 */

public class ResetPassActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.et_oldpass)
    EditText etOldpass;
    @BindView(R.id.et_newpass)
    EditText etNewpass;
    @BindView(R.id.bt_conmmit)
    Button btConmmit;

    @Override
    protected int getLayout() {
        return R.layout.resetpass;
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

    @OnClick({R.id.iv_back, R.id.bt_conmmit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.bt_conmmit:

                break;
        }
    }
}
