package com.example.xps.hbctradeltd.v.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Outline;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import com.example.xps.hbctradeltd.R;
import com.example.xps.hbctradeltd.d.bean.ContractList;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.List;

public class ContractAdapterMain extends RecyclerView.Adapter<ContractAdapterMain.MyViewHolder> {
    private List<ContractList.ReturnBodyBean> mDatas;
    private Context mContext;
    private LayoutInflater inflater;
    private ViewOutlineProvider mOutlineProviderCircle;
    int mElevation = 5;
    int margin = 20;

    public ContractAdapterMain(Context context) {
        this.mContext = context;
    }

    public ContractAdapterMain(Context context, List<ContractList.ReturnBodyBean> datas) {
        this.mContext = context;
        this.mDatas = datas;
        inflater = LayoutInflater.from(mContext);
        mOutlineProviderCircle = new CircleOutlineProvider();
        Log.e("ss"," data "+datas);
    }

    public void adddata(List<ContractList.ReturnBodyBean> data) {
        mDatas.addAll(data);
        Log.e("ss","data  "+data.toString());
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mDatas==null?0:mDatas.size();
    }

    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.re_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    //填充onCreateViewHolder方法返回的holder中的控件
    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv.setText(mDatas.get(position).getTitle());
        holder.item_ll.setOutlineProvider(mOutlineProviderCircle);
        holder.item_ll.setClipToOutline(true);
        holder.item_ll.setElevation(mElevation);
        holder.time.setText(mDatas.get(position).getCreate_time());
        holder.person.setText(mDatas.get(position).getTrue_name());
        holder.detail.setText(mDatas.get(position).getName());
//        Log.e("ss",mDatas.get(position).getCreate_time());
//        Log.e("ss",mDatas.get(position).getTitle());
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv,person,time,detail;
        AutoLinearLayout item_ll;
        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.tv_item);
            item_ll = (AutoLinearLayout) view.findViewById(R.id.item_ll);
            person= (TextView) view.findViewById(R.id.contract_person);
            time= (TextView) view.findViewById(R.id.contract_time);
            detail= (TextView) view.findViewById(R.id.contract_des);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private class CircleOutlineProvider extends ViewOutlineProvider {
        @Override
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(margin, margin, view.getWidth() - margin, view.getHeight(), 15);
        }
    }
}
