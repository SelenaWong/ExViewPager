package com.evangeline.exviewpager.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
/**
 * 自定义GridView，解决在ScrollView嵌套GridView时，出现的GridView不能完全显示的问题。
 * @author wangxy
 *
 */
public class CustomGridView extends GridView {

	public CustomGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	public CustomGridView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public CustomGridView(Context context,AttributeSet attrs ,int defStyle ) {
		super(context,attrs,defStyle);
		// TODO Auto-generated constructor stub
	}
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    	// TODO Auto-generated method stub
    	int expandSpec =MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
    	super.onMeasure(widthMeasureSpec, expandSpec);
    }

}
