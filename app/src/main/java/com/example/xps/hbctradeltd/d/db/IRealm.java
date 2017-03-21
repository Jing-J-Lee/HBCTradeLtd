package com.example.xps.hbctradeltd.d.db;

import java.util.Collection;

import io.realm.RealmObject;

//note: RealmObject的子类显示声明了无参构造函数会导致编译失败
public interface IRealm {

    void delete(int index);

    void deleteAllinrealm();

    Collection<? extends RealmObject> findAll();

    void asyncTransaction(Object o);
}
