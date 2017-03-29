package com.example.xps.hbctradeltd.v.contact;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.xps.hbctradeltd.R;
import com.example.xps.hbctradeltd.d.bean.ContractInfoBean;
import com.example.xps.hbctradeltd.d.bean.ContractList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/29.
 */

public class ContractDetailAdapter extends BaseAdapter {
    HashMap<String,String> data;
    List<HashMap<String,String>> list;
    Context context;

    public ContractDetailAdapter(List<HashMap<String,String>> list, Context context) {
        this.list = list;
        this.context = context;
        Log.e("ss","size "+list.size());
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    contractDetailiewHolder holder=null;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView != null) {
            holder= (contractDetailiewHolder) convertView.getTag();
        }else {
            holder=new contractDetailiewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.contractdetail_item,null);
            holder.name= (TextView) convertView.findViewById(R.id.name);
            holder.info= (TextView) convertView.findViewById(R.id.info);
            convertView.setTag(holder);
        }
//        Iterator<Map.Entry<String, String>> iterator = list.get(position).entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry entry=iterator.next();
//            holder.name.setText(entry.getKey().toString());
//            holder.info.setText(entry.getValue().toString());
//        }
//        Iterator<String> iterator1 = list.get(position).keySet().iterator();
//        while (iterator1.hasNext()) {
//            holder.name.setText(iterator1.next());
//            holder.info.setText(list.get(position).get(iterator1.next()));
//        }
        HashMap<String, String> map = list.get(position);
        for (String key:  map.keySet()){
            holder.name.setText(key);
            holder.info.setText(map.get(key));
        }
        return convertView;
    }

    class contractDetailiewHolder{
        TextView name,info;
    }
}
