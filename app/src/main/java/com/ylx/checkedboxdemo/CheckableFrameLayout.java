package com.ylx.checkedboxdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;

public class CheckableFrameLayout extends FrameLayout implements Checkable {

	/**
	 * 添加数据改变监听
	 */
	private OnCheckedChangeListener mOnCheckedChangeListener;

	public CheckableFrameLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	private boolean mChecked = false;

	@Override
	public void toggle() {
		setChecked(!mChecked);
	}

	@Override
	public boolean isChecked() {
		return mChecked;
	}

	@Override
	public void setChecked(boolean checked) {
		if (mChecked != checked) {
			mChecked = checked;
			refreshDrawableState();
			for (int i = 0, len = getChildCount(); i < len; i++) {
				View child = getChildAt(i);
				if (child instanceof Checkable) {
					((Checkable) child).setChecked(checked);

					if (mOnCheckedChangeListener != null) {
						mOnCheckedChangeListener.onCheckedChanged(this,isChecked());
					}
				}
			}
		}
	}

	public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
		mOnCheckedChangeListener = listener;
	}

	public static interface OnCheckedChangeListener {
		void onCheckedChanged(CheckableFrameLayout myCheckedTextView,
							  boolean isChecked);
	}

}
