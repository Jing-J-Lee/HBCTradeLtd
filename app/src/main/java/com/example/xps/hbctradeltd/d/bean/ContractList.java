package com.example.xps.hbctradeltd.d.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/23.
 */

public class ContractList {

    @Override
    public String toString() {
        return "ContractList{" +
                "return_code='" + return_code + '\'' +
                ", return_msg='" + return_msg + '\'' +
                ", return_body=" + return_body +
                '}';
    }

    /**
     * return_code : SUCCESS
     * return_msg : 没有更多记录 查询成功
     * return_body : [{"con_id":"11","uid":"3","create_time":"1490177026","update_time":"0","update_field":"","type":"合同会签单","field":{"申请日期":"2017年3月20日","申请部门":"财务部"},"con_state":"0","nickname":"示例","true_name":"示例","name":"测试","title":"测试测试"}]
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
                    "con_id='" + con_id + '\'' +
                    ", uid='" + uid + '\'' +
                    ", create_time='" + create_time + '\'' +
                    ", update_time='" + update_time + '\'' +
                    ", update_field='" + update_field + '\'' +
                    ", type='" + type + '\'' +
                    ", field=" + field +
                    ", con_state='" + con_state + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", true_name='" + true_name + '\'' +
                    ", name='" + name + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }

        /**
         * con_id : 11
         * uid : 3
         * create_time : 1490177026
         * update_time : 0
         * update_field :
         * type : 合同会签单
         * field : {"申请日期":"2017年3月20日","申请部门":"财务部"}
         * con_state : 0
         * nickname : 示例
         * true_name : 示例
         * name : 测试
         * title : 测试测试
         */

        private String con_id;
        private String uid;
        private String create_time;
        private String update_time;
        private String update_field;
        private String type;
        private FieldBean field;
        private String con_state;
        private String nickname;
        private String true_name;
        private String name;
        private String title;

        public String getCon_id() {
            return con_id;
        }

        public void setCon_id(String con_id) {
            this.con_id = con_id;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }

        public String getUpdate_field() {
            return update_field;
        }

        public void setUpdate_field(String update_field) {
            this.update_field = update_field;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public FieldBean getField() {
            return field;
        }

        public void setField(FieldBean field) {
            this.field = field;
        }

        public String getCon_state() {
            return con_state;
        }

        public void setCon_state(String con_state) {
            this.con_state = con_state;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public static class FieldBean {
            @Override
            public String toString() {
                return "FieldBean{" +
                        "申请日期='" + 申请日期 + '\'' +
                        ", 申请部门='" + 申请部门 + '\'' +
                        '}';
            }

            /**
             * 申请日期 : 2017年3月20日
             * 申请部门 : 财务部
             */

            private String 申请日期;
            private String 申请部门;

            public String get申请日期() {
                return 申请日期;
            }

            public void set申请日期(String 申请日期) {
                this.申请日期 = 申请日期;
            }

            public String get申请部门() {
                return 申请部门;
            }

            public void set申请部门(String 申请部门) {
                this.申请部门 = 申请部门;
            }
        }
    }
}
