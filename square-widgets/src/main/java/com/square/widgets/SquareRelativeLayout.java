package com.square.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class SquareRelativeLayout extends RelativeLayout {

    private float relRatio = 1f;
    private static final String keyRelRatio = "relRatio";

    public SquareRelativeLayout(Context context) {
        super(context);
        setAttributes(context, null);
    }

    public SquareRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setAttributes(context, attrs);
    }

    public SquareRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setAttributes(context, attrs);
    }

    private void setAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) return;
        String packageName = "http://schemas.android.com/apk/res-auto";
        relRatio = attrs.getAttributeFloatValue(packageName, keyRelRatio, 1f);
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
        return (int) (relRatio * (float) side);
    }

    public float getRelRatio() {
        return relRatio;
    }

    public void setRelRatio(float relRatio) {
        this.relRatio = relRatio;
        this.invalidate();
    }
}
