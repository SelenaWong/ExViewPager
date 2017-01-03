package com.evangeline.exviewpager.fragment;

import java.util.ArrayList;
import java.util.List;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.evangeline.exviewpager.R;
import com.evangeline.exviewpager.adapter.ProductGridViewAdapter;
import com.evangeline.exviewpager.application.CustomApplication;
import com.evangeline.exviewpager.entity.Film;
import com.evangeline.exviewpager.event.FilmEvent;
import com.evangeline.exviewpager.widget.CustomGridView;

import de.greenrobot.event.EventBus;


public class ItemFragment extends Fragment implements OnItemClickListener{

	private CustomGridView mGridView;
	private ProductGridViewAdapter mAdapter;
	private List<Film> mProductList= new ArrayList<Film>();
	private int itemIndex=-1;

	/***
	 * 
	 * @Description 设置参数
	 * @author Selena Wong
	 * @param bundle
	 */
	public  void SetParams( Bundle bundle ){
		try{
			mProductList= (List<Film>) bundle.getSerializable("listObj");
			itemIndex = bundle.getInt("itemIndex");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	/***
	 * 
	 * @Description 更新界面
	 * @author Selena Wong
	 * @param productList
	 */
	public void UpdateView(List<Film> productList ){
		try{
			this.mProductList = productList;
			mAdapter.notifyDataSetChanged();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View contextView = inflater.inflate(R.layout.fragment_item, container, false);
		mGridView = (CustomGridView) contextView.findViewById(R.id.gdview_fragment_item);
		mAdapter = new ProductGridViewAdapter( getActivity(),mProductList,itemIndex);
		mGridView.setAdapter(mAdapter);
		mGridView.setOnItemClickListener(this);
		Log.i("itemFragment","onCreateView frament="+itemIndex);
		return contextView;	
   }


	/**
	 * Description 
	 * @param savedInstanceState 
	 * @see Fragment#onCreate(Bundle) 
	 */ 
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

		
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		try{
			CustomApplication app = (CustomApplication)(getActivity().getApplicationContext());
				if(position>=0&&position<mProductList.size()){ 
					Film film = mProductList.get( position);
					EventBus.getDefault().post(new FilmEvent(film,""));
					film=null;
				}
		}catch( Exception ex){
			ex.printStackTrace();
		}
	}

}