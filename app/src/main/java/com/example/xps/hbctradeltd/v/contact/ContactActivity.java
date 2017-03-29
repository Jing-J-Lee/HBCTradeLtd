package com.example.xps.hbctradeltd.v.contact;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xps.hbctradeltd.R;
import com.example.xps.hbctradeltd.c.AppCommond;
import com.example.xps.hbctradeltd.c.ContractNetWork;
import com.example.xps.hbctradeltd.c.UserNetWork;
import com.example.xps.hbctradeltd.d.bean.ContractInfoBean;
import com.example.xps.hbctradeltd.d.bean.DepartmentInfo;
import com.example.xps.hbctradeltd.d.bean.NewContractResp;
import com.example.xps.hbctradeltd.d.bean.UserList;
import com.example.xps.hbctradeltd.v.BaseActivity;
import com.example.xps.hbctradeltd.v.utils.SharedPreferencesUtil;
import com.example.xps.hbctradeltd.v.utils.ToastShow;
import com.zhy.autolayout.AutoRelativeLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

/**
 * Created by XPS on 2017/3/18.
 */

public class ContactActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.title)
    AutoRelativeLayout title;
    @BindView(R.id.expandablelistview)
    ExpandableListView expandablelistview;
    ContactExpandableListViewAdapter myExpandableListViewAdapter;
    ContractInfoBean bean;
    ArrayList<DepartmentInfo> data;
    DepartmentInfo departmentInfo;
    StringBuilder sb;
    @BindView(R.id.tv_send)
    TextView mTvSend;

    @Override
    protected int getLayout() {
        return R.layout.activity_contact;
    }

    @Override
    protected void setData() {
        userList();
        mTvSend.setOnClickListener(this);
    }

    @Override
    protected void init() {
        ButterKnife.bind(this);
//        EventBus.getDefault().register(this);
        Intent intent = getIntent();
        bean = (ContractInfoBean) intent.getExtras().getSerializable("data");
    }

    @Override
    public void onReciveEvent(AppCommond a) {
    }

    @OnClick(R.id.iv_back)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_send:

                sb = new StringBuilder();
                sb.append("{");
                int a = 1;
                for (int i = 0; i < data.size(); i++) {
                    ArrayList<DepartmentInfo.Staff> staffs = data.get(i).getStaffs();
                    for (int i1 = 0; i1 < staffs.size(); i1++) {
                        if (staffs.get(i1).ischeck()) {
                            String true_name = staffs.get(i1).getTrue_name();
                            sb.append("\"" + true_name + "\"");
                            sb.append(":" + "\"" + (a++) + "\"" + ",");
                        }
                    }
                }
                Log.e("ss","size "+data.size());
                String s = sb.toString();
                String substring = s.substring(0, s.length() - 1);
                Log.e("ss","string "+s);
                sb=new StringBuilder();
                sb.append(substring+"}");
                Log.e("ss", "sb " + sb.toString());
                createContract();
                break;
        }
    }

    void userList() {
        UserNetWork.searchUserList(SharedPreferencesUtil.getMsg("uid"), new Subscriber<UserList>() {
            @Override
            public void onCompleted() {
                Log.e("searchUserList", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                Log.e("searchUserList", "onError");
            }

            @Override
            public void onNext(UserList userList) {
                data = new ArrayList<>();
                if (userList.getReturn_code().equals("SUCCESS")) {
                    List<UserList.ReturnBodyBean> return_body = userList.getReturn_body();
                    for (UserList.ReturnBodyBean bean : return_body) {
                        departmentInfo = new DepartmentInfo();
                        departmentInfo.setD(bean.getDepartment_name());
                        departmentInfo.setD_id(bean.getD_id());
                        for (UserList.ReturnBodyBean.StaffBean staff : bean.getStaff()) {
                            DepartmentInfo.Staff df = new DepartmentInfo().new Staff(staff.getUid(), staff.getNickname(), staff.getTrue_name(), staff.getHead_img());
                            departmentInfo.addStaff(df);
                        }
                        data.add(departmentInfo);
                    }
                }

                myExpandableListViewAdapter = new ContactExpandableListViewAdapter(ContactActivity.this, data);
                expandablelistview.setAdapter(myExpandableListViewAdapter);
            }
        });
    }

    void createContract() {

//        Log.e("ss","in "+sb.toString());
        ContractNetWork.createContract(SharedPreferencesUtil.getMsg("uid"), bean.getType(), bean.getName(), bean.getTitle(), bean.getField(), sb.toString(), new Subscriber<NewContractResp>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(NewContractResp newContractResp) {
                if (newContractResp.getReturn_code().equals("SUCCESS")) {
                    AppCommond a = new AppCommond();
                    a.setInfo("a");
                    EventBus.getDefault().post(a);
                    ToastShow.getInstance(ContactActivity.this).toastShow(newContractResp.getReturn_msg());
                    finish();
                } else {
                    ToastShow.getInstance(ContactActivity.this).toastShow(newContractResp.getReturn_msg());
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
