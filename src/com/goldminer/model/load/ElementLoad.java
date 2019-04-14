package com.goldminer.model.load;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.swing.ImageIcon;

public class ElementLoad {
	private Map<String,ImageIcon> imgMap;
	private Map<String,List<String>> soundMap;
	private Map<String,String> proMap;
	private Map<String, Object> levelList;

	
	
	private static ElementLoad load;

	//	pro文件读取对象
	private Properties pro;
	
	private ElementLoad(){
		imgMap=new HashMap<>();
		soundMap=new HashMap<>();
		proMap=new HashMap<>();
		levelList=new HashMap<String, Object>();
		pro=new Properties();
	}   
	public static synchronized ElementLoad getElementLoad(){
		if(load==null){
			load=new ElementLoad();
		}
		return load;
	}

	
//	读取配置
	public void loadPro(){
		InputStream in=ElementLoad.class.getClassLoader()
				.getResourceAsStream("com/goldminer/pro/gameProperties.pro");
		try {
			pro.clear();
			pro.load(in);
			String property;
			for(Object o:pro.keySet()){
				String str=pro.getProperty(o.toString());
				property=str;
				proMap.put(o.toString(), property);
			}
		} catch (IOException e) {
			// 
			e.printStackTrace();
		}
	}
//	读取图片的
	public void loadImg(){
		InputStream in=ElementLoad.class.getClassLoader()
			.getResourceAsStream("com/goldminer/pro/imgUrl.pro");
		try {
			pro.clear();
			pro.load(in);
			Set<?> set=pro.keySet();
			for(Object o:set){
				String url=pro.getProperty(o.toString());
				imgMap.put(o.toString(), new ImageIcon(url));
			}
			System.out.println(imgMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void loadSound(){
		// TODO 声音加载器
	}
//	public void readImgProS(){
//		InputStream in=ElementLoad.class.getClassLoader()
//			.getResourceAsStream("com/tedu/pro/mapB.pro");
//		try {
//			pro.clear();//清除
//			pro.load(in);
////			System.out.println(pro.keys());
////			System.out.println(pro.keySet());
//			Set<?> set=pro.keySet();
//			for(Object o:set){
//				String url=pro.getProperty(o.toString());
//				File f=new File(url);
////				if(f.isFile()){
////					System.out.println("是个文件");
////				}else{
////					System.out.println("是个路径");
////				}
//				File [] arr=f.listFiles();
//				System.out.println(Arrays.toString(arr));
//			
//			}
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	public void loadLevel() {
		File datPath=new File("dat");
		if(datPath.isDirectory()) {
			File[] leveFileList=datPath.listFiles();
			String[] levelFileStrList=datPath.list();
//			ArrayList<File> leveFileList=new ArrayList<File>();
			levelList.put("totalLevel", leveFileList.length);
			for(int i=0;i<leveFileList.length;i++) {
				String str=levelFileStrList[i];
				levelList.put("level"+str.substring(str.length()-6, str.length()-4),
						leveFileList[i]);
			}
		}
	}
	public Map<String, ImageIcon> getImgMap() {
		return imgMap;
	}
	public Map<String, List<String>> getSounMap() {
		return soundMap;
	}
	public Map<String, String> getProMap() {
		return proMap;
	}
	public Map<String, Object> getLevelList() {
		return levelList;
	}
	
	
	
	
	
	
	
	
}
