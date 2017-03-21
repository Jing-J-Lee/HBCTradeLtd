package com.example.xps.hbctradeltd.v.editcontract;

import android.content.Context;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.xps.hbctradeltd.R;
import com.example.xps.hbctradeltd.d.bean.ContrackItem;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContractItemAdapter extends BaseAdapter {

    private List<ContrackItem> list = new ArrayList<>();
    private Context context;
    ScaleAnimation scaleInAnimation = null;

    public ContractItemAdapter(Context context, List<ContrackItem> list) {
        this.context = context;
        this.list = list;
        scaleInAnimation = new ScaleAnimation(0f, 1f, 0f, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleInAnimation.setDuration(500);
        scaleInAnimation.setInterpolator(new FastOutSlowInInterpolator());
    }

    public void putItems(List<ContrackItem> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void putItem(ContrackItem item) {
        this.list.add(item);
        notifyDataSetChanged();
    }

    public List<ContrackItem> getAdapterData() {
        return list;
    }

    @Override
    public int getCount() {
        if (list != null && list.size() > 0) {
            return list.size();
        }
        return 0;
    }

    void visibleCb(boolean visible) {
        for (ContrackItem ci : list) {
            ci.setDeleteCheckBoxVisible(visible);
        }
        notifyDataSetChanged();
    }

    void deleteItem() {
        Iterator iterator = list.listIterator();
        while (iterator.hasNext()) {
            ContrackItem c = (ContrackItem) iterator.next();
            if (c.isDeleteCbChecked()) {
                iterator.remove();
            }
        }

        while (iterator.hasNext()) {
            ContrackItem c = (ContrackItem) iterator.next();
            c.setDeleteCbChecked(false);
        }
        notifyDataSetChanged();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private MyViewHolder viewHolder;

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final ContrackItem item = list.get(i);
        if (view == null) {
            viewHolder = new MyViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.item_editcontract, null);
            viewHolder.tv_conType = (TextView) view.findViewById(R.id.tv_conType);
            viewHolder.tv_content = (TextView) view.findViewById(R.id.tv_content);
            viewHolder.item_ll = (AutoLinearLayout) view.findViewById(R.id.item_ll);
            viewHolder.checkBox = (CheckBox) view.findViewById(R.id.cb_delected);
            view.setTag(viewHolder);
            AutoUtils.autoSize(view);
        } else {
            viewHolder = (MyViewHolder) view.getTag();
        }

        viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    item.setDeleteCbChecked(true);
                else
                    item.setDeleteCbChecked(false);
            }
        });

        if (item.isDeleteCbChecked()) {
            viewHolder.checkBox.setChecked(true);
        } else {
            viewHolder.checkBox.setChecked(false);

        }

        if (item.isDeleteCbVisable()) {
            viewHolder.checkBox.setVisibility(View.VISIBLE);
            viewHolder.checkBox.startAnimation(scaleInAnimation);
        } else {
            viewHolder.checkBox.setVisibility(View.INVISIBLE);
        }

        viewHolder.tv_conType.setText(item.getKey());
        viewHolder.tv_content.setText(item.getValue());

        return view;
    }

    class MyViewHolder {
        TextView tv_conType, tv_content;
        AutoLinearLayout item_ll;
        CheckBox checkBox;
    }
}
