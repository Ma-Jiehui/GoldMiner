package com.goldminer.thread;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameMouseListener implements MouseListener {
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Êó±ê¼àÌý
		switch (GameThread.gameState) {
		case GAME_START:		
			break;
		case LEVEL_START:
			break;
		case PLAYING:
			break;
		case LEVEL_END:
			break;
		case SHOP:
			break;
		case PAUSE:
			break;
		case GAME_OVER:
			break;
		default:break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}
