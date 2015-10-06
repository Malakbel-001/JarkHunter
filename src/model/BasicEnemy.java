package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.Random;

import javax.swing.ImageIcon;

import behaviours.MoveWithTrailBehaviour;
import container.MoveContainer;
import controller.Game;

public class BasicEnemy extends GameObject {

	private MoveWithTrailBehaviour moveBehaviour;
	private MoveContainer moveContainer;
	
	public BasicEnemy(int x, int y, ID id, Handler handler, MoveWithTrailBehaviour move) {
		super(x, y, id);
		initialize(handler, move);
	}
	
	public BasicEnemy(Random random, ID id, Handler handler, MoveWithTrailBehaviour move) {
		super(0, 0, id);
		initialize(handler, move);
		initializeRandomSpawn(random);
	}
	
	private void initializeRandomSpawn(Random random) {
		x = random.nextInt(Game.WIDTH - width);
		y = random.nextInt((int) (Game.HEIGHT - (height*1.5)));
	}
	
	private void initialize(Handler handler, MoveWithTrailBehaviour moveBehaviour) {
		this.moveBehaviour = moveBehaviour;
		
		this.img = new ImageIcon(this.getClass().getResource("../images/chaser.png")).getImage();
		
		width = img.getWidth(null);
		height = img.getHeight(null);
	}
	
	public Rectangle getBounds()  {
		return new Rectangle((int) x, (int) y, width, height);
	}
	
	public void tick() {
		
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
