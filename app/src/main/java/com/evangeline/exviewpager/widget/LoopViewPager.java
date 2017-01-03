package com.evangeline.exviewpager.widget;

import java.lang.reflect.Field;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;


/**
 * Auto Scroll View Pager
 * <ul>
 * <strong>Basic Setting and Usage</strong>
 * <li>{@link #startAutoScroll()} start auto scroll, or
 * {@link #startAutoScroll(int)} start auto scroll delayed</li>
 * <li>{@link #stopAutoScroll()} stop auto scroll</li>
 * <li>{@link #setInterval(long)} set auto scroll time in milliseconds, default
 * is {@link #DEFAULT_INTERVAL}</li>
 * </ul>
 * <ul>
 * <strong>Advanced Settings and Usage</strong>
 * <li>{@link #setDirection(int)} set auto scroll direction</li>
 * <li>{@link #setCycle(boolean)} set whether automatic cycle when auto scroll
 * reaching the last or first item, default is true</li>
 * <li>{@link #setSlideBorderMode(int)} set how to process when sliding at the
 * last or first item</li>
 * <li>{@link #setStopScrollWhenTouch(boolean)} set whether stop auto scroll
 * when touching, default is true</li>
 * </ul>
 * 
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2013-12-30
 */
public class LoopViewPager extends ViewPager {


    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    /** do nothing when sliding at the last or first item **/
    public static final int SLIDE_BORDER_MODE_NONE = 0;
    /** cycle when sliding at the last or first item **/
    public static final int SLIDE_BORDER_MODE_CYCLE = 1;
    /** deliver event to parent when sliding at the last or first item **/
    public static final int SLIDE_BORDER_MODE_TO_PARENT = 2;

    /** auto scroll direction, default is {@link #RIGHT} **/
    private int direction = RIGHT;
    /**
     * whether automatic cycle when auto scroll reaching the last or first item,
     * default is true
     **/
    private boolean isCycle = true;
    /** whether stop auto scroll when touching, default is true **/
    private boolean stopScrollWhenTouch = true;
    /**
     * how to process when sliding at the last or first item, default is
     * {@link #SLIDE_BORDER_MODE_NONE}
     **/
    private int slideBorderMode = SLIDE_BORDER_MODE_NONE;
  

    private float touchX = 0f, downX = 0f;

    public static final int SCROLL_WHAT = 0;

    public LoopViewPager(Context paramContext) {
        super(paramContext);
      
    }

    public LoopViewPager(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
       
    }

 
    private boolean isBorderAnimation  =true;
    public void scrollOnce() {
        PagerAdapter adapter = getAdapter();
        int currentItem = getCurrentItem();
        int totalCount;
        if (adapter == null || (totalCount = adapter.getCount()) <= 1) {
            return;
        }

        int nextItem = (direction == LEFT) ? --currentItem : ++currentItem;
        if (nextItem < 0) {
            if (isCycle) {
                setCurrentItem(totalCount - 1,isBorderAnimation);
            }
        } else if (nextItem == totalCount) {
            if (isCycle) {
                setCurrentItem(0, isBorderAnimation);
            }
        } else {
            setCurrentItem(nextItem, true);
        }
    }

    /**
     * <ul>
     * if stopScrollWhenTouch is true
     * <li>if event is down, stop auto scroll.</li>
     * <li>if event is up, start auto scroll again.</li>
     * </ul>
     */
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        int action = MotionEventCompat.getActionMasked(ev);
//
//        if (slideBorderMode == SLIDE_BORDER_MODE_TO_PARENT
//                || slideBorderMode == SLIDE_BORDER_MODE_CYCLE) {
//            touchX = ev.getX();
//            if (ev.getAction() == MotionEvent.ACTION_DOWN) {
//                downX = touchX;
//            }
//            int currentItem = getCurrentItem();
//            PagerAdapter adapter = getAdapter();
//            int pageCount = adapter == null ? 0 : adapter.getCount();
//            /**
//             * current index is first one and slide to right or current index is
//             * last one and slide to left.<br/>
//             * if slide border mode is to parent, then
//             * requestDisallowInterceptTouchEvent false.<br/>
//             * else scroll to last one when current item is first one, scroll to
//             * first one when current item is last one.
//             */
//            if ((currentItem == 0 && downX <= touchX)
//                    || (currentItem == pageCount - 1 && downX >= touchX)) {
//                if (slideBorderMode == SLIDE_BORDER_MODE_TO_PARENT) {
//                    getParent().requestDisallowInterceptTouchEvent(false);
//                } else {
//                    if (pageCount > 1) {
//                        setCurrentItem(pageCount - currentItem - 1, isBorderAnimation);
//                    }
//                    getParent().requestDisallowInterceptTouchEvent(true);
//                }
//                return super.dispatchTouchEvent(ev);    
//            }
//        }
//        getParent().requestDisallowInterceptTouchEvent(true);
//        return super.dispatchTouchEvent(ev);
//    }



    /**
     * get auto scroll direction
     * 
     * @return {@link #LEFT} or {@link #RIGHT}, default is {@link #RIGHT}
     */
    public int getDirection() {
        return (direction == LEFT) ? LEFT : RIGHT;
    }

    /**
     * set auto scroll direction
     * 
     * @param direction
     *            {@link #LEFT} or {@link #RIGHT}, default is {@link #RIGHT}
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * whether automatic cycle when auto scroll reaching the last or first item,
     * default is true
     * 
     * @return the isCycle
     */
    public boolean isCycle() {
        return isCycle;
    }

    /**
     * set whether automatic cycle when auto scroll reaching the last or first
     * item, default is true
     * 
     * @param isCycle
     *            the isCycle to set
     */
    public void setCycle(boolean isCycle) {
        this.isCycle = isCycle;
    }

    /**
     * whether stop auto scroll when touching, default is true
     * 
     * @return the stopScrollWhenTouch
     */
    public boolean isStopScrollWhenTouch() {
        return stopScrollWhenTouch;
    }

    /**
     * set whether stop auto scroll when touching, default is true
     * 
     * @param stopScrollWhenTouch
     */
    public void setStopScrollWhenTouch(boolean stopScrollWhenTouch) {
        this.stopScrollWhenTouch = stopScrollWhenTouch;
    }

    /**
     * get how to process when sliding at the last or first item
     * 
     * @return the slideBorderMode {@link #SLIDE_BORDER_MODE_NONE},
     *         {@link #SLIDE_BORDER_MODE_TO_PARENT},
     *         {@link #SLIDE_BORDER_MODE_CYCLE}, default is
     *         {@link #SLIDE_BORDER_MODE_NONE}
     */
    public int getSlideBorderMode() {
        return slideBorderMode;
    }

    /**
     * set how to process when sliding at the last or first item
     * 
     * @param slideBorderMode
     *            {@link #SLIDE_BORDER_MODE_NONE},
     *            {@link #SLIDE_BORDER_MODE_TO_PARENT},
     *            {@link #SLIDE_BORDER_MODE_CYCLE}, default is
     *            {@link #SLIDE_BORDER_MODE_NONE}
     */
    public void setSlideBorderMode(int slideBorderMode) {
        this.slideBorderMode = slideBorderMode;
    }

    /**
     * whether animating when auto scroll at the last or first item, default is
     * true
     * 
     * @return
     */
    public boolean isBorderAnimation() {
        return isBorderAnimation;
    }

    /**
     * set whether animating when auto scroll at the last or first item, default
     * is true
     * 
     * @param isBorderAnimation
     */
    public void setBorderAnimation(boolean isBorderAnimation) {
        this.isBorderAnimation = isBorderAnimation;
    }
}
