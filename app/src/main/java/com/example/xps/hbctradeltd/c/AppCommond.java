package com.example.xps.hbctradeltd.c;


public class AppCommond {
    boolean closeActivity = false;
    String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public AppCommond(boolean closeActivity) {
        this.closeActivity = closeActivity;
    }

    public AppCommond() {
    }

    public boolean isCloseActivity() {
        return closeActivity;
    }

    public void setCloseActivity(boolean closeActivity) {
        this.closeActivity = closeActivity;
    }
}
