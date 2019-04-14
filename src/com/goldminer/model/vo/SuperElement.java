package com.goldminer.model.vo;

import java.awt.Graphics;

import javax.swing.ImageIcon;

/*
 * ����Ԫ�صĸ���Ԫ��
 * */
public abstract class SuperElement {

	private int x;//��ͼƬ�����Ͻ�x
	private int y;//��ͼƬ�����Ͻ�y
	private int r;
	private boolean visible;//Ĭ��Ϊ true ���� ���
	private ImageIcon img;
	/*
 * 	jvm��ÿ���඼ ��Ĭ������һ�� Ĭ���޲����Ĺ��췽��
 *  ���ǣ���������ֶ�д��һ�����췽����������ʲô���죨�в������޲�������jvm����������� Ĭ�Ϲ���
 *  һ����Ϊ���࣬������������죬���дһ���޲������죬��ֹ�̳б���
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
//	��Щ�����ǿ����� ˳��ִ�еġ�ģ��ģʽ  //���������ָ���� �����ʵ�����
	public void update(){
		move();
		destroy();
	}
	
	public abstract void showElement(Graphics g);
	public void move() {}
	public void destroy() {}
	
	public int getShowX(){//���ص��� �޸ĵ���ʾ��; Ĭ��Ϊ ���׼��
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
