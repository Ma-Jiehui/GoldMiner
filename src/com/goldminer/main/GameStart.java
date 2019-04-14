package com.goldminer.main;

import com.goldminer.frame.MyJFrame;
import com.goldminer.frame.MyJPanel;
import com.goldminer.model.manager.StageState;
import com.goldminer.thread.GameKeyListener;
import com.goldminer.thread.GameMouseListener;
import com.goldminer.thread.GameThread;
/**
 * ��������� �Լ��������Լ���-����ȷ�ķֹ�
 * 
 */
public class GameStart {
//	������Ϸ����ڣ�����
	public static void main(String[] args) {
//		��Դ����
//		������أ��Զ���������
		GameThread.nowGameState=StageState.GAME_START;
		GameThread.lastGameState=StageState.GAME_START;
		MyJFrame jf=new MyJFrame();
		MyJPanel jp=new MyJPanel();
		GameKeyListener keyListener=new GameKeyListener();
		GameMouseListener mouseListener=new GameMouseListener();
		jf.setKeyListener(keyListener);
		jf.setMouseListener(mouseListener);
		jf.setJp(jp);//ע��
//		��������
		jf.addListener();
		jf.addJPanels();
		jf.addJPanels();//����jp
//		��Ϸ��������ʼ��
		jf.start();
	}

}
