package com.brainmentors.gaming.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.brainmentors.gaming.utils.GameConstants;

public abstract class Sprite implements GameConstants {
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected BufferedImage bi;
	protected int speed;
	protected int currentMove ;
	protected int index ;
	protected boolean isAlive;
	protected int health;
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	protected boolean isCollide;
	
	
	
	
	
	public boolean isCollide() {
		return isCollide;
	}

	public void setCollide(boolean isCollide) {
		this.isCollide = isCollide;
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

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public BufferedImage getSpriteImage() {
		return bi;
	}
	
	public Sprite() throws IOException {
		bi = ImageIO.read(Player.class.getResource("sprite.gif"));
h = 100;
		
		w = 100;
		y = FLOOR - h;
		isAlive = true;
	}
	
	public int getCurrentMove() {
		return currentMove;
	}

	public void move() {
		x= x + speed;
	}


	public void setCurrentMove(int currentMove) {
		this.currentMove = currentMove;
		index =0;
	}
	
	public int getSpeed() {
		return speed;
	}



	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public abstract void printSprite(Graphics pen) ;
		
	
}
