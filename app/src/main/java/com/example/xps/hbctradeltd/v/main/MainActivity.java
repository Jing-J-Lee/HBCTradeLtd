package com.example.xps.hbctradeltd.v.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;

import com.example.xps.hbctradeltd.R;
import com.example.xps.hbctradeltd.c.UserNetWork;
import com.example.xps.hbctradeltd.d.bean.LoginResp;
import com.example.xps.hbctradeltd.v.folder.FolderActivity;
import com.example.xps.hbctradeltd.v.login.LoginActivity;
import com.example.xps.hbctradeltd.v.user.UserInfoActivity;
import com.example.xps.hbctradeltd.v.utils.SharedPreferencesUtil;
import com.example.xps.hbctradeltd.v.utils.ToastShow;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, SwipeRefreshLayout.OnRefreshListener {
    RecyclerView recyclerView;
    @BindView(R.id.tv_contract_all)
    TextView tvContractAll;
    @BindView(R.id.tv_contract_incompleted)
    TextView tvContractIncompleted;
    @BindView(R.id.tv_contract_completed)
    TextView tvContractCompleted;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.aull_tab)
    AutoLinearLayout aull_tab;

    ContractAdapterMain adapter;
    int lastVisibleItem = 0;
    int firstVisibleItem = 0;
    int mElevation = 5;
    private ViewOutlineProvider mOutlineProviderCircle;

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
                swipeRefreshLayout.setRefreshing(false);
            } else if (msg.what == 0) {
                swipeRefreshLayout.setRefreshing(false);
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mOutlineProviderCircle = new ElevationViewOutlineProvider();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            aull_tab.setOutlineProvider(mOutlineProviderCircle);
            aull_tab.setClipToOutline(true);
            aull_tab.setElevation(mElevation);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        toolbar.setBackgroundColor(getResources().getColor(R.color.toolbarcolor));
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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

        adapter = new ContractAdapterMain(this, list);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setAdapter(adapter);
        //recyclerView.addItemDecoration( new DividerGridItemDecoration(this ));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorScheme(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
                android.R.color.holo_orange_light, android.R.color.holo_red_light);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @SuppressLint("NewApi")
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE//如果当前没有滚动 而且是最后一条
                        && lastVisibleItem + 1 == adapter.getItemCount()) {
                    handler.sendEmptyMessageDelayed(1, 1000);
                } else if (newState == RecyclerView.SCROLL_STATE_IDLE
                        && firstVisibleItem == 0) {
                    aull_tab.setElevation(0);//如果滚动到了第一条取消阴影
                } else {
                    aull_tab.setElevation(mElevation);//否则添加阴影
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                firstVisibleItem = layoutManager.findFirstVisibleItemPosition();
                Log.e("onScrolled", firstVisibleItem + "");
                lastVisibleItem = layoutManager.findLastVisibleItemPosition();
            }
        });

        resetLable();
        tvContractAll.setTextColor(getResources().getColor(R.color.toolbarcolor));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_add) {
            startActivity(new Intent(this, FolderActivity.class));
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_info) {//个人信息
            startActivity(new Intent(this, UserInfoActivity.class));
        } else if (id == R.id.nav_gallery) {//退出登录
            logOut();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @OnClick({R.id.tv_contract_all, R.id.tv_contract_incompleted, R.id.tv_contract_completed})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_contract_all:
                resetLable();
                tvContractAll.setTextColor(getResources().getColor(R.color.toolbarcolor));
                break;
            case R.id.tv_contract_incompleted:
                resetLable();
                tvContractIncompleted.setTextColor(getResources().getColor(R.color.toolbarcolor));
                break;
            case R.id.tv_contract_completed:
                resetLable();
                tvContractCompleted.setTextColor(getResources().getColor(R.color.toolbarcolor));
                break;
        }
    }

    void resetLable() {
        tvContractAll.setTextColor(Color.BLACK);
        tvContractIncompleted.setTextColor(Color.BLACK);
        tvContractCompleted.setTextColor(Color.BLACK);
    }

    @Override
    public void onRefresh() {
        handler.sendEmptyMessageDelayed(0, 3000);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private class ElevationViewOutlineProvider extends ViewOutlineProvider {
        @Override
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(-mElevation, 0, view.getWidth() + mElevation, view.getHeight(), 0);
        }
    }


    void logOut(){
        UserNetWork.doLogout(SharedPreferencesUtil.getMsg("uid"), new Subscriber<LoginResp>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(LoginResp loginResp) {
                if (loginResp.getReturn_code().equals("SUCCESS")) {
                    ToastShow.getInstance(MainActivity.this).toastShow("退出成功");
                    SharedPreferencesUtil.setLogin(false);
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }else {
                    Log.e("ss",loginResp.toString());
                }
            }
        });
    }
}
