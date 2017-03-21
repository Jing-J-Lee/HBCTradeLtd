package com.example.xps.hbctradeltd.d.db;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

//realm 数据库迁移支持类
public class MyMigration implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();

//        JUtils.Log("migrate","oldVersion"+oldVersion);
//        JUtils.Log("migrate","newVersion"+newVersion);
//
//        if(newVersion == 1){
//            schema.get("User").addField("old",String.class);
//        }
    }
}