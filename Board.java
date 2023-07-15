package com.brainmentors.gaming.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.brainmentors.gaming.sprites.Camera;
import com.brainmentors.gaming.sprites.Enemy;
import com.brainmentors.gaming.sprites.Player;
import com.brainmentors.gaming.sprites.Power;
import com.brainmentors.gaming.utils.EnemyTypeCord;
import com.brainmentors.gaming.utils.GameConstants;

public class Board extends JPanel implements GameConstants {
	private Camera camera;
	BufferedImage backgroundImage;
	BufferedImage partOfImage;
	private Player player;
	private Enemy enemies[] ;
	//private Enemy enemy;
	private Timer timer;
	private boolean isGameOver;
	private Power power;
	
	public Board() throws Exception{
		power = new Power();
		player = new Player();
		EnemyTypeCord.loadBatAttackEnemy(player.getSpriteImage());
		EnemyTypeCord.loadHandAttackEnemy(player.getSpriteImage());
		EnemyTypeCord.loadKnifeAttackEnemy(player.getSpriteImage());
		enemies = new Enemy[MAX_ENEMIES];
		loadEnemies();
		//enemy = new Enemy(EnemyTypeCord.handAttackEnemy);
		loadBackgroundImage();
		setFocusable(true);
		bindEvents();
		gameLoop();
		//System.out.println("i am the board constrcutor...");
	}	
	
	private void loadEnemies() throws Exception {
		int gap = 0;
		for(int i = 0 ; i<enemies.length; i++) {
			if(i%2==0) {
				enemies[i] = new Enemy(EnemyTypeCord.handAttackEnemy, gap);
			}
			else if(i%3==0) {
				enemies[i] = new Enemy(EnemyTypeCord.knifeAttackEnemy, gap);
			}
			else {
				enemies[i] = new Enemy(EnemyTypeCord.batAttackEnemy, gap);
			}
			
			gap = gap + 500;
		}
//		enemies[0] = new Enemy(EnemyTypeCord.handAttackEnemy,0);
//		enemies[1] = new Enemy(EnemyTypeCord.batAttackEnemy,500);
//		enemies[2] = new Enemy(EnemyTypeCord.knifeAttackEnemy,1000);
//		enemies[3] = new Enemy(EnemyTypeCord.handAttackEnemy, 1500);
	}
	
	
	
	private void gameLoop() {
		timer = new Timer(DELAY, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					repaint();
					player.fall();
					collision();
				
			}
		});
		timer.start();
	}
	
	private void bindEvents() {
		this.addKeyListener(new KeyAdapter() {
			
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				player.setSpeed(0);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					
					player.setSpeed(-10);
					player.move();
					
				}
				else 
					if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
						if(player.getX()<=200) {
						player.setSpeed(10);
						player.move();
						}
						else {
							camera.setSpeed(10);
							camera.move();
						}
						
					}
					else if(e.getKeyCode() == KeyEvent.VK_K) {
						player.setAttacking(true);
						player.setCurrentMove(KICK);
					}
					else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
						player.jump();
					}
				
				
				
			}
		});
	}
	
	private void loadBackgroundImage() throws IOException {
		camera = new Camera();
	}
	
	private boolean isCollide(Enemy currentEnemy) {
		int xDistance = Math.abs(player.getX() - currentEnemy.getX());
		int yDistance = Math.abs(player.getY() - currentEnemy.getY());
		int maxWidth = Math.max(player.getW(), currentEnemy.getW());
		int maxHeight = Math.max(player.getH(), currentEnemy.getH());
		return xDistance<=maxWidth-50 && yDistance<=maxHeight-40;
	}
	private boolean isVisible = true;
	private void printGameOver(Graphics pen) {
		pen.setColor(Color.BLACK);
		pen.setFont(new Font("Arial", Font.BOLD, 40));
		pen.drawString(isVisible?"Game Over":"", GWIDTH/2, GHEIGHT/2);
		isVisible = !isVisible;
	}
	
	public void collision() {
		for(Enemy enemy : enemies) {
			if(!enemy.isCollide()  && isCollide(enemy)) {
				if(player.isAttacking()) {
					enemy.setAlive(false);
				}
				else {
				
				power.setHealth();
				}
				enemy.setCollide(true);
				if(power.getHealth()<=0) {
				player.setCurrentMove(FALL);
				isGameOver = true;
				}
				System.out.println("Collide......");
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		printBG(pen);
		player.printSprite(pen);
		printEnemies(pen);
		if(isGameOver) {
			printGameOver(pen);
		}
		power.printSprite(pen);
		//enemy.printSprite(pen);
		//System.out.println("I am the Paint Component....");
	}
	
	private void printEnemies(Graphics pen) {
		for(Enemy en: enemies) {
			if(en.isAlive()) {
			en.printSprite(pen);
			}
		}
	}
	
	private void printBG(Graphics pen) {
//		
		//pen.drawImage(partOfImage,0,0, GWIDTH, GHEIGHT, null);
		camera.printSprite(pen);
	}

}
