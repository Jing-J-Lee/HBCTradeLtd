package com.example.xps.hbctradeltd.d.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/28.
 */

public class ContractStateResp implements Serializable{

    /**
     * return_code : SUCCESS
     * return_msg : 查询成功
     * return_body : [{"uid":"1","opinion":"暂无批注意见","agree":0,"nickname":"主管领导","true_name":"刘云龙"},{"uid":"5","opinion":"","agree":0,"nickname":"保安","true_name":"李静"}]
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
        /**
         * uid : 1
         * opinion : 暂无批注意见
         * agree : 0
         * nickname : 主管领导
         * true_name : 刘云龙
         */

        private String uid;
        private String opinion;
        private int agree;
        private String nickname;
        private String true_name;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getOpinion() {
            return opinion;
        }

        public void setOpinion(String opinion) {
            this.opinion = opinion;
        }

        public int getAgree() {
            return agree;
        }

        public void setAgree(int agree) {
            this.agree = agree;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getTrue_name() {
            return true_name;
        }

        public void setTrue_name(String true_name) {
            this.true_name = true_name;
        }
    }
}
