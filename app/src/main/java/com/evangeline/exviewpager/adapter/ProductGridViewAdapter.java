package com.evangeline.exviewpager.adapter;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.evangeline.exviewpager.R;
import com.evangeline.exviewpager.entity.Film;
import com.nostra13.universalimageloader.core.ImageLoader;


/**
 * CustomGridViewImageApdater 的适配器
 * 
 * @author wangxy
 *
 */
public class ProductGridViewAdapter extends BaseAdapter {

	private Context mcontext;
	private List<Film> mList = null;
	private LayoutInflater minflater;
	private ImageLoader mImageLoader;
	private int selectedId = -1;
	private int itemIndex=-1;

	public ProductGridViewAdapter(Context context, List<Film> list, int itemIndex) {
		this.mcontext = context;
		minflater = LayoutInflater.from(mcontext);
		mImageLoader = ImageLoader.getInstance();
		mList = list;
		this.itemIndex = itemIndex;
	}

	public void SetSelectedId(int pos) {
		selectedId = pos;
	}

	public boolean getIsSelected(int position) {
		return selectedId == position;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if (null != mList) {
			return mList.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		if (null != mList) {
			return mList.get(position);
		}
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHold viewHold;
		if (convertView == null) {
			viewHold = new ViewHold();
			convertView = minflater.inflate(R.layout.aisle_product_item, null);
			viewHold.mProductRl = (RelativeLayout) convertView.findViewById(R.id.rl_aisleproduct_layout);
			viewHold.mNameTv = (TextView) convertView.findViewById(R.id.tv_aisleproduct_name);
			viewHold.mProductImv = (ImageView) convertView.findViewById(R.id.imv_aisleproduct);
			viewHold.mSoldoutRl = (RelativeLayout) convertView.findViewById(R.id.rl_aisleproduct_soldout);
			convertView.setTag(viewHold);
		} else {
			viewHold = (ViewHold) convertView.getTag();
		}
	
		Film  lai  = mList.get(position);
		boolean blShowBg = false;
		int currentProductId = lai.getProId();
		int number = lai.getProNumber();

		if(number<1){
			  blShowBg=true;
		}
		if(blShowBg){
			viewHold.mProductRl.setVisibility(View.VISIBLE);
			viewHold.mSoldoutRl.setVisibility(View.VISIBLE);
		}else{
			viewHold.mProductRl.setVisibility(View.VISIBLE);
			viewHold.mSoldoutRl.setVisibility(View.GONE);
		}
	
		try{
			    viewHold.mNameTv.setText(lai.getProName());

			   int price = lai.getProPrice();
			   float fPrice=price/100 +  0.01f*(price%100);
					Log.i("TAG", "fPrice="+fPrice);
					String startPrice = Integer.toString(price/100);
					String endPrice = Integer.toString(price%100);
					String sPrice = startPrice+"."+endPrice;

			    mImageLoader.displayImage(
						lai.getProUrl(), viewHold.mProductImv,
						com.evangeline.exviewpager.application.UILApplication.getDisplayImageOptions());

			}catch(Exception ex){
		}
		return convertView;
	}

	private class ViewHold {
		RelativeLayout mProductRl;
		ImageView mProductImv;
		TextView mNameTv;
		RelativeLayout mSoldoutRl;
	}
}
