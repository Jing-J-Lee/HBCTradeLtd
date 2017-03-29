package com.example.xps.hbctradeltd.d.db;

/**
 * Created by Administrator on 2017/3/27.
 */

public interface Serializable {
    byte[] serialize();
    void unserialize(byte[] ss);
}
