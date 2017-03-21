package com.example.xps.hbctradeltd.v.contact;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xps.hbctradeltd.R;
import com.example.xps.hbctradeltd.d.bean.ContactUserBean;
import com.jude.utils.JUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ContactExpandableListViewAdapter extends BaseExpandableListAdapter {
    Map<String, List<ContactUserBean>> parentDataset = new HashMap<>();
    Context context;
    private String[] parentList;

    public ContactExpandableListViewAdapter(Context context, Map<String, List<ContactUserBean>> dataset, String[] parentList) {
        this.context = context;
        this.parentDataset = dataset;
        this.parentList = parentList;
    }

    @Override
    public Object getChild(int parentPos, int childPos) {
        return parentDataset.get(parentList[parentPos]).get(childPos);
    }

    @Override
    public int getGroupCount() {
        return parentDataset.size();
    }

    @Override
    public int getChildrenCount(int parentPos) {
        return parentDataset.get(parentList[parentPos]).size();
    }

    @Override
    public Object getGroup(int parentPos) {
        return parentDataset.get(parentList[parentPos]);
    }

    @Override
    public long getGroupId(int parentPos) {
        return parentPos;
    }

    @Override
    public long getChildId(int parentPos, int childPos) {
        return childPos;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int parentPos, boolean b, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater =
                    (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.expand_item_parent, null);
        }

        view.setTag(R.layout.expand_item_parent, parentPos);
        view.setTag(R.layout.expand_item_child, -1);
        TextView text = (TextView) view.findViewById(R.id.tv_parent_title);
        ImageView iv_arrow = (ImageView) view.findViewById(R.id.iv_arrow);
        text.setText(parentList[parentPos]);

        if (!b)
            iv_arrow.setImageResource(R.drawable.arrow_down);
        else
            iv_arrow.setImageResource(R.drawable.arrow_up);

        return view;
    }

    @Override
    public View getChildView(int parentPos, int childPos, boolean b, View view, ViewGroup viewGroup) {

        List<ContactUserBean> childs = parentDataset.get(parentList[parentPos]);
        final ContactUserBean contactUserBean = childs.get(childPos);

        if (view == null) {
            LayoutInflater inflater =
                    (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.expand_item_child, null);
        }
        view.setTag(R.layout.expand_item_parent, parentPos);
        view.setTag(R.layout.expand_item_child, childPos);
        TextView text = (TextView) view.findViewById(R.id.child_title);

        final CheckBox checkBox = (CheckBox) view.findViewById(R.id.cb_select);
        checkBox.setChecked(contactUserBean.isChecked());

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactUserBean.setChecked(checkBox.isChecked());
            }
        });

        text.setText(childs.get(childPos).getUserId());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
