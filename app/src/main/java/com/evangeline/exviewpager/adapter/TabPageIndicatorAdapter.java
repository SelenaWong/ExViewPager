
/**   
 * @Title:
 * @Package: com.app.adapter 
 * @Description: TODO
 * @author lenovo  
 * @date 2016年12月30日 下午13:53:35
 * @version 1.3.1 
 */


package com.evangeline.exviewpager.adapter;

import java.util.ArrayList;
import java.util.List;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import com.evangeline.exviewpager.entity.Film;
import com.evangeline.exviewpager.fragment.ItemFragment;

/** 
 * @Description ViewPager 页面适配器
 * @author Selena Wong
 * @date 2016年6月8日 下午3:35:35 
 * @version V1.3.1
 */

public class TabPageIndicatorAdapter extends FragmentStatePagerAdapter {
	
	private List<ItemFragment> mList= new ArrayList<ItemFragment>();
	private List<Film> mAisleList =new ArrayList<Film>();
	private int mTotalNum =0;
	private int pageCount=10;

	
    public TabPageIndicatorAdapter(FragmentManager fm,List<ItemFragment> list,List<Film> aisleList) {
        super(fm);
        this.mList = list;
        this.mAisleList = aisleList;
        mTotalNum = this.mAisleList.size();
    }
    
    @Override
    public Object instantiateItem(ViewGroup arg0, int arg1) {
    	// TODO Auto-generated method stub
    	Log.i("tag", "instantiateItem fragment="+arg1);
    	ItemFragment itFragment = (ItemFragment)super.instantiateItem(arg0, arg1);
    	itFragment= mList.get(arg1);
    	Log.i("tag", "after instantiateItem");
    	return itFragment;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    	// TODO Auto-generated method stub
    	super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
    	return mList.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
    	// TODO Auto-generated method stub
    	return PagerAdapter.POSITION_NONE;
    }
    
    @Override
    public CharSequence getPageTitle(int position) {
    	StringBuilder builder = new StringBuilder();
    	int posNum = position+1;
    	builder.append("第"+posNum+"页");
    	return builder.toString();
    }

    @Override
    public int getCount() {
    	if(mList==null){
    		return 0;
    	}
        return mList.size();
    }
    
    @Override
    public Parcelable saveState()
    {
        return null;
    }
}
