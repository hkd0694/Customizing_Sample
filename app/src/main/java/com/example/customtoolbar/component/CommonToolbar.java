package com.example.customtoolbar.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.example.customtoolbar.R;

public class CommonToolbar extends FrameLayout {

    public CommonToolbar(Context context) {
        super(context);
        init(context, null);
    }

    public CommonToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        View.inflate(context, R.layout.common_toolbar_main, this);
    }

}
