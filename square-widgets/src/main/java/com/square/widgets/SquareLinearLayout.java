package com.square.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class SquareLinearLayout extends LinearLayout {

    private float linRatio = 1f;
    private static final String keyLinRatio = "linRatio";

    public SquareLinearLayout(Context context) {
        super(context);
        setAttributes(context, null);
    }

    public SquareLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setAttributes(context, attrs);
    }

    public SquareLinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setAttributes(context, attrs);
    }

    private void setAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) return;
        String packageName = "http://schemas.android.com/apk/res-auto";
        linRatio = attrs.getAttributeFloatValue(packageName, keyLinRatio, 1f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        int calculatedHeight = calculateHeightByRatio(width);

        if (calculatedHeight != height) {
            setMeasuredDimension(width, calculatedHeight);
        }

    }

    private int calculateHeightByRatio(int side) {
        return (int) (linRatio * (float) side);
    }

    public float getLinRatio() {
        return linRatio;
    }

    public void setLinRatio(float linRatio) {
        this.linRatio = linRatio;
        this.invalidate();
    }
}
