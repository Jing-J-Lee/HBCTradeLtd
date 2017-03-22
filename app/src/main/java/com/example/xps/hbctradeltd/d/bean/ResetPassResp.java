package com.example.xps.hbctradeltd.d.bean;

/**
 * Created by Administrator on 2017/3/21.
 */

public class ResetPassResp {

    @Override
    public String toString() {
        return "ResetPassResp{" +
                "return_code='" + return_code + '\'' +
                ", return_msg='" + return_msg + '\'' +
                ", return_body=" + return_body +
                '}';
    }

    /**
     * return_code : SUCCESS
     * return_msg : 更改成功
     * return_body : null
     */

    private String return_code;
    private String return_msg;
    private Object return_body;

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public Object getReturn_body() {
        return return_body;
    }

    public void setReturn_body(Object return_body) {
        this.return_body = return_body;
    }
}
