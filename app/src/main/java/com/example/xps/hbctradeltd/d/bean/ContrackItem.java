package com.example.xps.hbctradeltd.d.bean;

/**
 * Created by XPS on 2017/3/17.
 */

public class ContrackItem {
    String key = "";
    String value = "";
    boolean deleteCbVisable = false;
    boolean deleteCbChecked = false;

    public void setDeleteCbVisable(boolean deleteCbVisable) {
        this.deleteCbVisable = deleteCbVisable;
    }

    public boolean isDeleteCbChecked() {
        return deleteCbChecked;
    }

    public void setDeleteCbChecked(boolean deleteCbChecked) {
        this.deleteCbChecked = deleteCbChecked;
    }

    public boolean isDeleteCbVisable() {
        return deleteCbVisable;
    }

    @Override
    public String toString() {
        return "ContrackItem{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", deleteCbVisable=" + deleteCbVisable +
                '}';
    }

    public void setDeleteCheckBoxVisible(boolean deleteCbVisable) {
        this.deleteCbVisable = deleteCbVisable;
    }

    public ContrackItem(String key, String value) {
        this.key = key;
        this.value = value;
    }
    public ContrackItem() {
    }

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
