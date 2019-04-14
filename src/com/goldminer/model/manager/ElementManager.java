package com.goldminer.model.manager;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.goldminer.model.load.ElementLoad;
import com.goldminer.model.vo.SuperElement;
import com.goldminer.thread.GameThread;

/**
 * 元素管理器
 * 
 * java设计模式-》单例模式->全局只有一个实例
 * 
 * hashCode();是Object类->集合排序（Set集合,hash散列原理）
 * 
 */
public class ElementManager {
//	集合  NPC元素，场景元素，。。。。
	Map<String,List<SuperElement>> map;
//	初始化
	protected void init(){
		map=new HashMap<>();
		List<SuperElement> mineralList=new ArrayList<>();
		map.put("mineralList", mineralList);
		List<SuperElement> bombList=new ArrayList<>();
		map.put("bombList", bombList);
		List<SuperElement> goodList=new ArrayList<>();
		map.put("goodList", goodList);
		List<SuperElement> hookList=new ArrayList<SuperElement>();
		map.put("hookList", hookList);	
		List<SuperElement> backgroundList=new ArrayList<SuperElement>();
		map.put("backgroundList", backgroundList);
	}
//	得到一个完整的 map集合
	public Map<String, List<SuperElement>> getMap() {
		return map;
	}
//	得到一个元素的集合
	public List<SuperElement> getElementList(String key){
		return map.get(key);
	}
	
//	单例：需要一个唯一的引用
	private static ElementManager elementManager;
//	构造方法私有化，就只有在本类中可以 new
	private ElementManager(){
		init();
	}
	static{//静态的语句块 是在类加载的时候就会执行
		if(elementManager ==null){
			elementManager=new ElementManager();
		}
	}
//	提供出来给予外部访问的唯一入口   synchronized 线程保护锁
	public static /*synchronized*/ ElementManager getManager(){
//		if(elementManager ==null){
//			elementManager=new ElementManager();
//		}
		return elementManager;
	}
//	加载需要的资源
	public void load() {
		ElementLoad.getElementLoad().loadImg();
		ElementLoad.getElementLoad().loadSound();
		ElementLoad.getElementLoad().loadPro();
		ElementLoad.getElementLoad().loadLevel();
//		开放一个 状态，界面可以做  前夕啦（前面的过度信息）
//		......
//		map.get("hookList").add(ElementFactory.elementFactory("hook"));
		
	}
	public void clearList(String listStr) {
		map.remove(listStr);
		List<SuperElement> newList=new ArrayList<SuperElement>();
		map.put(listStr, newList);
	} 
	public File getLevelDatFile() {
		return null;
	}
	
	public void gameLink() {
		/*TODO (方法:流程){//用于GameThread中一直调用
		 * 		读取关卡总数,存储. 
		 * 		如果状态为(enum:关卡),根据(参数:当前关卡)读取相应关卡文件更新资源管理器
		 * 		如果状态为(enum:商店),随机生成商品,生成的商品价格与(参数:当前关卡)相关
		 * 		如果状态为...
		 * }
		 * */
		if(GameThread.gameStateChanged()) {
			switch (GameThread.nowGameState) {
			case GAME_START:
				
				break;
			case LEVEL_START:
				break;
			case PLAYING:
				break;
			case LEVEL_END:
				break;
			case SHOP:
				break;
			case GAME_OVER:
				break;
			default:
				break;
			}
		}
		GameThread.lastGameState=GameThread.nowGameState;
	}



}
////	控制流程   int time游戏进行时间
//	public void linkGame(int time) {
////		可以拿到流程 list
//		List<String> list=ElementLoad.getElementLoad().getGameList();
//		if(list.size()==0){
//			System.out.println("流程结束");
//			return;//流程已经结束。
//		}
//		String s=list.get(list.size()-1);//004=enemyA,enemyA,20,170,40,40,10000
//		String[] arr=s.split(",");
//		int runTime=Integer.parseInt(arr[arr.length-1]);
//		System.out.println(time+":"+runTime);
//		if(time>runTime){
//			map.get("enemyList").add(ElementFactory.elementFactory("enemy"));
//			list.remove(list.size()-1);
//		}
//	}
//}




