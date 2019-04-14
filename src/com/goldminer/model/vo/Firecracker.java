package com.goldminer.model.vo;

import java.awt.Graphics;

public class Firecracker extends Good {

	@Override
	public void showElement(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(getImg().getImage(), 
				getX(), getY(), 2*getR(),2*getR(), null);
	}

}
