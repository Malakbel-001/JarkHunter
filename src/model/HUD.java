package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/*
 * Heads-Up-Display
 */
public class HUD {
	public static int SCORE;
	
	public void tick(){
		
	}
	
	public void render(Graphics2D g2d){
		g2d.setColor(Color.white);
		g2d.setFont(new Font("Arial", Font.BOLD, 14));
		g2d.drawString("Score: ", 15, 25);
	}
}