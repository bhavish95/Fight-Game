package com.brainmentors.gaming.screens;

import javax.swing.JFrame;

import com.brainmentors.gaming.utils.GameConstants;

public class GameFrame extends JFrame implements GameConstants {
	
	public GameFrame() throws Exception {
		setTitle(TITLE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(GWIDTH, GHEIGHT);
		setLocationRelativeTo(null);
		Board board = new Board();
		add(board);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			GameFrame frame = new GameFrame();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				

	}

}
