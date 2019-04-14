package com.goldminer.model.vo;

import java.awt.Graphics;

import javax.swing.ImageIcon;

/*
 * 所有元素的父类元素
 * */
public abstract class SuperElement {

	private int x;//画图片的左上角x
	private int y;//画图片的左上角y
	private int r;
	private boolean visible;//默认为 true 代表 存活
	private ImageIcon img;
	/*
 * 	jvm给每个类都 会默认增加一个 默认无参数的构造方法
 *  但是，如果我们手动写啦一个构造方法（无论是什么构造（有参数，无参数））jvm都不会再添加 默认构造
 *  一般作为父类，如果有其他构造，最好写一个无参数构造，防止继承报错。
 */
	protected SuperElement(){}
	public SuperElement(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public SuperElement(int x,int y,int r,ImageIcon img){
		this.x=x;
		this.y=y;
		this.r=r;
		this.visible=true;
		this.img=img;
	}
//	这些方法是可以有 顺序执行的。模板模式  //父类的引用指向与 子类的实体对象。
	public void update(){
		move();
		destroy();
	}
	
	public abstract void showElement(Graphics g);
	public void move() {}
	public void destroy() {}
	
	public int getShowX(){//返回的是 修改的显示点; 默认为 左标准点
		return getX();
	}
	public int getShowY(){
		return getY();
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}
}
