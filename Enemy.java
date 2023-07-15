package com.brainmentors.gaming.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Enemy extends Sprite {
	
	private BufferedImage[] enemyImages ;
	private int startPos ;
	public Enemy(BufferedImage[] enemyImages, int gap) throws Exception {
		this.enemyImages = enemyImages;
		x = GWIDTH + gap;
		startPos=x;
		currentMove = WALK;
		index = 0;
		speed = -15;
		
		
	}
	
	
	
	
	public boolean isAlive() {
		return isAlive;
	}


	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}


	public void outOfScreen() {
		
		if(x<=0) {
			//x = startPos;
			isAlive = false;
		}
	}

	@Override
	public void printSprite(Graphics pen) {
		if(index>=enemyImages.length-1) {
			index = 0;
			
		}
		pen.drawImage(enemyImages[index], x,y, w, h, null);
		index++;
		move();
		outOfScreen();
		// TODO Auto-generated method stub
		
	}

}
