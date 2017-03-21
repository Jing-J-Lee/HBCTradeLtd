package com.example.xps.hbctradeltd.d.bean;

/**
 * Created by XPS on 2017/3/10.
 */

public class LoginResp {

    @Override
    public String toString() {

        String retrunBodyStr = "null";
        try {
            retrunBodyStr = return_body.toString();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return "LoginResp{" +
                "return_code='" + return_code + '\'' +
                ", return_msg='" + return_msg + '\'' +
                ", return_body=" + retrunBodyStr +
                '}';
    }

    /**
     * return_code : SUCCESS
     * return_msg : 登录成功
     * return_body : {"uid":"3","nickname":"示例","true_name":"示例","head_img":"","mob_phone":"18134137900","sex":"1","email":"","login_time":"1488885811","old_login_time":"0","login_num":"1"}
     */

    private String return_code;
    private String return_msg;
    private ReturnBodyBean return_body;

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

    public ReturnBodyBean getReturn_body() {
        return return_body;
    }

    public void setReturn_body(ReturnBodyBean return_body) {
        this.return_body = return_body;
    }

    public static class ReturnBodyBean {

        @Override
        public String toString() {
            return "ReturnBodyBean{" +
                    "uid='" + uid + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", true_name='" + true_name + '\'' +
                    ", head_img='" + head_img + '\'' +
                    ", mob_phone='" + mob_phone + '\'' +
                    ", sex='" + sex + '\'' +
                    ", email='" + email + '\'' +
                    ", login_time='" + login_time + '\'' +
                    ", old_login_time='" + old_login_time + '\'' +
                    ", login_num='" + login_num + '\'' +
                    '}';
        }

        /**
         * uid : 3
         * nickname : 示例
         * true_name : 示例
         * head_img :
         * mob_phone : 18134137900
         * sex : 1
         * email :
         * login_time : 1488885811
         * old_login_time : 0
         * login_num : 1
         */

        private String uid;
        private String nickname;
        private String true_name;
        private String head_img;
        private String mob_phone;
        private String sex;
        private String email;
        private String login_time;
        private String old_login_time;
        private String login_num;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
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

        public String getHead_img() {
            return head_img;
        }

        public void setHead_img(String head_img) {
            this.head_img = head_img;
        }

        public String getMob_phone() {
            return mob_phone;
        }

        public void setMob_phone(String mob_phone) {
            this.mob_phone = mob_phone;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getLogin_time() {
            return login_time;
        }

        public void setLogin_time(String login_time) {
            this.login_time = login_time;
        }

        public String getOld_login_time() {
            return old_login_time;
        }

        public void setOld_login_time(String old_login_time) {
            this.old_login_time = old_login_time;
        }

        public String getLogin_num() {
            return login_num;
        }

        public void setLogin_num(String login_num) {
            this.login_num = login_num;
        }
    }
}
