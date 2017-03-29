package com.example.xps.hbctradeltd.v.contact;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Outline;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xps.hbctradeltd.R;
import com.example.xps.hbctradeltd.c.AppCommond;
import com.example.xps.hbctradeltd.c.ContractNetWork;
import com.example.xps.hbctradeltd.d.bean.ContractStateResp;
import com.example.xps.hbctradeltd.v.BaseActivity;
import com.example.xps.hbctradeltd.d.adapter.ContactFlowAdapter;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;

public class ApprovalProcessActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.title_actionbar)
    TextView mTitleActionbar;
    @BindView(R.id.tv_send)
    TextView mTvSend;
    @BindView(R.id.title)
    AutoRelativeLayout mTitle;
    @BindView(R.id.tv_item)
    TextView mTvItem;
    @BindView(R.id.contact_flow_lv)
    ListView mContactFlowLv;
    @BindView(R.id.contact_flow_ll)
    AutoLinearLayout mContactFlowLl;
    @BindView(R.id.reject_img)
    ImageView mRejectImg;
    @BindView(R.id.reject)
    AutoRelativeLayout mReject;
    @BindView(R.id.accept)
    ImageView mAccept;
    @BindView(R.id.agree)
    AutoRelativeLayout mAgree;
    @BindView(R.id.contact_btn_rl)
    AutoLinearLayout mContactBtnRl;


    int mElevation = 1;
    int margin = 25;
    ContactFlowAdapter adapter;
    String con_id;
    List<ContractStateResp.ReturnBodyBean> data;

    @Override
    protected int getLayout() {
        return R.layout.activity_approval_process;
    }

    @Override
    protected void setData() {
        queryContractState();
    }

    @SuppressLint("NewApi")
    @Override
    protected void init() {
        ButterKnife.bind(this);
        mIvBack.setOnClickListener(this);
        mTitleActionbar.setText("审批流程");
        mTvSend.setVisibility(View.GONE);
        mContactFlowLl.setOutlineProvider(new CircleOutlineProvider());
        mContactFlowLl.setClipToOutline(true);
        mContactFlowLl.setElevation(mElevation);
        Intent intent=getIntent();
        con_id = intent.getExtras().getString("conid");
    }

    @Override
    public void onReciveEvent(AppCommond a) {}

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

    void queryContractState(){

        ContractNetWork.queryContractState(con_id, new Subscriber<ContractStateResp>() {
            @Override
            public void onCompleted() {}

            @Override
            public void onError(Throwable e) {
                Log.e("ss","error"+e.toString());
            }

            @Override
            public void onNext(ContractStateResp contractStateResp) {
                data= contractStateResp.getReturn_body();
                if (contractStateResp.getReturn_code().equals("SUCCESS")) {
                    adapter=new ContactFlowAdapter(ApprovalProcessActivity.this,contractStateResp.getReturn_body());
                    mContactFlowLv.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private class CircleOutlineProvider extends ViewOutlineProvider {
        @Override
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(margin, margin, view.getWidth() - margin, view.getHeight(), 15);
        }
    }
}
