package com.brainmentors.gaming.utils;

import java.awt.image.BufferedImage;

public interface EnemyTypeCord {
	public static final BufferedImage handAttackEnemy [] = new BufferedImage[6];
	BufferedImage batAttackEnemy [] = new BufferedImage[7];
	BufferedImage knifeAttackEnemy [] = new BufferedImage[7];
	
	static void loadHandAttackEnemy(BufferedImage spriteImage) {
		handAttackEnemy[0] = spriteImage.getSubimage(188, 344, 19, 44);
		handAttackEnemy[1] = spriteImage.getSubimage(170, 344, 20, 48);
		handAttackEnemy[2] = spriteImage.getSubimage(149, 344, 18, 46);
		handAttackEnemy[3] = spriteImage.getSubimage(130, 344, 18, 45);
		handAttackEnemy[4] = spriteImage.getSubimage(110, 344, 20, 48);
		handAttackEnemy[5] = spriteImage.getSubimage(83, 344, 25, 48);
	}
	static void loadBatAttackEnemy(BufferedImage spriteImage) {
		batAttackEnemy[0]  = spriteImage.getSubimage(186, 447, 22, 44);
		batAttackEnemy[1]  = spriteImage.getSubimage(167, 447, 18, 46);
		batAttackEnemy[2]  = spriteImage.getSubimage(141, 438, 25, 54);
		batAttackEnemy[3]  = spriteImage.getSubimage(103, 445, 41, 46);
		batAttackEnemy[4]  = spriteImage.getSubimage(76, 445, 27, 47);
		batAttackEnemy[5]  = spriteImage.getSubimage(35, 455, 41, 36);
		batAttackEnemy[6]  = spriteImage.getSubimage(5, 448, 29, 45);
	}
	static void loadKnifeAttackEnemy(BufferedImage spriteImage) {
		knifeAttackEnemy[0] = spriteImage.getSubimage(184, 396, 23, 45);
		knifeAttackEnemy[1] = spriteImage.getSubimage(165, 396, 20, 47);
		knifeAttackEnemy[2] = spriteImage.getSubimage(143, 391, 22, 52);
		knifeAttackEnemy[3] = spriteImage.getSubimage(112, 397, 28, 45);
		knifeAttackEnemy[4] = spriteImage.getSubimage(85, 399, 29, 47);
		knifeAttackEnemy[5] = spriteImage.getSubimage(61, 399, 25, 43);
		knifeAttackEnemy[6] = spriteImage.getSubimage(45, 430, 15, 13);
	}

}
