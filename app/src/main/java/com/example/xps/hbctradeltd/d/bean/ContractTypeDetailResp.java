package com.example.xps.hbctradeltd.d.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/22.
 */

public class ContractTypeDetailResp {

    @Override
    public String toString() {
        return "ContractTypeDetailResp{" +
                "return_code='" + return_code + '\'' +
                ", return_msg='" + return_msg + '\'' +
                ", return_body=" + return_body +
                '}';
    }

    /**
     * return_code : SUCCESS
     * return_msg : 查询成功
     * return_body : ["申请日期","申请部门","申请人","申请事由","部门审批"]
     */

    private String return_code;
    private String return_msg;
    private List<String> return_body;

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

    public List<String> getReturn_body() {
        return return_body;
    }

    public void setReturn_body(List<String> return_body) {
        this.return_body = return_body;
    }
}
