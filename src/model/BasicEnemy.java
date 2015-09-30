package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

import controller.Game;
import controller.Handler;

public class BasicEnemy extends GameObject {

	private Handler handler;
	
	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.img = new ImageIcon(this.getClass().getResource("../images/chaser.png")).getImage();
		
		velX = 1;
		velY = 1;
		
		width = 48;
		height = 48;
		
		this.handler = handler;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, width, height);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 48) {
			velY *= -1;
		}
		
		if(x <= 0 || x >= Game.WIDTH - 24) {
			velX *= -1;
		}
		
//		handler.addObject(new Trail(x, y, ID.Trail, Color.red, width, height, 0.03f, handler));
		handler.addObject(new Trail(x, y, ID.Trail, Color.blue, (int) (width * 0.25), (int) (height * 0.25), 0.03f, handler));
		handler.addObject(new Trail((int) calculatePlacementTrailX(), (int) calculatePlacementTrailY(), ID.Trail, Color.orange, (int) (width * 0.25), (int) (height * 0.25), 0.03f, handler));
		System.out.println("VelX: "+ velX);
		System.out.println("VelY: "+ velY);
		System.out.println("X: "+(int) (x-calculatePlacementTrailX()));
		System.out.println("Y: "+(int) (y-calculatePlacementTrailY()));
	}
	
	/**
	 * 	formula for getting x and y depending on r, t and h or k
		r = radius length
		t = angle in radians
		h = x position circle center
		k = y position circle center
		http://stackoverflow.com/questions/5300938/calculating-the-position-of-points-in-a-circle
		
		float x = r*cos(t) + h;
		float y = r*sin(t) + k;
	 */
	protected double calculatePlacementTrailX(){

		double radians = Math.atan2(velY, velX) + Math.toRadians(0); //rotation depending on graphics formula
		return (width*0.5)*Math.sin(Math.toDegrees(radians)) + getCenterObjectX(x); //
	}
	
	protected double calculatePlacementTrailY(){
		double radians = Math.atan2(velY, velX) + Math.toRadians(0); //rotation depending on graphics formula
		return (height*0.5)*Math.cos(Math.toDegrees(radians)) + getCenterObjectX(y);
	}
	
	public void render(Graphics2D g2d, ImageObserver o) {
//		g.setColor(Color.red);
//		g.fillRect(x, y, width, height);
		
//		double radians = Math.atan2(velY, velX) + constant number to fix rotation;
		
		//get rotation angle depending on velocity
		double radians = Math.atan2(velY, velX) + Math.toRadians(90);
		
		//remember old transform to revert rotation on graphics
		AffineTransform originalTransform = g2d.getTransform();
		
		//rotate all the following graphic draw actions
		g2d.rotate(radians, getCenterObjectX(x), getCenterObjectY(y)); //make sure to give the center point of the image!!!
		
		//draw the image, while being rotated
		g2d.drawImage(img, x, y, o);
		
		//revert transform / rotation on graphics, so OTHER GAMEOBJECTS that get RENDERED, do NOT get rotated!
		g2d.setTransform(originalTransform);
	}
	
}
