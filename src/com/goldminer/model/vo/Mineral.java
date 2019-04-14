package com.goldminer.model.vo;

import java.awt.Graphics;

public abstract class Mineral extends SuperElement {

    int value;
    int density;
    boolean hooked;
    protected Mineral() {}
    public void update(){
		move();
		destroy();
	}
    Mineral(int x,int y,int r,int value,int density){
    	setX(x);
    	setY(y);
    	setR(r);
    	this.value=value;
    	this.density=density;
    	this.hooked=false;
    }
    @Override
    public void move() {
    	// TODO Auto-generated method stub
    	if(hooked) {
    		
    	}
    }
	public boolean isHooked() {
		return hooked;
	}
	public void setHooked(boolean hooked) {
		this.hooked = hooked;
	}
}
