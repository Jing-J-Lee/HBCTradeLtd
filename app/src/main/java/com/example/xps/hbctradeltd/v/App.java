package com.example.xps.hbctradeltd.v;

import android.app.Application;

import com.jude.utils.JUtils;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        JUtils.initialize(this);
    }
}
