package com.evangeline.exviewpager.entity;

import java.util.ArrayList;
import java.util.List;


public class FilmTest {

	public static String[] urls = new String[] {
			"http://img.cxdq.com/d1/img/070609/20076962820825.jpg",
			"http://www.ocn.com.cn/Upload/userfiles/25(128).jpg",
			"http://image11.m1905.cn/uploadfile/2012/1025/20121025115127717.jpg",
			"http://www.sndu.com.cn/resource/images/201511/20151125132158625.jpeg",
			"http://img31.mtime.cn/mg/2014/09/30/145438.41392832_270X405X4.jpg",
			"http://img31.mtime.cn/mg/2014/09/09/095439.24895990_270X405X4.jpg",
			"http://img31.mtime.cn/mg/2014/10/13/151034.85474901_270X405X4.jpg",
			"http://img31.mtime.cn/mg/2014/09/23/084444.96794628_270X405X4.jpg",
			"http://img31.mtime.cn/mg/2014/08/15/104026.33444853_270X405X4.jpg",
			"http://img31.mtime.cn/mg/2014/09/26/151251.44963343_270X405X4.jpg",
			"http://www.photophoto.cn/m62/040/015/0400150011.jpg",
			"https://upload.wikimedia.org/wikipedia/zh/8/81/%E7%99%BD%E5%A4%A9%E7%9A%84%E6%98%9F%E6%98%9F%E9%9B%BB%E5%BD%B1%E6%B5%B7%E5%A0%B1.jpg",
			"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTXSdOyvNo4E1sdw28juuou5VEl_9Rsf6ENLVFWgCQ5mwDHxwZJ",
			"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRvxhydOTzuTL16v9k2WNIr3J1hvdC-KcBGhoTCUWOzBE_A9dG-",
			"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTb5S5-EYm3aQTC0lPy29T9oNBP4_xV4DnmfoiJUb34jl9z1Em8tw",
			"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTG91KXK4mptA5-Fzq48Tiw1bJ9q7UIE08zWAzOKLGwClGaa1kS",
			"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRC-VPDQ1fxKsvTkdwqL6jSGqaWhP6rjaQ3g9VQ8KkVv-QTtExz",
			"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTDgraAVIHJBt7Q9f-2JK0eh3nhHCJTxVnMHlRJBf_mVcNwp7dm",
			"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTKhXPpaaODYr19RoDE4v9u0-rN29p_tSPUc4b3beJPo0vn1UQ",
			"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRvnkC3F3DaOBwg70P2mtX1OzUwF3wNAfxBOxlyDc8EkMKsim0jUA",
			"http://www.sjvi.net/webpic/20131204085537901482288771.jpg",
			"http://www.supev.org/d/file/uploads/fhijklnsxyDKNOQS.jpg",
			"http://www.supev.org/d/file/uploads/abhilmpqsxzDIJMZ.jpg"
	};

	public static String[] names = new String[] { 
			"哈利波特", "饥饿游戏", "暮光", "剑雨", "3D食人鱼", "心花怒放", "忍者神龟","移动迷宫","魁拔","史来贺",
			"神话","白天的星星","四大名捕","少年派的漂流记","爱丽丝梦游仙境","杜拉拉追婚记","从你的全世界路过","建国大业",
			"苏乞儿","魔戒","神秘博士","神秘博士特辑","神秘博士"
			};

	public static List<Film> getProducts() {
		List<Film> proList = new ArrayList<Film>();
		for (int i = 0; i < 23; i++) {
			int price = (i+1)*500;
			Film film = new Film(i+1,names[i], urls[i],price,20);//价钱单位分
			proList.add(film);
		}
		return proList;
	}

}
