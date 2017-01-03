
/**   
 * @Title: WrapContentViewPager.java 
 * @Package: com.app.widget 
 * @Description: TODO
 * @author lenovo  
 * @date 2016年5月12日 下午3:36:38 
 * @version 1.3.1 
 */


package com.evangeline.exviewpager.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

/** 
 * @Description 
 * @author lenovo
 * @date 2016年5月12日 下午3:36:38 
 * @version V1.3.1
 */

public class WrapContentViewPager extends ViewPager {

	public WrapContentViewPager(Context context) {
		super(context);
	}
	
	public WrapContentViewPager(Context context, AttributeSet attr) {
		super(context, attr);
	}

	@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int height = 0;
        for(int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            int h = child.getMeasuredHeight();
            if(h > height) height = h;
        }
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private int measureHeight(int measureSpec, View view) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            // set the height from the base view if available
            if (view != null) {
                result = view.getMeasuredHeight();
            }
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }
}
