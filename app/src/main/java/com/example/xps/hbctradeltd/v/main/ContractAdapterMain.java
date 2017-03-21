package com.example.xps.hbctradeltd.v.main;

import android.content.Context;
import android.graphics.Outline;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import com.example.xps.hbctradeltd.R;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.List;

public class ContractAdapterMain extends RecyclerView.Adapter<ContractAdapterMain.MyViewHolder> {
    private List<String> mDatas;
    private Context mContext;
    private LayoutInflater inflater;
    private ViewOutlineProvider mOutlineProviderCircle;
    int mElevation = 5;
    int margin = 20;

    public ContractAdapterMain(Context context, List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
        inflater = LayoutInflater.from(mContext);
        mOutlineProviderCircle = new CircleOutlineProvider();
    }

    public void adddata(List<String> data) {
        mDatas.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.re_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    //填充onCreateViewHolder方法返回的holder中的控件
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv.setText(mDatas.get(position));
        holder.item_ll.setOutlineProvider(mOutlineProviderCircle);
        holder.item_ll.setClipToOutline(true);
        holder.item_ll.setElevation(mElevation);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        AutoLinearLayout item_ll;
        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.tv_item);
            item_ll = (AutoLinearLayout) view.findViewById(R.id.item_ll);
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
