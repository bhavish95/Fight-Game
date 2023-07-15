package com.brainmentors.gaming.sprites;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

public class Power extends Sprite {

	public Power() throws IOException {
		super();
		x = 100;
		y = 70;
		h = 30;
		w = 200;
		health = 200;
		// TODO Auto-generated constructor stub
	}
	
	public void setHealth() {
		this.health = this.health - (int)(MAX_HEALTH * 0.20);
	}

	@Override
	public void printSprite(Graphics pen) {
		// TODO Auto-generated method stub
		pen.setColor(Color.RED);
		pen.fillRect(x, y, w, h);
		pen.setColor(Color.GREEN);
		pen.fillRect(x, y, health, h);
		
		
		
	}
	
}
