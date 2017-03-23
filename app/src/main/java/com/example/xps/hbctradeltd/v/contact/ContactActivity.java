package com.example.xps.hbctradeltd.v.contact;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.example.xps.hbctradeltd.R;
import com.example.xps.hbctradeltd.c.AppCommond;
import com.example.xps.hbctradeltd.c.UserNetWork;
import com.example.xps.hbctradeltd.d.bean.ContactUserBean;
import com.example.xps.hbctradeltd.d.bean.UserList;
import com.example.xps.hbctradeltd.v.BaseActivity;
import com.example.xps.hbctradeltd.v.utils.SharedPreferencesUtil;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

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
    Map<String, List<UserList.ReturnBodyBean>> dataset;
    List<UserList.ReturnBodyBean> list;
    UserList.ReturnBodyBean bean;
    String[] parentList;

    private static final int SUCCESS=0;

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SUCCESS:
                    ContactExpandableListViewAdapter myExpandableListViewAdapter = new ContactExpandableListViewAdapter(ContactActivity.this,dataset,parentList);
                    expandablelistview.setAdapter(myExpandableListViewAdapter);
                    break;
            }
        }
    };

    @Override
    protected int getLayout() {
        return R.layout.activity_contact;
    }

    @Override
    protected void setData() {
        userList();
//        Map<String, List<ContactUserBean>> dataset = new HashMap<>();
//        String[] parentList = new String[]{"财务部", "审计部", "市场部","营销部","步步高"};
//        List<ContactUserBean> 财务部 = new ArrayList<>();
//        List<ContactUserBean> 审计部 = new ArrayList<>();
//        List<ContactUserBean> 市场部 = new ArrayList<>();
//        List<ContactUserBean> 营销部 = new ArrayList<>();
//        List<ContactUserBean> 步步高 = new ArrayList<>();
//
//        财务部.add(new ContactUserBean(parentList[0] + "-" + "first",false));
//        财务部.add(new ContactUserBean(parentList[0] + "-" + "second",false));
//        财务部.add(new ContactUserBean(parentList[0] + "-" + "third",true));
//
//        审计部.add(new ContactUserBean(parentList[1] + "-" + "first",true));
//        审计部.add(new ContactUserBean(parentList[1] + "-" + "second",false));
//        审计部.add(new ContactUserBean(parentList[1] + "-" + "third",false));
//
//        市场部.add(new ContactUserBean(parentList[2] + "-" + "first",false));
//        市场部.add(new ContactUserBean(parentList[2] + "-" + "second",false));
//        市场部.add(new ContactUserBean(parentList[2] + "-" + "third",false));
//
//        营销部.add(new ContactUserBean(parentList[3] + "-" + "first",false));
//        营销部.add(new ContactUserBean(parentList[3] + "-" + "second",false));
//        营销部.add(new ContactUserBean(parentList[3] + "-" + "third",true));
//
//        步步高.add(new ContactUserBean(parentList[4] + "-" + "first",false));
//        步步高.add(new ContactUserBean(parentList[4] + "-" + "second",false));
//        步步高.add(new ContactUserBean(parentList[4] + "-" + "third",true));
//
//        dataset.put(parentList[0], 财务部);
//        dataset.put(parentList[1], 审计部);
//        dataset.put(parentList[2], 市场部);
//        dataset.put(parentList[3], 营销部);
//        dataset.put(parentList[4], 步步高);

//        ContactExpandableListViewAdapter myExpandableListViewAdapter = new ContactExpandableListViewAdapter(this,dataset,parentList);
//        expandablelistview.setAdapter(myExpandableListViewAdapter);
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
        switch (v.getId()){
            case R.id.iv_back:
            finish();
                break;
            case R.id.tv_send:

                break;
        }
    }

    void userList(){
        UserNetWork.searchUserList(SharedPreferencesUtil.getMsg("uid"), new Subscriber<UserList>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(UserList userList) {
                if (userList.getReturn_code().equals("SUCCESS")) {
                    List<UserList.ReturnBodyBean> return_body = userList.getReturn_body();

                    parentList=new String[return_body.size()];
                    dataset=new HashMap<String, List<UserList.ReturnBodyBean>>();
                    list=new ArrayList<UserList.ReturnBodyBean>();
                    for (int i = 0; i < return_body.size(); i++) {
                        bean=new UserList.ReturnBodyBean();
//                        parentList[i]=return_body.get(i).getDepartment_name();
                        bean.setD_id(return_body.get(i).getD_id());
                        bean.setDepartment_name(return_body.get(i).getDepartment_name());
                        bean.setStaff(return_body.get(i).getStaff());
//                        staffBean= (UserList.ReturnBodyBean.StaffBean) bean.getStaff();
                        parentList[i]=bean.getDepartment_name();
                        list.add(bean);
                    }
                    for (int i = 0; i < parentList.length; i++) {
                        dataset.put(parentList[i],list);
                    }
                    handler.sendEmptyMessage(SUCCESS);
                }
            }
        });
    }
}
