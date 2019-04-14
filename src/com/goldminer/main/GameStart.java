package com.goldminer.main;

import com.goldminer.frame.MyJFrame;
import com.goldminer.frame.MyJPanel;
import com.goldminer.model.manager.StageState;
import com.goldminer.thread.GameKeyListener;
import com.goldminer.thread.GameMouseListener;
import com.goldminer.thread.GameThread;
/**
 * 面向对象中 自己的事情自己做-》明确的分工
 * 
 */
public class GameStart {
//	整个游戏的入口，启动
	public static void main(String[] args) {
//		资源加载
//		窗体加载（自动化。。）
		GameThread.nowGameState=StageState.GAME_START;
		GameThread.lastGameState=StageState.GAME_START;
		MyJFrame jf=new MyJFrame();
		MyJPanel jp=new MyJPanel();
		GameKeyListener keyListener=new GameKeyListener();
		GameMouseListener mouseListener=new GameMouseListener();
		jf.setKeyListener(keyListener);
		jf.setMouseListener(mouseListener);
		jf.setJp(jp);//注入
//		监听加载
		jf.addListener();
		jf.addJPanels();
		jf.addJPanels();//加载jp
//		游戏启动（开始）
		jf.start();
	}

}
