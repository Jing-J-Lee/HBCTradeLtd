package com.example.xps.hbctradeltd.d.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/22.
 */

public class UserList {
    @Override
    public String toString() {
        return "UserList{" +
                "return_code='" + return_code + '\'' +
                ", return_msg='" + return_msg + '\'' +
                ", return_body=" + return_body +
                '}';
    }

    /**
     * return_code : SUCCESS
     * return_msg : 查询成功
     * return_body : [{"d_id":"1","department_name":"财务部","Staff":[{"uid":"4","nickname":"清洁工","true_name":"徐征","head_img":"/upload/2017320/1489980415.jpg"}]},{"d_id":"2","department_name":"市场部","Staff":[{"uid":"1","nickname":"主管领导","true_name":"刘云龙","head_img":"/upload/2017320/1489980415.jpg"},{"uid":"3","nickname":"总经理","true_name":"王虎","head_img":"/upload/2017320/1489980415.jpg"},{"uid":"5","nickname":"保安","true_name":"李静","head_img":"/upload/2017320/1489980415.jpg"}]}]
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
                    "d_id='" + d_id + '\'' +
                    ", department_name='" + department_name + '\'' +
                    ", Staff=" + staff +
                    '}';
        }

        /**
         * d_id : 1
         * department_name : 财务部
         * Staff : [{"uid":"4","nickname":"清洁工","true_name":"徐征","head_img":"/upload/2017320/1489980415.jpg"}]
         */

        private String d_id;
        private String department_name;
        private List<StaffBean> staff;

        public String getD_id() {
            return d_id;
        }

        public void setD_id(String d_id) {
            this.d_id = d_id;
        }

        public String getDepartment_name() {
            return department_name;
        }

        public void setDepartment_name(String department_name) {
            this.department_name = department_name;
        }

        public List<StaffBean> getStaff() {
            return staff;
        }

        public void setStaff(List<StaffBean> staff) {
            this.staff = staff;
        }

        public static class StaffBean {
            @Override
            public String toString() {
                return "StaffBean{" +
                        "uid='" + uid + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", true_name='" + true_name + '\'' +
                        ", head_img='" + head_img + '\'' +
                        '}';
            }

            /**
             * uid : 4
             * nickname : 清洁工
             * true_name : 徐征
             * head_img : /upload/2017320/1489980415.jpg
             */

            private String uid;
            private String nickname;
            private String true_name;
            private String head_img;

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
        }
    }
}
