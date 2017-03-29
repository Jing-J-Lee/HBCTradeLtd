package com.example.xps.hbctradeltd.v.contact;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xps.hbctradeltd.R;
import com.example.xps.hbctradeltd.c.AppCommond;
import com.example.xps.hbctradeltd.d.bean.ContractList;
import com.example.xps.hbctradeltd.v.BaseActivity;
import com.example.xps.hbctradeltd.v.utils.PHPSerialize;
import com.example.xps.hbctradeltd.v.utils.PHPValue;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactDetailActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.title_actionbar)
    TextView mTitleActionbar;
    @BindView(R.id.tv_send)
    TextView mTvSend;
    @BindView(R.id.contact_detail_ll)
    AutoLinearLayout mContactDetailLl;
    @BindView(R.id.contact_rl_tv)
    TextView mContactRlTv;
    @BindView(R.id.contact_btn_rl)
    AutoRelativeLayout mContactBtnRl;
    @BindView(R.id.contact_detail_lv)
    ListView mContactDetailLv;
    int mElevation = 1;
    int margin = 25;
    ContractList.ReturnBodyBean data;
    HashMap<String,String> map;
    List<HashMap<String,String>> list;

    @Override
    protected int getLayout() {
        return R.layout.activity_contact_detail;
    }

    @Override
    protected void setData() {
        mIvBack.setOnClickListener(this);
    }

    @SuppressLint("NewApi")
    @Override
    protected void init() {
        ButterKnife.bind(this);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        data = (ContractList.ReturnBodyBean) extras.getSerializable("data");
        if (data.getCon_state().equals("0")) {
            mTitleActionbar.setText("未完成合同");
            mContactBtnRl.setBackgroundResource(R.color.red);
            mContactRlTv.setText("正在处理中");
        } else if (data.getCon_state().equals("1")) {
            mTitleActionbar.setText("已完成合同");
            mContactRlTv.setText("查看审批流程");
        }
        mTvSend.setVisibility(View.GONE);
        mContactDetailLl.setOutlineProvider(new CircleOutlineProvider());
        mContactDetailLl.setClipToOutline(true);
        mContactDetailLl.setElevation(mElevation);

        mContactBtnRl.setOnClickListener(this);
        ContractList.ReturnBodyBean.FieldBean field = data.getField();
//        Log.e("ss",field.toString());
        map=new HashMap<>();
        list=new ArrayList<>();
        String[] split = field.toString().split(",");
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split("='");
            map.put(split1[0],split1[1].substring(0,split1[1].length()-1));
//                Log.e("ss1",split1[0]+":"+split1[1].substring(0,split1[1].length()-1));
            list.add(map);
        }
        mContactDetailLv.setAdapter(new ContractDetailAdapter(list,ContactDetailActivity.this));
    }

    @Override
    public void onReciveEvent(AppCommond a) {
        if (a.getInfo().equals("a")) {
            finish();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;

            case R.id.contact_btn_rl:
                startActivity(new Intent(ContactDetailActivity.this, ApprovalProcessActivity.class).putExtra("conid",data.getCon_id()));
                break;
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
