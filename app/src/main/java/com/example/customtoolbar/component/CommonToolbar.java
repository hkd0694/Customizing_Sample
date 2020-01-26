package com.example.customtoolbar.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;

import com.example.customtoolbar.R;

public class CommonToolbar extends FrameLayout {

    private View vg_container;

    private TextView tv_title;

    private ImageView iv_left;
    private View v_left;
    private ImageView iv_right;
    private View v_right;

    private TextView tv_left;
    private TextView tv_right;

    //frameLayout
    private ViewGroup vg_left;
    private ViewGroup vg_right;

    private View.OnClickListener onLeftClickListener;
    private View.OnClickListener onRightClickListener;

    public CommonToolbar(Context context) {
        super(context);
        init(context, null);
    }

    public CommonToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CommonToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public CommonToolbar(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(@NonNull Context context, AttributeSet attrs) {
        View.inflate(context, R.layout.common_toolbar_main, this);

        vg_container = findViewById(R.id.vg_container);

        tv_title = findViewById(R.id.tv_title);

        iv_left = findViewById(R.id.iv_left);
        v_left = findViewById(R.id.v_left);
        iv_right = findViewById(R.id.iv_right);
        v_right = findViewById(R.id.v_right);

        tv_left = findViewById(R.id.tv_left);
        tv_right = findViewById(R.id.tv_right);

        //frameLayout
        vg_left = findViewById(R.id.vg_left);
        vg_right = findViewById(R.id.vg_right);

        if (attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CommonToolbar, 0, 0);

            try {
                setOverlayIndicator(a.getBoolean(R.styleable.CommonToolbar_toolbarOverlayIndicator, false));

                if (a.hasValue(R.styleable.CommonToolbar_toolbarTitle)) {
                    setTitle(a.getString(R.styleable.CommonToolbar_toolbarTitle));
                }

                if (a.hasValue(R.styleable.CommonToolbar_toolbarLeftIcon)) {
                    setLeftIcon(a.getResourceId(R.styleable.CommonToolbar_toolbarLeftIcon, 0));
                }

                if (a.hasValue(R.styleable.CommonToolbar_toolbarLeftIconWidth)) {
                    setLeftIconWidth(a.getDimensionPixelSize(R.styleable.CommonToolbar_toolbarLeftIconWidth, 0));
                }

                if (a.hasValue(R.styleable.CommonToolbar_toolbarLeftIconHeight)) {
                    setLeftIconHeight(a.getDimensionPixelSize(R.styleable.CommonToolbar_toolbarLeftIconHeight, 0));
                }

                if (a.hasValue(R.styleable.CommonToolbar_toolbarLeftText)) {
                    setLeftText(a.getString(R.styleable.CommonToolbar_toolbarLeftText));
                }

                if (a.hasValue(R.styleable.CommonToolbar_toolbarLeftColor)) {
                    setLeftTextColor(a.getColor(R.styleable.CommonToolbar_toolbarLeftColor, 0));
                }

                if (a.hasValue(R.styleable.CommonToolbar_toolbarLeftLayout)) {
                    setLeftLayout(a.getResourceId(R.styleable.CommonToolbar_toolbarLeftLayout, 0));
                }

                if (a.hasValue(R.styleable.CommonToolbar_toolbarRightIcon)) {
                    setRightIcon(a.getResourceId(R.styleable.CommonToolbar_toolbarRightIcon, 0));
                }

                if (a.hasValue(R.styleable.CommonToolbar_toolbarRightIconWidth)) {
                    setRightIconWidth(a.getDimensionPixelSize(R.styleable.CommonToolbar_toolbarRightIconWidth, 0));
                }

                if (a.hasValue(R.styleable.CommonToolbar_toolbarRightIconHeight)) {
                    setRightIconHeight(a.getDimensionPixelSize(R.styleable.CommonToolbar_toolbarRightIconHeight, 0));
                }

                if (a.hasValue(R.styleable.CommonToolbar_toolbarRightText)) {
                    setRightText(a.getString(R.styleable.CommonToolbar_toolbarRightText));
                }

                if (a.hasValue(R.styleable.CommonToolbar_toolbarRightColor)) {
                    setRightTextColor(a.getColor(R.styleable.CommonToolbar_toolbarRightColor, 0));
                }

                if (a.hasValue(R.styleable.CommonToolbar_toolbarRightLayout)) {
                    setRightLayout(a.getResourceId(R.styleable.CommonToolbar_toolbarRightLayout, 0));
                }

            } catch (Exception e) {

            } finally {
                a.recycle();
            }
        }
    }

