package com.example.xps.hbctradeltd.v.folder;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xps.hbctradeltd.R;
import com.example.xps.hbctradeltd.c.AppCommond;
import com.example.xps.hbctradeltd.v.BaseActivity;
import com.example.xps.hbctradeltd.v.editcontract.EditContractActivity;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FolderActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.title)
    AutoRelativeLayout title;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.add_newcontract)
    TextView addNewcontract;

    ContractAdapterFolder adapter;

    int lastVisibleItem = 0;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what == 1) {
                ArrayList<String> l = new ArrayList<>();
                l.add("1");
                l.add("2");
                l.add("3");
                adapter.adddata(l);
            } else if (msg.what == 0) {

            }
        }
    };

    @Override
    protected int getLayout() {
        return R.layout.activityfolder;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void init() {
        ButterKnife.bind(this);

        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("1");
        list.add("2");
        list.add("3");

        adapter = new ContractAdapterFolder(this, list);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE//如果当前没有滚动 而且是最后一条
                        && lastVisibleItem + 1 == adapter.getItemCount()) {
                    handler.sendEmptyMessageDelayed(1, 1000);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = layoutManager.findLastVisibleItemPosition();
            }
        });
    }

    @Override
    public void onReciveEvent(AppCommond a) {

    }

    @OnClick({R.id.iv_back, R.id.add_newcontract})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.add_newcontract:

                startActivity(new Intent(this, EditContractActivity.class));

                break;
        }
    }
}
