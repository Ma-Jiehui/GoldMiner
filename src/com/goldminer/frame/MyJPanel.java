package com.goldminer.frame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JPanel;

import com.goldminer.model.manager.ElementManager;
import com.goldminer.model.vo.SuperElement;

public class MyJPanel extends JPanel implements Runnable{
	/**
	 * 1.这个paint是由 底层自动调用的，我们重写父类的方法
	 * 2.这个方法只会执行1次，如果不持续调用，就不会持续执行
	 * 
	 * 帧: 16毫秒每帧    24帧/秒
	 */
	  //作用是 用来显示
	public void paint(Graphics g) {
		
		super.paint(g);
//		给一个判定值  也可以使用枚举
//		1.前动画
//		2.gameRuntime
		gameRunTime(g);//Graphics 画笔
//		3.衔接动画
		
	}

	private void gameRunTime(Graphics g) {
//		List<SuperElement> list=
//				ElementManager.getManager().getElementList("XX");
//		g.drawString("*", 100, 100);
		Map<String,List<SuperElement>> map=
				ElementManager.getManager().getMap();
		Set<String> set=map.keySet();
//		List<String> list=new ArrayList<>();
//		list.addAll(set);
//		Collections.sort(list);//自然顺序
//		Collections.sort(list,"比较器对象");//自动以顺序
//		知识点：java集合对象的排序规则 和2个接口有关
		for(String key:set){
			List<SuperElement> list=map.get(key);
			for(int i=0;i<list.size();i++){
				list.get(i).showElement(g);
			}
		}
	}
	
	/**
	 * 什么是重写：
	 * 1.是有继承关系的 类与类之间的语法现象(多态的一种实现)
	 * 2.重写的方法必须和 父类的方法的签名一样(返回值，方法名称，参数序列)
	 * 3.重写的方法访问修饰符只可以比父类的更加开放，不可以比父类更加封闭
	 * 4.重写的方法抛出异常不可以比 父类的更加开放
	 */
	@Override
	public void run(){
		while(true){//死循环:界面会不停止的刷新
//			线程的休眠
			try {
				Thread.sleep(16);//毫秒
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.repaint();//要求 面板再次刷新
		}
	}
}
