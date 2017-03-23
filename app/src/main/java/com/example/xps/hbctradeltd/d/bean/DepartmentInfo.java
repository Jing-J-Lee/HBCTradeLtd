package com.example.xps.hbctradeltd.d.bean;

import java.util.ArrayList;

public class DepartmentInfo {
    private String d_id = "";
    private String d = "";
    private ArrayList<Staff> staffs = new ArrayList<>();

    public void addStaff(Staff staff) {
        if (staffs != null) staffs.add(staff);
    }

    public DepartmentInfo(String d_id, String d, ArrayList<Staff> staffs) {
        this.d_id = d_id;
        this.d = d;
        this.staffs = staffs;
    }

    public ArrayList<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(ArrayList<Staff> staffs) {
        this.staffs = staffs;
    }

    public DepartmentInfo() {
    }

    public DepartmentInfo(String d_id, String d) {
        this.d_id = d_id;
        this.d = d;
    }

    public String getD_id() {
        return d_id;
    }

    public void setD_id(String d_id) {
        this.d_id = d_id;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public class Staff {

        boolean ischeck = false;

        public boolean ischeck() {
            return ischeck;
        }

        public void setIscheck(boolean ischeck) {
            this.ischeck = ischeck;
        }

        String uid = "";
        String nickname = "";
        String true_name = "";
        String head_img = "";

        public Staff() {
        }

        public Staff(String uid, String nickname, String true_name, String head_img) {
            this.uid = uid;
            this.nickname = nickname;
            this.true_name = true_name;
            this.head_img = head_img;
        }

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

        @Override
        public String toString() {
            return "Staff{" +
                    "uid='" + uid + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", true_name='" + true_name + '\'' +
                    ", head_img='" + head_img + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "DepartmentInfo{" +
                "d_id='" + d_id + '\'' +
                ", d='" + d + '\'' +
                ", staffs=" + staffs +
                '}';
    }
}
