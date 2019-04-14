package com.goldminer.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.goldminer.model.load.ElementLoad;
import com.goldminer.model.manager.ElementManager;
import com.goldminer.model.manager.HookState;
import com.goldminer.model.manager.StageState;
import com.goldminer.model.vo.SuperElement;

//java�ǵ��̳У���ʵ�֡�ͨ�� �ڲ���ķ�ʽ���ֲ����̳е�ȱ��
public class GameThread extends Thread {
//	��ʱ����
	public static StageState nowGameState;
	public static StageState lastGameState;
	public static int totalLevel;
	public static int nowLevel;
	public static int countdown;
	public static int targetPoint;
	public static int point;
	private int time;
//	��������� �� ˼��Ľ��� ����ͨ���ܶ����Ŀ����
//	�����Ŀ���࣬�� �ع�����Ŀ

	// TODO ElmentManager�����̷���һֱ�Զ�����,GameThread���ݸ������� *�Զ�*�ı�Ԫ��״̬

	public void run() {
//		1.���ص�ͼ������
		loadElement();
//		2.��ʾ�����ͼ(����,�Զ���(�ƶ�����ײ))		
		while (true) { // ��Ϸ�������
//		��ѭ���������б�����״̬�����п���
			gameLink();
			runGame();
			// 3.��������ͼ
			try {
				sleep(16);
			} catch (InterruptedException e) {
				//
				e.printStackTrace();
			}
		}
	}

	private void runGame() {
		//countdown=ElementManager.getManager().getMap().get("level")
		while(!gameStateChanged()){  //ÿ���������ʱ���״̬
//			List<SuperElement>list=ElementManager.getManager().getElementList("play");
			Map<String,List<SuperElement>> map=
					ElementManager.getManager().getMap();
			Set<String> set=map.keySet();
				
			for(String key:set){//�������ڱ����Ĺ����У��������ڵ�Ԫ�ز����� ���ӻ���ɾ��
				List<SuperElement> list=map.get(key);
				for(int i=0;i<list.size();i++){
					list.get(i).update();
					if(!list.get(i).isVisible()){
						list.remove(i--);
					}
				}
	//			д�ɻ�����ӵ� list��map  //��Ϸ�����̿��� 
	//			linkGame();
				//������ͨ�ص� ���� runGame����
				try {
					sleep(16);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				countdown-=16;
				if(countdown<=0) {
					if(point>=targetPoint) {
						nowGameState=StageState.LEVEL_END;
					}else {
						nowGameState=StageState.GAME_OVER;
					}
				}
			}
		}
	}

	public void countDown() {
		
	}
	// ��Ϸ�����̿���
	public void gameLink() {
		ElementManager.getManager().gameLink();

	}

	private void overGame() {
		// TODO Auto-generated method stub

	}

	public static boolean gameStateChanged() {
		if(nowGameState!=lastGameState) {
			return true;
		}else {
			return false;
		}
	}
//	���ƽ���,���ǣ���Ϊ ���ƣ��벻Ҫ�Ӵ� load
	private void loadElement() {
		ElementManager.getManager().load();
	}

}
