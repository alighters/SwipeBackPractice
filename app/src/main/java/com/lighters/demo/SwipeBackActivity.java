package com.lighters.demo;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.lighters.demo.view.SwipeContainerView;

/**
 * Created by david on 15-11-27.
 */
public class SwipeBackActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().getDecorView().setBackgroundDrawable(null);
        setContentView(R.layout.activity_swipe_back);

    }



    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        ViewGroup decorView = (ViewGroup) getWindow().getDecorView();

        View childView = decorView.getChildAt(0);

        TypedArray a = getTheme().obtainStyledAttributes(new int[]{
                android.R.attr.windowBackground
        });
        int background = a.getResourceId(0, 0);
        a.recycle();
        childView.setBackgroundResource(background);

        decorView.removeView(childView);

        SwipeContainerView containerView = new SwipeContainerView(this);
        containerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        containerView.addView(childView);

        decorView.addView(containerView);


    }
}
