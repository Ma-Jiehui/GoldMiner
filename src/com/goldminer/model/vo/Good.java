package com.goldminer.model.vo;

import java.awt.Graphics;

public abstract class Good extends SuperElement {
	int price;
	
	public Good() {
		super();
		// TODO 随机生成与关卡略有相关的价格
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
