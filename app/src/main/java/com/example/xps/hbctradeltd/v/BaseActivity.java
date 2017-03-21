package com.example.xps.hbctradeltd.v;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;

import com.example.xps.hbctradeltd.R;
import com.example.xps.hbctradeltd.c.AppCommond;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class BaseActivity extends CheckPermissionsActivity {

    protected AlertDialog loadingDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        int layout = getLayout();
        if (layout != 0)
            setContentView(layout);
        init();
        View view = getLayoutInflater().inflate(R.layout.dialog_progress, null);
        AlertDialog.Builder ABuilder = new AlertDialog.Builder(BaseActivity.this, R.style.MyDialog);
        loadingDialog = ABuilder.setView(view).setCancelable(false).create();
        loadingDialog.setCancelable(true);
        setData();
    }

    public void showDialogCancelable() {
        if (loadingDialog != null) {
            loadingDialog.setCancelable(true);
            loadingDialog.show();
        }
    }

    public void showDialog() {
        if (loadingDialog != null) {
            loadingDialog.setCancelable(false);
            loadingDialog.show();
        }
    }

    public void cancelDialog() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
    }

    protected abstract int getLayout();

    protected abstract void setData();

    protected abstract void init();

    @Subscribe(threadMode = ThreadMode.MAIN)
    public abstract void onReciveEvent(AppCommond a);
}
