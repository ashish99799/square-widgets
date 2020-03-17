package com.square.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class SquareImageView extends ImageView {

    private float imgRatio = 1f;
    private static final String keyImgRatio = "imgRatio";

    public SquareImageView(Context context) {
        super(context);
        setAttributes(context, null);
    }

    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setAttributes(context, attrs);
    }

    public SquareImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setAttributes(context, attrs);
    }

    private void setAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) return;
        String packageName = "http://schemas.android.com/apk/res-auto";
        imgRatio = attrs.getAttributeFloatValue(packageName, keyImgRatio, 1f);
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
        return (int) (imgRatio * (float) side);
    }

    public float getImgRatio() {
        return imgRatio;
    }

    public void setImgRatio(float imgRatio) {
        this.imgRatio = imgRatio;
        this.invalidate();
    }
}
