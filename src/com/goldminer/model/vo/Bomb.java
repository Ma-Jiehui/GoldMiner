package com.goldminer.model.vo;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Bomb extends SuperElement {

	double x;
	double y;
	double r;
	List<Bomb> chainReaction = new ArrayList<Bomb>();
	boolean marked2Explode;
    Bomb(double x, double y, double r){}
    void paint(Graphics g){}
    void explode(){    
        //sound
    }
	@Override
	public void showElement(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
