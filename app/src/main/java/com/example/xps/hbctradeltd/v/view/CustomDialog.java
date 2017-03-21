package com.example.xps.hbctradeltd.v.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.xps.hbctradeltd.R;
import com.example.xps.hbctradeltd.v.editcontract.EditContractActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class CustomDialog extends Dialog {

    private Button yes;
    private Button no;
    private EditText et_key;
    private EditText et_value;
    private String titleStr;
    private String messageStr;
    private String yesStr, noStr;
    private TextView tv_modify_type, tv_modify_content;
    private onCancelBtclickListener onCancelclickListener;
    private onOkBtOnclickListener onOkBtclickListener;
    Bundle receiveBundle = null;

    public void setNoOnclickListener(String str, onCancelBtclickListener onNoOnclickListener) {
        if (str != null) {
            noStr = str;
        }
        this.onCancelclickListener = onNoOnclickListener;
    }

    public void setYesOnclickListener(String str, onOkBtOnclickListener onYesOnclickListener) {
        if (str != null) {
            yesStr = str;
        }
        this.onOkBtclickListener = onYesOnclickListener;
    }

    public CustomDialog(Context context) {
        super(context, R.style.dialogeditcontract);
        EventBus.getDefault().register(this);
        onCreate(null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_editcontract);
        setCanceledOnTouchOutside(false);
        initView();
        initData();
        initEvent();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReciveDialogEventDialog(Bundle b) {

        if (b.getInt("TO") == EditContractActivity.TO_DIALOG) {
            receiveBundle = b;
            if (b.getInt("FROM_TYPE") == EditContractActivity.FROM_ITEM) {
                et_key.setEnabled(false);
                et_key.setText(b.getString("KEY"));

                et_value.setText(b.getString("VALUE"));
                et_value.setSelection(et_value.getText().length());

                tv_modify_type.setText("编辑条目名称");
                tv_modify_content.setText("编辑条目内容");
            } else if (b.getInt("FROM_TYPE") == EditContractActivity.FROM_LIST) {
                et_key.setEnabled(true);
                et_key.setText(b.getString("KEY"));
                et_key.setSelection(et_key.getText().length());

                et_value.setText(b.getString("VALUE"));
                et_value.setSelection(et_value.getText().length());

                tv_modify_type.setText("编辑条目名称");
                tv_modify_content.setText("编辑条目内容");
            } else if (b.getInt("FROM_TYPE") == EditContractActivity.FROM_ADD) {
                tv_modify_type.setText("添加条目名称");
                tv_modify_content.setText("添加条目内容");
            }
            show();
        }

    }

    private void initEvent() {
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onOkBtclickListener != null) {

                    String modifyKey = et_key.getText().toString().trim();
                    String modifyValue = et_value.getText().toString().trim();

                    if (modifyKey.length() <= 0) {
                        return;
                    }
                    if (modifyValue.length() <= 0) {
                        return;
                    }

                    Bundle bundle = new Bundle();
                    bundle.putInt("TO", EditContractActivity.TO_ACTIVITY);
                    bundle.putString("VALUE", modifyValue);
                    bundle.putString("KEY", modifyKey);
                    bundle.putString("KEY_BEFORECHANGE", receiveBundle.getString("KEY"));
                    bundle.putInt("FROM_TYPE", receiveBundle.getInt("FROM_TYPE"));
                    EventBus.getDefault().post(bundle);
                    et_value.setText(" ");
                    et_key.setText(" ");
                    onOkBtclickListener.onYesClick();

                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onCancelclickListener != null) {
                    et_value.setText(" ");
                    et_key.setText(" ");
                    onCancelclickListener.onNoClick();
                }
            }
        });
    }

    private void initData() {
        if (titleStr != null) {
            et_key.setText(titleStr);
        }
        if (messageStr != null) {
            et_value.setText(messageStr);
        }
        if (yesStr != null) {
            yes.setText(yesStr);
        }
        if (noStr != null) {
            no.setText(noStr);
        }
    }

    private void initView() {
        yes = (Button) findViewById(R.id.yes);
        no = (Button) findViewById(R.id.no);
        et_key = (EditText) findViewById(R.id.title);
        et_value = (EditText) findViewById(R.id.message);
        tv_modify_type = (TextView) findViewById(R.id.tv_modify_type);
        tv_modify_content = (TextView) findViewById(R.id.tv_modify_content);
    }

    public void setTitle(String title) {
        titleStr = title;
    }

    public void setMessage(String message) {
        messageStr = message;
    }

    public interface onOkBtOnclickListener {
        public void onYesClick();
    }

    public interface onCancelBtclickListener {
        public void onNoClick();
    }
}
