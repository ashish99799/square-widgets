package com.square.widgets;

import android.content.Context;
import android.util.AttributeSet;

import androidx.cardview.widget.CardView;

public class SquareCardView extends CardView {

    private float cardRatio = 1f;
    private static final String keyCardRatio = "cardRatio";

    public SquareCardView(Context context) {
        super(context);
        setAttributes(context, null);
    }

    public SquareCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setAttributes(context, attrs);
    }

    public SquareCardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setAttributes(context, attrs);
    }

    private void setAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) return;
        String packageName = "http://schemas.android.com/apk/res-auto";
        cardRatio = attrs.getAttributeFloatValue(packageName, keyCardRatio, 1f);
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
        return (int) (cardRatio * (float) side);
    }

    public float getCardRatio() {
        return cardRatio;
    }

    public void setCardRatio(float cardRatio) {
        this.cardRatio = cardRatio;
        this.invalidate();
    }
}
