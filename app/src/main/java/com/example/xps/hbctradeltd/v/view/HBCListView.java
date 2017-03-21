package com.example.xps.hbctradeltd.v.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by XPS on 2017/3/18.
 */

public class HBCListView extends ListView {
    public HBCListView(Context context) {
        super(context);
    }

    public HBCListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int temp=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        this.setFocusable(true);
        super.onMeasure(widthMeasureSpec, temp);
    }
}
