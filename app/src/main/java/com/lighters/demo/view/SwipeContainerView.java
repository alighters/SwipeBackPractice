package com.lighters.demo.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by david on 15-11-27.
 */
public class SwipeContainerView extends FrameLayout {

    private View mChildView;

    private float mActionDownX;

    public SwipeContainerView(Context context) {
        this(context, null);
    }

    public SwipeContainerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SwipeContainerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mActionDownX = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = event.getX() - mActionDownX;
                getChildView().offsetLeftAndRight((int) dx);
                Rect rect = new Rect(0, 0, getChildView().getLeft(), getChildView().getHeight());
                invalidate(rect);
                break;
            case MotionEvent.ACTION_CANCEL:
                break;

        }
        return true;
    }


    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        boolean result = super.drawChild(canvas, child, drawingTime);
//        if (getChildView() != null && getChildView().getLeft() > 0) {
//            canvas.clipRect(0, 0, getChildView().getLeft(), getChildView().getHeight());
//            canvas.drawColor(Color.TRANSPARENT);
//        }
//        if (getChildView().getLeft() > 0 && getChildView().getLeft() >= getChildView().getWidth() + getChildView().getPaddingLeft() + getChildView().getPaddingBottom()) {
//            Context context = getContext();
//            if (context != null && context instanceof Activity) {
//                ((Activity) context).finish();
//            }
//        }
        return result;
    }

    private View getChildView() {
        if (mChildView == null) {
            mChildView = getChildAt(0);
        }
        return mChildView;
    }


}
