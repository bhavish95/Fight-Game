package com.brainmentors.gaming.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import com.brainmentors.gaming.screens.Board;

public class Camera extends Sprite {
	BufferedImage backgroundImage;
	BufferedImage partOfImage;
	public Camera() throws IOException {
		super();
		x = 0;
		y = 0;
		w = 1000;
		h = 200;
		try {
			backgroundImage = ImageIO.read(Board.class.getResource("game-bg.png"));
			partOfImage = backgroundImage.getSubimage(x,y,w, h);
			}
			catch(Exception ex) {
				//JOptionPane.showMessageDialog(this,"OOPS something went wrong..");
				System.out.println(ex);
				System.exit(0);
				
			}
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public void printSprite(Graphics pen) {
		partOfImage = backgroundImage.getSubimage(x,y,w, h);
		pen.drawImage(partOfImage, 0,0,GWIDTH,GHEIGHT ,null);
		
	}
	

}