    public void setOverlayIndicator(boolean overlay) {
        ViewGroup.MarginLayoutParams lp = (MarginLayoutParams) vg_container.getLayoutParams();
        if (overlay) {
            //lp.topMargin = (int) getResources().getDimension(R.dimen.indicator_height);
        } else {
            lp.topMargin = 0;
        }
    }

    public void setTitle(CharSequence title) {
//        if (TextUtils.isEmpty(title)) {
//            tv_title.setVisibility(GONE);
//        } else {
//            tv_title.setVisibility(VISIBLE);
//        }

        tv_title.setText(title);
    }

    public CharSequence getTitle() {
        return tv_title.getText();
    }

    public void setLeftIcon(@DrawableRes int resourceId) {
        v_left.setVisibility(VISIBLE);

        iv_left.setVisibility(VISIBLE);
        iv_left.setBackgroundResource(resourceId);
    }

    public void setLeftEnabled(boolean enabled) {
        v_left.setEnabled(enabled);
        tv_left.setEnabled(enabled);
    }

    public void setLeftIconWidth(int width) {
        iv_left.getLayoutParams().width = width;
    }

    public void setLeftIconHeight(int height) {
        iv_left.getLayoutParams().height = height;
    }

    public void setLeftText(CharSequence text) {
        if (TextUtils.isEmpty(text)) {
            tv_left.setVisibility(GONE);
        } else {
            tv_left.setVisibility(VISIBLE);
            tv_left.setText(text);
        }
    }

    public void setLeftTextColor(@ColorInt int color) {
        tv_left.setTextColor(color);
    }

    public void setLeftLayout(@LayoutRes int resourceId) {
        View.inflate(getContext(), resourceId, vg_left);
    }

    public void setRightIcon(@DrawableRes int resourceId) {
        v_right.setVisibility(VISIBLE);
        iv_right.setVisibility(VISIBLE);
        iv_right.setBackgroundResource(resourceId);
    }

    public void setRightEnabled(boolean enabled) {
        v_right.setEnabled(enabled);
        tv_right.setEnabled(enabled);
    }

    public void setRightIconWidth(int width) {
        iv_right.getLayoutParams().width = width;
    }

    public void setRightIconHeight(int height) {
        iv_right.getLayoutParams().height = height;
    }

    public void setRightText(CharSequence text) {
        if (TextUtils.isEmpty(text)) {
            tv_right.setVisibility(GONE);
        } else {
            tv_right.setVisibility(VISIBLE);
            tv_right.setText(text);
        }
    }

    public void setRightTextColor(@ColorInt int color) {
        tv_right.setTextColor(color);
    }

    public void setRightLayout(@LayoutRes int resourceId) {
        View.inflate(getContext(), resourceId, vg_right);
    }

    public OnClickListener getOnLeftClickListener() {
        return onLeftClickListener;
    }

    public void setOnLeftClickListener(OnClickListener onLeftClickListener) {
        this.onLeftClickListener = onLeftClickListener;

        v_left.setOnClickListener(onLeftClickListener);
        tv_left.setOnClickListener(onLeftClickListener);
    }

    public OnClickListener getOnRightClickListener() {
        return onRightClickListener;
    }

    public void setOnRightClickListener(OnClickListener onRightClickListener) {
        this.onRightClickListener = onRightClickListener;

        v_right.setOnClickListener(onRightClickListener);
        tv_right.setOnClickListener(onRightClickListener);
    }
}
