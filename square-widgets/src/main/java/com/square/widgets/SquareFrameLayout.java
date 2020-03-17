package com.square.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class SquareFrameLayout extends FrameLayout {

    private float frmRatio = 1f;
    private static final String keyFrmRatio = "frmRatio";

    public SquareFrameLayout(Context context) {
        super(context);
        setAttributes(context, null);
    }

    public SquareFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setAttributes(context, attrs);
    }

    public SquareFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setAttributes(context, attrs);
    }

    private void setAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) return;
        String packageName = "http://schemas.android.com/apk/res-auto";
        frmRatio = attrs.getAttributeFloatValue(packageName, keyFrmRatio, 1f);
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
        return (int) (frmRatio * (float) side);
    }

    public float getFrmRatio() {
        return frmRatio;
    }

    public void setFrmRatio(float frmRatio) {
        this.frmRatio = frmRatio;
        this.invalidate();
    }
}
