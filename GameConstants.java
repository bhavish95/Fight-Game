package com.brainmentors.gaming.utils;

public interface GameConstants {
	String TITLE  = ConfigReader.getValue("game.title");
	int GWIDTH = Integer.parseInt(ConfigReader.getValue("game.width"));
	int GHEIGHT = Integer.parseInt(ConfigReader.getValue("game.height"));;
	int FLOOR  = Integer.parseInt(ConfigReader.getValue("game.height")) - 80; 
	int KICK = 2;
	int WALK = 1;
	int FALL = 3;
	int GRAVITY = 1;
	int DELAY = 100;
	int MAX_ENEMIES = 10;
	int MAX_HEALTH  = 200;
	

}
