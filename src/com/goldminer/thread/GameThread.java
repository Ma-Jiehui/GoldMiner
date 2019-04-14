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

//java是单继承，多实现。通过 内部类的方式，弥补单继承的缺陷
public class GameThread extends Thread {
//	计时数据
	public static StageState nowGameState;
	public static StageState lastGameState;
	public static int totalLevel;
	public static int nowLevel;
	public static int countdown;
	public static int targetPoint;
	public static int point;
	private int time;
//	代码的熟练 和 思想的进步 都是通过很多的项目锻炼
//	如果项目不多，请 重构老项目

	// TODO ElmentManager的流程方法一直自动调用,GameThread根据各种条件 *自动*改变元素状态

	public void run() {
//		1.加载地图，人物
		loadElement();
//		2.显示人物地图(流程,自动化(移动，碰撞))		
		while (true) { // 游戏整体进度
//		死循环，但会有变量（状态）进行控制
			gameLink();
			runGame();
			// 3.结束本地图
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
		while(!gameStateChanged()){  //每个关中玩的时候的状态
//			List<SuperElement>list=ElementManager.getManager().getElementList("play");
			Map<String,List<SuperElement>> map=
					ElementManager.getManager().getMap();
			Set<String> set=map.keySet();
				
			for(String key:set){//迭代器在遍历的过程中，迭代器内的元素不可以 增加或者删除
				List<SuperElement> list=map.get(key);
				for(int i=0;i<list.size();i++){
					list.get(i).update();
					if(!list.get(i).isVisible()){
						list.remove(i--);
					}
				}
	//			写飞机的添加到 list到map  //游戏的流程控制 
	//			linkGame();
				//死亡，通关等 结束 runGame方法
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
	// 游戏的流程控制
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
//	控制进度,但是，作为 控制，请不要接触 load
	private void loadElement() {
		ElementManager.getManager().load();
	}

}
