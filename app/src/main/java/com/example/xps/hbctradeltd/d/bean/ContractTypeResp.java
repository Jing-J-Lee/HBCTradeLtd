package com.example.xps.hbctradeltd.d.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/21.
 */

public class ContractTypeResp {

    @Override
    public String toString() {
        return "ContractTypeResp{" +
                "return_code='" + return_code + '\'' +
                ", return_msg='" + return_msg + '\'' +
                ", return_body=" + return_body +
                '}';
    }

    /**
     * return_code : SUCCESS
     * return_msg : 查询成功
     * return_body : [{"tid":"1","type_name":"合同会签单"},{"tid":"2","type_name":"付款审批表"},{"tid":"3","type_name":"用章审批表"}]
     */

    private String return_code;
    private String return_msg;
    private List<ReturnBodyBean> return_body;

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

    public List<ReturnBodyBean> getReturn_body() {
        return return_body;
    }

    public void setReturn_body(List<ReturnBodyBean> return_body) {
        this.return_body = return_body;
    }

    public static class ReturnBodyBean {
        @Override
        public String toString() {
            return "ReturnBodyBean{" +
                    "tid='" + tid + '\'' +
                    ", type_name='" + type_name + '\'' +
                    '}';
        }

        /**
         * tid : 1
         * type_name : 合同会签单
         */

        private String tid;
        private String type_name;

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getType_name() {
            return type_name;
        }

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }
    }
}
