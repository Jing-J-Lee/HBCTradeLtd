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
import android.widget.ImageView;
import android.widget.TextView;
import com.example.xps.hbctradeltd.R;
import com.example.xps.hbctradeltd.c.ContractNetWork;
import com.example.xps.hbctradeltd.d.bean.ContractList;
import com.example.xps.hbctradeltd.d.bean.DeleteContractResp;
import com.example.xps.hbctradeltd.v.utils.SharedPreferencesUtil;
import com.example.xps.hbctradeltd.v.utils.ToastShow;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.List;

import rx.Subscriber;

public class ContractAdapterMain extends RecyclerView.Adapter<ContractAdapterMain.MyViewHolder> implements View.OnClickListener {
    private List<ContractList.ReturnBodyBean> mDatas;
    private Context mContext;
    private LayoutInflater inflater;
    private ViewOutlineProvider mOutlineProviderCircle;
    int mElevation = 5;
    int margin = 20;

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v, (ContractList.ReturnBodyBean) v.getTag());
        }
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    //define interface
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , ContractList.ReturnBodyBean data);
    }

    public ContractAdapterMain(Context context) {
        this.mContext = context;
    }

    public ContractAdapterMain(Context context, List<ContractList.ReturnBodyBean> datas) {
        this.mContext = context;
        this.mDatas = datas;
        inflater = LayoutInflater.from(mContext);
        mOutlineProviderCircle = new CircleOutlineProvider();
//        Log.e("ss"," data "+datas);
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
        view.setOnClickListener(this);
        return holder;
    }

    //填充onCreateViewHolder方法返回的holder中的控件
    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
//        ContractList.ReturnBodyBean.FieldBean field = mDatas.get(position).getField();
        holder.tv.setText(mDatas.get(position).getTitle());
        holder.item_ll.setOutlineProvider(mOutlineProviderCircle);
        holder.item_ll.setClipToOutline(true);
        holder.item_ll.setElevation(mElevation);
        holder.itemView.setTag(mDatas.get(position));

        holder.time.setText(mDatas.get(position).getCreate_time());
        holder.person.setText(mDatas.get(position).getTrue_name());
        holder.detail.setText(mDatas.get(position).getName());
        if (mDatas.get(position).getCon_state().equals("0")) {
            holder.state.setImageResource(R.drawable.imcomplete);
        }else if (mDatas.get(position).getCon_state().equals("1")){
            holder.state.setImageResource(R.drawable.completed);
        }
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDatas.get(position).getUid().equals(SharedPreferencesUtil.getMsg("uid"))) {
                    deleteContract();
                }else {
                    ToastShow.getInstance(mContext).toastShow("没有删除权限");
                }
            }
        });
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv,person,time,detail;
        AutoLinearLayout item_ll;
        ImageView state,delete;
        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.tv_item);
            item_ll = (AutoLinearLayout) view.findViewById(R.id.item_ll);
            person= (TextView) view.findViewById(R.id.contract_person);
            time= (TextView) view.findViewById(R.id.contract_time);
            detail= (TextView) view.findViewById(R.id.contract_des);
            state= (ImageView) view.findViewById(R.id.state);
            delete= (ImageView) view.findViewById(R.id.delete);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private class CircleOutlineProvider extends ViewOutlineProvider {
        @Override
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(margin, margin, view.getWidth() - margin, view.getHeight(), 15);
        }
    }

    void deleteContract(){
        ContractNetWork.deleteContract(SharedPreferencesUtil.getMsg("uid"), mDatas.get(0).getCon_id(), new Subscriber<DeleteContractResp>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(DeleteContractResp deleteContractResp) {
                if (deleteContractResp.getReturn_code().equals("SUCCESS")) {
                    ToastShow.getInstance(mContext).toastShow("删除成功");
                }else {
                    ToastShow.getInstance(mContext).toastShow(deleteContractResp.getReturn_msg());
                }
            }
        });
    }
}
