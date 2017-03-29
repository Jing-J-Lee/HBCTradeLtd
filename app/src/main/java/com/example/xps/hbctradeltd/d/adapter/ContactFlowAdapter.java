package com.example.xps.hbctradeltd.d.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xps.hbctradeltd.R;
import com.example.xps.hbctradeltd.d.bean.ContractStateResp;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/24.
 */

public class ContactFlowAdapter extends BaseAdapter {
    Context context;
    List<ContractStateResp.ReturnBodyBean> data;

    public ContactFlowAdapter(Context context, List<ContractStateResp.ReturnBodyBean> data) {
        this.context = context;
        this.data = data;
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
    ViewHolder holder=null;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView != null) {
            holder= (ViewHolder) convertView.getTag();
        }else {
            holder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.item_contact_flow_lv,null);
            holder.agree= (ImageView) convertView.findViewById(R.id.suggest_agree);
            holder.seggestTv= (TextView) convertView.findViewById(R.id.suggest_detail);
            holder.suggest= (TextView) convertView.findViewById(R.id.suggest);
            convertView.setTag(holder);
        }
        holder.seggestTv.setText(data.get(position).getOpinion());
        holder.suggest.setText(data.get(position).getNickname());
        if (data.get(position).getAgree()==1) {
            holder.agree.setImageResource(R.drawable.agree);
        }else if (data.get(position).getAgree()==2){
            holder.agree.setImageResource(R.drawable.rejected);
        }else if (data.get(position).getAgree()==0){
            Log.e("ss","处理中");
        }
        return convertView;
    }

    class ViewHolder{
        TextView suggest,seggestTv;
        ImageView agree;
    }
}
