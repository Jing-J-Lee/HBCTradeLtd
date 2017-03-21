package com.example.xps.hbctradeltd.v;

import android.content.Intent;
import android.os.Handler;

import com.example.xps.hbctradeltd.R;
import com.example.xps.hbctradeltd.c.AppCommond;
import com.example.xps.hbctradeltd.v.login.LoginActivity;
import com.example.xps.hbctradeltd.v.main.MainActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by XPS on 2017/3/13.
 */

public class LauncherActivity extends BaseActivity {

    @Override
    protected int getLayout() {
        return 0;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void init() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(LauncherActivity.this, LoginActivity.class));
                overridePendingTransition(R.animator.alpha_in, R.animator.alpha_out);
                finish();
            }
        };
        timer.schedule(timerTask, 500);
    }

    @Override
    public void onReciveEvent(AppCommond a) {

    }
}
