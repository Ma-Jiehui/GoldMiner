package com.goldminer.model.vo;

import java.awt.Graphics;

public abstract class Good extends SuperElement {
	int price;
	
	public Good() {
		super();
		// TODO ���������ؿ�������صļ۸�
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
