package com.goldminer.model.vo;

import java.awt.Graphics;

public class backgroundElement extends SuperElement {

	@Override
	public void showElement(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

}

class gameStartBackground extends backgroundElement{
	//TODO 根据状态展示开始图标
}
class levelStartBackground extends backgroundElement{
	//TODO 仅展示图片
}
class PlayingBackground extends backgroundElement{
	//TODO 仅展示图片
}
class levelEndBackground extends backgroundElement{
	//TODO 仅展示图片
}
class shopBackground extends backgroundElement{
	//TODO 根据状态显示文字
}
class gameOverBackground extends backgroundElement{
	//TODO 仅展示图片
}