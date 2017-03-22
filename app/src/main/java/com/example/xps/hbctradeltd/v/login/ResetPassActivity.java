package com.example.xps.hbctradeltd.v.login;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.xps.hbctradeltd.R;
import com.example.xps.hbctradeltd.c.AppCommond;
import com.example.xps.hbctradeltd.c.UserNetWork;
import com.example.xps.hbctradeltd.d.bean.ResetPassResp;
import com.example.xps.hbctradeltd.v.BaseActivity;
import com.example.xps.hbctradeltd.v.utils.SharedPreferencesUtil;
import com.example.xps.hbctradeltd.v.utils.ToastShow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

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
                if (etOldpass.getText().length()<=0) {
                    ToastShow.getInstance(ResetPassActivity.this).toastShow("请填写原密码");
                }else if (etNewpass.getText().length()<=0){
                    ToastShow.getInstance(ResetPassActivity.this).toastShow("请填写新密码");
                }else {
                    resetPass();
                }
                break;
        }
    }

    void resetPass(){

        UserNetWork.resePass(SharedPreferencesUtil.getMsg("uid"), etOldpass.getText().toString(), etNewpass.getText().toString(), new Subscriber<ResetPassResp>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ResetPassResp resetPassResp) {
                Log.e("ss",resetPassResp.toString());
                if (resetPassResp.getReturn_code().equals("SUCCESS")){
                    ToastShow.getInstance(ResetPassActivity.this).toastShow("修改成功");
                    finish();
                }else {
                    ToastShow.getInstance(ResetPassActivity.this).toastShow("修改失败，请检查原密码");
                }
            }
        });
    }
}
