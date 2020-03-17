package com.square.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class SquareView extends View {

    private float viewRatio = 1f;
    private static final String keyViewRatio = "viewRatio";

    public SquareView(Context context) {
        super(context);
        setAttributes(context, null);
    }

    public SquareView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setAttributes(context, attrs);
    }

    public SquareView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setAttributes(context, attrs);
    }

    private void setAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) return;
        String packageName = "http://schemas.android.com/apk/res-auto";
        viewRatio = attrs.getAttributeFloatValue(packageName, keyViewRatio, 1f);
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
        return (int) (viewRatio * (float) side);
    }

    public float getViewRatio() {
        return viewRatio;
    }

    public void setViewRatio(float viewRatio) {
        this.viewRatio = viewRatio;
        this.invalidate();
    }
}
