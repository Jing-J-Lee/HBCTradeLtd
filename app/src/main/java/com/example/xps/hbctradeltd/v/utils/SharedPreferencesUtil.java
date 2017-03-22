package com.example.xps.hbctradeltd.v.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.xps.hbctradeltd.v.App;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;



/**
 * SharedPreferences工具类
 * @author lihuanying
 *
 */
public class SharedPreferencesUtil {

	private static final String SP_SETTINGS = "share";


	/**
	 *
	 * @return
	 */
	private static SharedPreferences getSharedPreferences() {
		return App.getINSTANCE().getApplicationContext().getSharedPreferences(SP_SETTINGS, Context.MODE_PRIVATE);
	}

	/**
	 * 配置缓存
	 */
	private static Map<String, String> settingMap = new HashMap<String, String>();

	public static void setText(String mode,String value){
		try {
			SharedPreferences sp = getSharedPreferences();
			sp.edit().putString(mode, value).commit();
			settingMap.put(mode, value);

		} catch (Exception e) {
		}
	}
	public static String getText(String mode) {
		try {
			if(settingMap.containsKey(mode)) {
				return settingMap.get(mode);
			}
			SharedPreferences sp = getSharedPreferences();
			return sp.getString(mode, null);

		} catch (Exception e) {
		}
		return null;
	}


	/**
	 * 登陆
	 */
	public static Boolean isLogin(){
		if (getText("LOGIN") == null)
			return false;
		return new Gson().fromJson(getText("LOGIN"),Boolean.class);
	}
	public static void setLogin(Boolean flag){

		setText("LOGIN", new Gson().toJson(flag));
	}

	/**
	 * 得到缓存的string串
	 * SharedPreferencesUtil.getMsg(username);
	 */
	public static String getMsg(final String KEY){
		return getText(KEY);
	}
	/**
	 * 缓存string串
	 * SharedPreferencesUtil.setMsg(username,"liming");
	 *
	 */
	public static void setMsg(final String KEY,String value){
		setText(KEY, value);
	}
}
