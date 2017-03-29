package com.example.xps.hbctradeltd.d.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/23.
 */

public class ContractList implements Serializable{


    /**
     * return_code : SUCCESS
     * return_msg : 查询成功
     * return_body : [{"con_id":"19","uid":"4","create_time":"1490753533","update_time":"0","update_field":[],"type":"合同会签单","field":{"对方公司名称":"是啊真爱在","合同附件内容":"内容","合同内容":"内容","对方公司联系部门":"内容","合同价款":"内容","需盖章名称":"内容","合同期限":"内容","合同总页数、份数":"内容"},"con_state":"0","nickname":"清洁工","true_name":"徐征","mob_phone":"15201269722","name":"在一起是什么样子","title":"这种情况下\u2026\u2026是","android_field":[{"key":"对方公司名称","value":"是啊真爱在"},{"key":"合同附件内容","value":"内容"},{"key":"合同内容","value":"内容"},{"key":"对方公司联系部门","value":"内容"},{"key":"合同价款","value":"内容"},{"key":"需盖章名称","value":"内容"},{"key":"合同期限","value":"内容"},{"key":"合同总页数、份数","value":"内容"}]},{"con_id":"11","uid":"3","create_time":"1490177026","update_time":"1490268729","update_field":["申请事由","申请事由2"],"type":"用章审批表","field":{"申请日期":"2017年3月20日","申请事由":"我要盖章","申请事由2":"我就是要盖章"},"con_state":"0","nickname":"经理","true_name":"王虎","mob_phone":"18134137905","name":"测试更新","title":"测试更新测试更新","android_field":[{"key":"申请日期","value":"2017年3月20日"},{"key":"申请事由","value":"我要盖章"},{"key":"申请事由2","value":"我就是要盖章"}]},{"con_id":"10","uid":"2","create_time":"1490177023","update_time":"0","update_field":[],"type":"合同会签单","field":{"申请日期":"2017年3月20日","申请部门":"财务部"},"con_state":"0","nickname":"行政负责人","true_name":"周攀","mob_phone":"15505670640","name":"测试","title":"测试测试","android_field":[{"key":"申请日期","value":"2017年3月20日"},{"key":"申请部门","value":"财务部"}]},{"con_id":"9","uid":"1","create_time":"1490177016","update_time":"0","update_field":[],"type":"合同会签单","field":{"申请日期":"2017年3月20日","申请部门":"财务部"},"con_state":"0","nickname":"主管领导","true_name":"刘云龙","mob_phone":"15516761721","name":"测试","title":"测试测试","android_field":[{"key":"申请日期","value":"2017年3月20日"},{"key":"申请部门","value":"财务部"}]}]
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

    public static class ReturnBodyBean implements Serializable{
        /**
         * con_id : 19
         * uid : 4
         * create_time : 1490753533
         * update_time : 0
         * update_field : []
         * type : 合同会签单
         * field : {"对方公司名称":"是啊真爱在","合同附件内容":"内容","合同内容":"内容","对方公司联系部门":"内容","合同价款":"内容","需盖章名称":"内容","合同期限":"内容","合同总页数、份数":"内容"}
         * con_state : 0
         * nickname : 清洁工
         * true_name : 徐征
         * mob_phone : 15201269722
         * name : 在一起是什么样子
         * title : 这种情况下……是
         * android_field : [{"key":"对方公司名称","value":"是啊真爱在"},{"key":"合同附件内容","value":"内容"},{"key":"合同内容","value":"内容"},{"key":"对方公司联系部门","value":"内容"},{"key":"合同价款","value":"内容"},{"key":"需盖章名称","value":"内容"},{"key":"合同期限","value":"内容"},{"key":"合同总页数、份数","value":"内容"}]
         */

        private String con_id;
        private String uid;
        private String create_time;
        private String update_time;
        private String type;
        private FieldBean field;
        private String con_state;
        private String nickname;
        private String true_name;
        private String mob_phone;
        private String name;
        private String title;
        private List<?> update_field;
        private List<AndroidFieldBean> android_field;

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

        public String getMob_phone() {
            return mob_phone;
        }

        public void setMob_phone(String mob_phone) {
            this.mob_phone = mob_phone;
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

        public List<?> getUpdate_field() {
            return update_field;
        }

        public void setUpdate_field(List<?> update_field) {
            this.update_field = update_field;
        }

        public List<AndroidFieldBean> getAndroid_field() {
            return android_field;
        }

        public void setAndroid_field(List<AndroidFieldBean> android_field) {
            this.android_field = android_field;
        }

        public static class FieldBean implements Serializable{
            @Override
            public String toString() {
                return
                        "对方公司名称='" + 对方公司名称 + '\'' +
                        ", 合同附件内容='" + 合同附件内容 + '\'' +
                        ", 合同内容='" + 合同内容 + '\'' +
                        ", 对方公司联系部门='" + 对方公司联系部门 + '\'' +
                        ", 合同价款='" + 合同价款 + '\'' +
                        ", 需盖章名称='" + 需盖章名称 + '\'' +
                        ", 合同期限='" + 合同期限 + '\'' +
                        ", _$168='" + _$168 + '\'';
            }

            /**
             * 对方公司名称 : 是啊真爱在
             * 合同附件内容 : 内容
             * 合同内容 : 内容
             * 对方公司联系部门 : 内容
             * 合同价款 : 内容
             * 需盖章名称 : 内容
             * 合同期限 : 内容
             * 合同总页数、份数 : 内容
             */


            private String 对方公司名称;
            private String 合同附件内容;
            private String 合同内容;
            private String 对方公司联系部门;
            private String 合同价款;
            private String 需盖章名称;
            private String 合同期限;
            @SerializedName("合同总页数、份数")
            private String _$168; // FIXME check this code

            public String get对方公司名称() {
                return 对方公司名称;
            }

            public void set对方公司名称(String 对方公司名称) {
                this.对方公司名称 = 对方公司名称;
            }

            public String get合同附件内容() {
                return 合同附件内容;
            }

            public void set合同附件内容(String 合同附件内容) {
                this.合同附件内容 = 合同附件内容;
            }

            public String get合同内容() {
                return 合同内容;
            }

            public void set合同内容(String 合同内容) {
                this.合同内容 = 合同内容;
            }

            public String get对方公司联系部门() {
                return 对方公司联系部门;
            }

            public void set对方公司联系部门(String 对方公司联系部门) {
                this.对方公司联系部门 = 对方公司联系部门;
            }

            public String get合同价款() {
                return 合同价款;
            }

            public void set合同价款(String 合同价款) {
                this.合同价款 = 合同价款;
            }

            public String get需盖章名称() {
                return 需盖章名称;
            }

            public void set需盖章名称(String 需盖章名称) {
                this.需盖章名称 = 需盖章名称;
            }

            public String get合同期限() {
                return 合同期限;
            }

            public void set合同期限(String 合同期限) {
                this.合同期限 = 合同期限;
            }

            public String get_$168() {
                return _$168;
            }

            public void set_$168(String _$168) {
                this._$168 = _$168;
            }
        }

        public static class AndroidFieldBean implements Serializable{
            /**
             * key : 对方公司名称
             * value : 是啊真爱在
             */
            private String key;
            private String value;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}
