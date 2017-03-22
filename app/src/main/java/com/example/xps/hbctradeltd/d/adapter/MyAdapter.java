package com.example.xps.hbctradeltd.d.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.xps.hbctradeltd.R;
import com.example.xps.hbctradeltd.d.bean.ContractTypeResp;

import java.util.List;

/**
 * Created by Administrator on 2017/3/22.
 */

public class MyAdapter extends BaseAdapter{
    Context mContext;
    List<ContractTypeResp.ReturnBodyBean> data;

    public MyAdapter(Context context, List<ContractTypeResp.ReturnBodyBean> data) {
        mContext = context;
        this.data = data;
//        Log.e("ss", "MyAdapter:"+data.get(1).getType_name());
    }

    @Override
    public int getCount() {
        return data==null?0:data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder=null;
        if (convertView != null) {
            holder= (Holder) convertView.getTag();
        }else {
            holder=new Holder();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.contract_type_dialog_item,null);
            holder.contractType= (TextView) convertView.findViewById(R.id.type);
            convertView.setTag(holder);
        }

        holder.contractType.setText(data.get(position).getType_name());
        return convertView;
    }

    class Holder{
        TextView contractType;
    }
}
