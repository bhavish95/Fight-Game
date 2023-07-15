package com.brainmentors.gaming.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.brainmentors.gaming.utils.GameConstants;

public class Player extends Sprite  {
	
	private BufferedImage walkImages [] = new BufferedImage[4];
	private BufferedImage kickImages [] = new BufferedImage[3];
	
	private BufferedImage deadImages[] = new BufferedImage[2];
	
	private boolean isAttacking;
	private int force;
	private boolean isJump ;
	public Player() throws Exception {
		//super();
		x  = 180;
		
		
		
		speed = 0;
		force = 0;
		currentMove = WALK;
		loadWalk();
		loadKick();
		loadDead();
	}
	
	
	
	
	
	public boolean isAttacking() {
		return isAttacking;
	}





	public void setAttacking(boolean isAttacking) {
		this.isAttacking = isAttacking;
	}





	private void loadDead() {
		deadImages[0]  = bi.getSubimage(240, 305,22, 42);
		deadImages[1]  = bi.getSubimage(210, 307,31, 40);
	}


	private void loadWalk() {
		walkImages[0] = bi.getSubimage(211, 5, 24, 44);
		walkImages[1] = bi.getSubimage(235, 2, 18, 49);
		//walkImages[2] = bi.getSubimage(258, 2, 23, 48);
		//walkImages[3] = bi.getSubimage(284, 5, 20, 46);
		
	}
	
	private void loadKick() {
		kickImages[0] = bi.getSubimage(211,50, 37,45);
		kickImages[1] = bi.getSubimage(250,52,27,40);
		kickImages[2] = bi.getSubimage(276, 56,23, 37);
	}
	
	public void jump() {
		if(!isJump) {
		//System.out.println("Call Jump...");
		force = -13;
		y = y + force;
		isJump = true;
		}
	}
	
	public void fall() {
//		System.out.println("F "+(FLOOR-h));
//		System.out.println("Y "+y);
		if(y>=(FLOOR-h) && isAlive) {
			isJump= false; // Jump Complete
			//System.out.println("Not Fall");
			return ;
		}
		//System.out.println("Fall....");
		force = force + GRAVITY;
		y= y + force;
	}
	
	
	
	
	
	
	
	private BufferedImage showPlayerDead() {
		if(index >1) {
			index =0;
			isAlive= false;
			
		}
		BufferedImage img =  deadImages[index];
		index++;
		return img;
	}

	private BufferedImage showPlayerKick() {
		if(index >2) {
			index =0;
			currentMove = WALK;
			isAttacking = false;
		}
		BufferedImage img =  kickImages[index];
		index++;
		return img;
		
	}


	private BufferedImage showWalkPlayer() {
		if(index >1) {
			index =0;
		}
//		try {
//			Thread.sleep(40);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		BufferedImage img =  walkImages[index];
		index++;
		return img;
		
	}
	
	
	@Override
	public void printSprite(Graphics pen) {
		if(currentMove == WALK) {
		pen.drawImage(showWalkPlayer(),x, y, w, h, null);
		}
		else if (currentMove == KICK) {
			
			pen.drawImage(showPlayerKick(),x, y, w, h, null);
		}
		else if (currentMove == FALL) {
			pen.drawImage(showPlayerDead(), x,y, w, h, null);
		}
	}
	

}
