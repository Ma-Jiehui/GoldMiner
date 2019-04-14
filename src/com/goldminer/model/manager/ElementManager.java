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
 * Ԫ�ع�����
 * 
 * java���ģʽ-������ģʽ->ȫ��ֻ��һ��ʵ��
 * 
 * hashCode();��Object��->��������Set����,hashɢ��ԭ��
 * 
 */
public class ElementManager {
//	����  NPCԪ�أ�����Ԫ�أ���������
	Map<String,List<SuperElement>> map;
//	��ʼ��
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
//	�õ�һ�������� map����
	public Map<String, List<SuperElement>> getMap() {
		return map;
	}
//	�õ�һ��Ԫ�صļ���
	public List<SuperElement> getElementList(String key){
		return map.get(key);
	}
	
//	��������Ҫһ��Ψһ������
	private static ElementManager elementManager;
//	���췽��˽�л�����ֻ���ڱ����п��� new
	private ElementManager(){
		init();
	}
	static{//��̬������ ��������ص�ʱ��ͻ�ִ��
		if(elementManager ==null){
			elementManager=new ElementManager();
		}
	}
//	�ṩ���������ⲿ���ʵ�Ψһ���   synchronized �̱߳�����
	public static /*synchronized*/ ElementManager getManager(){
//		if(elementManager ==null){
//			elementManager=new ElementManager();
//		}
		return elementManager;
	}
//	������Ҫ����Դ
	public void load() {
		ElementLoad.getElementLoad().loadImg();
		ElementLoad.getElementLoad().loadSound();
		ElementLoad.getElementLoad().loadPro();
		ElementLoad.getElementLoad().loadLevel();
//		����һ�� ״̬�����������  ǰϦ����ǰ��Ĺ�����Ϣ��
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
		/*TODO (����:����){//����GameThread��һֱ����
		 * 		��ȡ�ؿ�����,�洢. 
		 * 		���״̬Ϊ(enum:�ؿ�),����(����:��ǰ�ؿ�)��ȡ��Ӧ�ؿ��ļ�������Դ������
		 * 		���״̬Ϊ(enum:�̵�),���������Ʒ,���ɵ���Ʒ�۸���(����:��ǰ�ؿ�)���
		 * 		���״̬Ϊ...
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
////	��������   int time��Ϸ����ʱ��
//	public void linkGame(int time) {
////		�����õ����� list
//		List<String> list=ElementLoad.getElementLoad().getGameList();
//		if(list.size()==0){
//			System.out.println("���̽���");
//			return;//�����Ѿ�������
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




