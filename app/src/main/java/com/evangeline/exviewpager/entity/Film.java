
/**   
 * @Title: Product.java 
 * @Package: com.evangeline.exviewpager
 * @Description: TODO
 * @author lenovo  
 * @date 2016��9��26�� ����11:02:34 
 * @version 1.3.1 
 */


package com.evangeline.exviewpager.entity;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 
 * @author Selena Wong
 * @date 2016��9��26�� ����11:02:34 
 * @version V1.3.1
 */

public class Film {
	private int proId;
	private String proName;
	private String proUrl;
	private int proPrice;//价钱单位分
	private int proNumber;
	
	public Film(){
		
	}

	public Film(int id,String name,String url,int price,int num){
		this.proId = id;
		this.proName = name;
		this.proUrl = url;
		this.proPrice = price;
		this.proNumber = num;
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProUrl() {
		return proUrl;
	}

	public void setProUrl(String proUrl) {
		this.proUrl = proUrl;
	}

	public int getProPrice() {
		return proPrice;
	}

	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}

	public int getProNumber() {
		return proNumber;
	}

	public void setProNumber(int proNumber) {
		this.proNumber = proNumber;
	}


	/***
	 *
	 * @Description list 分割
	 * @author Selena Wong
	 * @param sourceList
	 * @param sIndex
	 * @param count
	 * @return
	 */
	public static ArrayList<Film> SubList(List<Film> sourceList, int sIndex, int count){
		ArrayList<Film> desList = new ArrayList<Film>();
		int size = sourceList.size();
		if(sIndex+count>size){
			return desList;
		}
		for(int i= sIndex;i<sIndex+count;i++){
			desList.add(sourceList.get(i));
			Log.i("TAG", "aisleId="+ sourceList.get(i).getProId());
		}
		return desList;
	}

}
