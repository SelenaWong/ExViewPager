package com.evangeline.exviewpager.activity;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.evangeline.exviewpager.R;
import com.evangeline.exviewpager.adapter.TabPageIndicatorAdapter;
import com.evangeline.exviewpager.entity.Film;
import com.evangeline.exviewpager.entity.FilmTest;
import com.evangeline.exviewpager.event.FilmEvent;
import com.evangeline.exviewpager.fragment.ItemFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import com.evangeline.exviewpager.widget.LoopViewPager;

public class MainActivity extends FragmentActivity implements View.OnClickListener{

    @Bind(R.id.pager_product) LoopViewPager pager;
    @Bind(R.id.proBar_product) ProgressBar mProBar;
    @Bind(R.id.tv_product_currentPage)TextView mCurrentPageTv;
    @Bind(R.id.imv_product_previousPage) ImageView mPreviousImv;
    @Bind(R.id.imv_product_nextPage) ImageView mNextImv;

    private List<ItemFragment> mFragments = new ArrayList<ItemFragment>();
    private List<Film> mFilms = new  ArrayList<Film>();
    private FragmentStatePagerAdapter fAdapter;
    private int pageCount = 10;
    private int currentPage = 0;
    private int totalPage = 0;
    private int lastState = 0;
    private static String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        initData();
    }

    public void initData(){
        try{
            mFilms = FilmTest.getProducts();
            pager.removeAllViews();
            mFragments.clear();
            fAdapter=null;
            currentPage = 0;
            totalPage = 0;
            totalPage= mFilms.size()/pageCount;
            int reminder = mFilms.size()%pageCount;
            if(reminder!=0){
                totalPage++;
            }
            for(int i=0;i<totalPage;i++){
                ItemFragment fragment = new ItemFragment();
                int index = i;
                int pageNum = pageCount;//一页中的数据
                if(reminder!=0){
                    if(index==totalPage-1){
                        pageNum = reminder;
                    }
                }
                ArrayList<Film> list =Film.SubList(mFilms, index*pageCount, pageNum);
                Bundle args = new Bundle();
                args.putInt("itemIndex", index);
                args.putSerializable("listObj", list);
                fragment.SetParams(args);
                mFragments.add(fragment);
            }
            mProBar.setProgress(100/totalPage);
            mCurrentPageTv.setText("第1/"+totalPage+"页");
            fAdapter = new TabPageIndicatorAdapter(getSupportFragmentManager(),mFragments,mFilms);
            pager.setAdapter(fAdapter);
            pager.setOnPageChangeListener( new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrollStateChanged(int arg0) {
                    // TODO Auto-generated method stub
                    switch(arg0){
                        case  ViewPager.SCROLL_STATE_DRAGGING:
                        case  ViewPager.SCROLL_STATE_SETTLING:
                              lastState = arg0;
                              break;
                        case ViewPager.SCROLL_STATE_IDLE:
                            if(lastState== ViewPager.SCROLL_STATE_DRAGGING){
                                if(currentPage == mFragments.size()-1){
                                    currentPage=0;
                                    pager.setCurrentItem(currentPage,true);
                                }else if(currentPage==0){
                                    currentPage= mFragments.size()-1;
                                    pager.setCurrentItem(currentPage,true);
                                }
                            }
                            break;
                        default:
                            break;
                    }
                }
                @Override
                public void onPageScrolled(int arg0, float arg1, int arg2) {
                    // TODO Auto-generated method stub
                }
                @Override
                public void onPageSelected(int arg0) {
                    // TODO Auto-generated method stub
                    currentPage= arg0;
                    mProBar.setProgress((currentPage+1)*100/totalPage);
                    mCurrentPageTv.setText("第"+(currentPage+1)+"/"+totalPage+"页");
                }
            });
            mPreviousImv.setOnClickListener(this);
            mNextImv.setOnClickListener(this);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void onEvent(FilmEvent event){
        Film ap= event.getFilm();
        if(ap!=null){
            int number = ap.getProNumber();
            int prodId = ap.getProId();
            if(number<1){
                return;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.imv_product_previousPage:
                if(currentPage>0){
                    currentPage--;
                }else{
                    currentPage=totalPage-1;
                    Log.i(TAG, "after set currentPage="+currentPage);
                }
                pager.setCurrentItem(currentPage,true);
                mProBar.setProgress((currentPage+1)*100/totalPage);
                mCurrentPageTv.setText("第"+(currentPage+1)+"/"+totalPage+"页");
                break;
            case R.id.imv_product_nextPage:
                if(currentPage<totalPage-1){
                    currentPage++;
                }else{
                    currentPage=0;
                }
                pager.setCurrentItem(currentPage,true);
                mProBar.setProgress((currentPage+1)*100/totalPage);
                mCurrentPageTv.setText("第"+(currentPage+1)+"/"+totalPage+"页");
                break;
            default:break;
        }
    }
}
