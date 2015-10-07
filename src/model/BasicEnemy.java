package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.Random;

import javax.swing.ImageIcon;

import behaviours.BehaviourFactory;
import behaviours.CollidableBehaviour;
import behaviours.DrawBehaviour;
import behaviours.MoveBehaviour;
import behaviours.MoveTrailBehaviour;
import container.CollidableContainer;
import container.DrawContainer;
import container.MoveContainer;
import controller.Game;

public class BasicEnemy extends GameObject {

	private MoveContainer moveContainer;
	private MoveBehaviour moveBehaviour;
	private DrawContainer drawContainer;
	private DrawBehaviour drawBehaviour;
	private CollidableContainer collidableContainer;
	private CollidableBehaviour collidableBehaviour;
	
	public BasicEnemy(Random random, int width, int height, ID id, BehaviourFactory behaviourFactory, 
			MoveContainer moveContainer, DrawContainer drawContainer, CollidableContainer collidableContainer) {
		super(0, 0, width, height, id);
		
		x = random.nextInt(Game.WIDTH - width);
		y = random.nextInt((int) (Game.HEIGHT - (height*1.5)));
		
		this.moveContainer = moveContainer;
		this.moveBehaviour = behaviourFactory.createMoveBehaviour(this);
		moveContainer.add(moveBehaviour);
		
		this.drawContainer = drawContainer;
		this.drawBehaviour = behaviourFactory.createDrawBehaviour(this);
		drawContainer.add(drawBehaviour);
		
		this.collidableContainer = collidableContainer;
		this.collidableBehaviour = behaviourFactory.createCollidableBehaviour(this);
		collidableContainer.add(collidableBehaviour);
	}
	
	public Rectangle getBounds()  {
		return new Rectangle((int) x, (int) y, width, height);
	}
	
	public void remove(){
		this.moveContainer.remove(moveBehaviour);
		this.drawContainer.remove(drawBehaviour);
		this.collidableContainer.remove(collidableBehaviour);
	}
	
	public void render(Graphics2D g2d) {
		g2d.setColor(Color.red);
		g2d.drawRect((int) x,(int) y, width, height);
		
		//get rotation angle depending on velocity
		double radians = Math.atan2(moveBehaviour.getVelY(), moveBehaviour.getVelX()) + Math.toRadians(90);
		
		//remember old transform to revert rotation on graphics
		AffineTransform originalTransform = g2d.getTransform();
		
		//rotate all the following graphic draw actions
		g2d.rotate(radians, getCenterObjectX((int) x), getCenterObjectY((int) y)); //make sure to give the center point of the image!!!
		
		//draw the image, while being rotated
		g2d.drawImage(img, (int) x, (int) y, null);
		
		//revert transform / rotation on graphics, so OTHER GAMEOBJECTS that get RENDERED, do NOT get rotated!
		g2d.setTransform(originalTransform);
	}
}
