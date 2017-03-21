package com.example.xps.hbctradeltd.v.editcontract;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xps.hbctradeltd.R;
import com.example.xps.hbctradeltd.c.AppCommond;
import com.example.xps.hbctradeltd.d.bean.ContrackItem;
import com.example.xps.hbctradeltd.v.BaseActivity;
import com.example.xps.hbctradeltd.v.contact.ContactActivity;
import com.example.xps.hbctradeltd.v.view.CustomDialog;
import com.example.xps.hbctradeltd.v.view.HBCListView;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by XPS on 2017/3/14.
 */

public class EditContractActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_send)
    TextView tvSend;
    @BindView(R.id.title)
    AutoRelativeLayout title;
    @BindView(R.id.re_ContractType)
    AutoRelativeLayout reContractType;
    @BindView(R.id.re_ContractName)
    AutoLinearLayout reContractName;
    @BindView(R.id.re_ContractSummery)
    AutoLinearLayout re_ContractSummery;
    @BindView(R.id.frame_AddPicAttach)
    FrameLayout frameAddPicAttach;
    @BindView(R.id.tv_edititems)
    TextView tvEdititems;
    @BindView(R.id.lv_content)
    HBCListView contractItemLV;
    @BindView(R.id.add_newcontract)
    TextView addNewcontract;
    @BindView(R.id.tv_contractType)
    TextView tvContractType;
    @BindView(R.id.tv_contractName)
    TextView tvContractName;
    @BindView(R.id.tv_contractSummery)
    TextView tvContractSummery;
    @BindView(R.id.tv_contractName2)
    TextView tvContractNameValue;
    @BindView(R.id.tv_contractSummery2)
    TextView tvContractSummeryValue;
    @BindView(R.id.tv_done)
    TextView tv_done;

    ContractItemAdapter adapter;
    CustomDialog customDialog;

    public static int FROM_ITEM = 0x1;
    public static int FROM_LIST = 0x2;
    public static int FROM_ADD = 0x5;
    public static int TO_DIALOG = 0x3;
    public static int TO_ACTIVITY = 0x4;
    
    @Override
    protected int getLayout() {
        return R.layout.activit_editcontract;
    }

    void showEdit() {
        tv_done.setVisibility(View.VISIBLE);
        tvEdititems.setText("删除");
        adapter.visibleCb(true);
    }

    @Override
    protected void setData() {

        ArrayList<ContrackItem> list = new ArrayList<>();
        list.add(new ContrackItem("合同附件内容", "测试"));
        list.add(new ContrackItem("合同编号", "测试"));
        list.add(new ContrackItem("付款方式", "测试"));
        list.add(new ContrackItem("我方负责人", "测试"));
        list.add(new ContrackItem("合同附件内容2", "测试"));
        list.add(new ContrackItem("合同编号3", "测试"));
        list.add(new ContrackItem("付款方式4", "测试"));
        list.add(new ContrackItem("我方负责人5", "测试"));

        adapter = new ContractItemAdapter(this, list);
        contractItemLV.setAdapter(adapter);
        contractItemLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<ContrackItem> innerData = adapter.getAdapterData();
                Bundle b = new Bundle();
                b.putInt("FROM_TYPE", EditContractActivity.FROM_LIST);
                b.putInt("TO", EditContractActivity.TO_DIALOG);
                b.putString("KEY", innerData.get(position).getKey());
                b.putString("VALUE", innerData.get(position).getValue());
                EventBus.getDefault().post(b);
            }
        });

        tv_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditListDone();
            }
        });

        customDialog = new CustomDialog(EditContractActivity.this);
        customDialog.setNoOnclickListener("取消", new CustomDialog.onCancelBtclickListener() {
            @Override
            public void onNoClick() {
                customDialog.dismiss();
            }
        });
        customDialog.setYesOnclickListener("确定", new CustomDialog.onOkBtOnclickListener() {
            @Override
            public void onYesClick() {
                customDialog.dismiss();
            }
        });

        customDialog.show();
        customDialog.dismiss();

    }

    void EditListDone() {
        tv_done.setVisibility(View.INVISIBLE);
        tvEdititems.setText("编辑");
        adapter.visibleCb(false);
    }

    @Override
    protected void init() {
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onReciveEvent(AppCommond a) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReciveDialogEventDialog(Bundle b) {
        if (b.getInt("TO") == EditContractActivity.TO_ACTIVITY) {//判断是dialog发回来的数据
            if (b.getInt("FROM_TYPE") == FROM_ITEM) {//来自固定的item
                if (b.getString("KEY").equals(tvContractName.getText().toString())) {
                    tvContractNameValue.setText(b.getString("VALUE"));
                } else if (b.getString("KEY").equals(tvContractSummery.getText().toString())) {
                    tvContractSummeryValue.setText(b.getString("VALUE"));
                }
            } else if (b.getInt("FROM_TYPE") == FROM_LIST) {//来自列表
                updateItem(b.getString("KEY_BEFORECHANGE"), b.getString("KEY"), b.getString("VALUE"));
            } else if (b.getInt("FROM_TYPE") == FROM_ADD) {//来自添加条目
                addItem(b.getString("KEY"), b.getString("VALUE"));
            }
        }
    }

    void updateItem(String keyBeforechange, String keyRecevice, String value) {
        List<ContrackItem> items = adapter.getAdapterData();
        for (int i = 0; i < items.size(); i++) {
            ContrackItem item = items.get(i);
            if (item.getKey().equals(keyBeforechange)) {
                item.setValue(value);
                item.setKey(keyRecevice);
            }
        }
        adapter.notifyDataSetChanged();
    }

    void addItem(String key, String value) {
        String putkey = key;
        adapter.putItem(new ContrackItem(putkey, value));
    }

    @OnClick({R.id.iv_back, R.id.tv_send, R.id.frame_AddPicAttach, R.id.tv_edititems, R.id.add_newcontract, R.id.re_ContractType, R.id.re_ContractName, R.id.re_ContractSummery})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_send:
                startActivity(new Intent(this, ContactActivity.class));
                break;
            case R.id.frame_AddPicAttach:
                break;
            case R.id.tv_edititems:

                if (tvEdititems.getText().equals("编辑")) {
                    showEdit();
                } else if (tvEdititems.getText().equals("删除")) {
                    Log.e("onClick", "删除");
                    adapter.deleteItem();
                }

                break;
            case R.id.add_newcontract:
                EditListDone();

                Bundle bundleAddcontract = new Bundle();
                bundleAddcontract.putInt("FROM_TYPE", FROM_ADD);
                bundleAddcontract.putInt("TO", TO_DIALOG);
                EventBus.getDefault().post(bundleAddcontract);

                break;
            case R.id.re_ContractSummery:

                Bundle bundleSummery = new Bundle();
                bundleSummery.putInt("FROM_TYPE", FROM_ITEM);
                bundleSummery.putInt("TO", TO_DIALOG);
                bundleSummery.putString("KEY", tvContractSummery.getText().toString());
                bundleSummery.putString("VALUE", tvContractSummeryValue.getText().toString());
                EventBus.getDefault().post(bundleSummery);

                break;
            case R.id.re_ContractName:

                Bundle bundleContractName = new Bundle();
                bundleContractName.putInt("FROM_TYPE", FROM_ITEM);
                bundleContractName.putInt("TO", TO_DIALOG);
                bundleContractName.putString("KEY", tvContractName.getText().toString());
                bundleContractName.putString("VALUE", tvContractNameValue.getText().toString());
                EventBus.getDefault().post(bundleContractName);

                break;
            case R.id.re_ContractType:

                break;
        }
    }
}
