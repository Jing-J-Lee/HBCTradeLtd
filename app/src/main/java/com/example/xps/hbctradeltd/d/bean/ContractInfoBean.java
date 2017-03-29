package com.example.xps.hbctradeltd.d.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/27.
 */

public class ContractInfoBean implements Serializable {
    String type="";
    String name="";
    String title="";
    String field="";
    String in="";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }
}
