package model;

import java.util.Random;

import javax.swing.ImageIcon;

import behaviours.BehaviourFactory;
import container.CollidableContainer;
import container.DrawContainer;
import container.MoveContainer;
import controller.Game;

public class ShipEnemy extends BasicEnemy {
	
	private double radians = 0;

	public ShipEnemy(Random random, ID id, BehaviourFactory behaviourFactory, MoveContainer moveContainer,
			DrawContainer drawContainer, CollidableContainer collidableContainer) {
		super(random, 0, 0, id, behaviourFactory, moveContainer, drawContainer, collidableContainer);
		
		this.img = new ImageIcon(this.getClass().getResource("../images/chaser.png")).getImage();
		
		width = img.getWidth(null);
		height = img.getHeight(null);
		
		x = random.nextInt(Game.WIDTH - width);
		y = random.nextInt((int) (Game.HEIGHT - (height*1.5)));
	}
	
	public double getRadians() {
		return this.radians;
	}
	public void setRadians(double radians) {
		this.radians = radians;
	}
}
