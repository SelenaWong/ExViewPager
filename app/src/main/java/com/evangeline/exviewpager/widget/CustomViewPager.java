package com.evangeline.exviewpager.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class CustomViewPager extends ViewPager {

	private boolean mIsCanScorll = false;

	public CustomViewPager(Context context) {
		super(context);

		// TODO Auto-generated constructor stub
	}

	public CustomViewPager(Context context, AttributeSet attr) {
		super(context, attr);
	}

	public void SetScroll(boolean isCanScroll) {
		this.mIsCanScorll = isCanScroll;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		// TODO Auto-generated method stub
		if (mIsCanScorll) {
			return super.onInterceptTouchEvent(arg0);
		} else {
			return false;
		}
	}

	@Override
	public void scrollTo(int x, int y) {
		// TODO Auto-generated method stub
		super.scrollTo(x, y);
	}

	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		// TODO Auto-generated method stub
		if (mIsCanScorll) {
			return super.onTouchEvent(arg0);
		} else {
			return false;
		}

	}

	@Override
	public void setCurrentItem(int item) {
		// TODO Auto-generated method stub
		super.setCurrentItem(item);
	}

	@Override
	public void setCurrentItem(int item, boolean smoothScroll) {
		// TODO Auto-generated method stub
		super.setCurrentItem(item, smoothScroll);
	}

	public void Clear() {
		this.removeAllViewsInLayout();
	}

}
