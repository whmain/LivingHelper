package com.ahern.livinghelper.common.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * @auther: WangHao on 2017/9/11 14:56
 * @email：Ahern.h.wang@emore-smart.com
 */

public class AdaptHeightRecyclerView extends RecyclerView {
    public AdaptHeightRecyclerView(Context context) {
        super(context);
    }

    public AdaptHeightRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AdaptHeightRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthSpec, expandSpec);
    }
}
