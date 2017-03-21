package com.example.xps.hbctradeltd.d.bean;

/**
 * Created by XPS on 2017/3/10.
 */

abstract class BaseResp {
    String return_code = "";
    String return_msg = "";
    String return_body = "";

    @Override
    public String toString() {
        return "BaseResp{" +
                "return_code='" + return_code + '\'' +
                ", return_msg='" + return_msg + '\'' +
                ", return_body='" + return_body + '\'' +
                '}';
    }
}
