package com.example.xps.hbctradeltd.v.contact;

import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.example.xps.hbctradeltd.R;
import com.example.xps.hbctradeltd.c.AppCommond;
import com.example.xps.hbctradeltd.c.UserNetWork;
import com.example.xps.hbctradeltd.d.bean.ContactUserBean;
import com.example.xps.hbctradeltd.d.bean.DepartmentInfo;
import com.example.xps.hbctradeltd.d.bean.UserList;
import com.example.xps.hbctradeltd.v.BaseActivity;
import com.example.xps.hbctradeltd.v.utils.SharedPreferencesUtil;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    protected int getLayout() {
        return R.layout.activity_contact;
    }

    @Override
    protected void setData() {
        userList();

    }

    @Override
    protected void init() {
        ButterKnife.bind(this);
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
                ArrayList<DepartmentInfo> departmentInfos = new ArrayList<>();
                if (userList.getReturn_code().equals("SUCCESS")) {
                    List<UserList.ReturnBodyBean> return_body = userList.getReturn_body();

                    for (UserList.ReturnBodyBean bean : return_body) {
                        DepartmentInfo departmentInfo = new DepartmentInfo();

                        departmentInfo.setD(bean.getDepartment_name());
                        departmentInfo.setD_id(bean.getD_id());

                        for (UserList.ReturnBodyBean.StaffBean staff : bean.getStaff()) {
                            DepartmentInfo.Staff df = new DepartmentInfo().new Staff(staff.getUid(), staff.getNickname(), staff.getTrue_name(), staff.getHead_img());
                            departmentInfo.addStaff(df);
                        }
                        departmentInfos.add(departmentInfo);
                    }
                }

                ContactExpandableListViewAdapter myExpandableListViewAdapter = new ContactExpandableListViewAdapter(ContactActivity.this, departmentInfos);
                expandablelistview.setAdapter(myExpandableListViewAdapter);

            }
        });
    }
}
