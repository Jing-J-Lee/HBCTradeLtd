package com.example.xps.hbctradeltd.d.bean;


public class ContactUserBean {
    String userId = "";
    boolean isChecked = false;

    public ContactUserBean(String userId, boolean isChecked) {
        this.userId = userId;
        this.isChecked = isChecked;
    }

    public ContactUserBean() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

}
