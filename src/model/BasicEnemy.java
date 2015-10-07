package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.Random;

import javax.swing.ImageIcon;

import behaviour.CollidableBehaviour;
import behaviour.DrawBehaviour;
import behaviour.MoveBehaviour;
import behaviour.TrailBehaviour;
import container.CollidableContainer;
import container.DrawContainer;
import container.MoveContainer;
import controller.Game;
import factory.BehaviourFactory;

public class BasicEnemy extends GameObject {

	protected int velX, velY;
	
	protected MoveContainer moveContainer;
	protected MoveBehaviour moveBehaviour;
	protected DrawContainer drawContainer;
	protected DrawBehaviour drawBehaviour;
	protected CollidableContainer collidableContainer;
	protected CollidableBehaviour collidableBehaviour;
	
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
	
	public void setVelX(int velX){
		this.velX = velX;
	}
	public void setVelY(int velY){
		this.velY = velY;
	}
	public int getVelX(){
		return velX;
	}
	public int getVelY(){
		return velY;
	}
}
