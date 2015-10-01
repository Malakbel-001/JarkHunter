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
	
	private int angle = 0;
	private int angle2 = 0;
	private int angleVel = 5;
	
	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.img = new ImageIcon(this.getClass().getResource("../images/chaser.png")).getImage();
		
		velX = 1;
		velY = 1;
		
		width = img.getWidth(null);
		height = img.getHeight(null);
		
		this.handler = handler;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, width, height);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		angle += angleVel;
		angle2 += angleVel;
		
		if(angle >= 360) {
			angle = 0;
		}
		
		if(angle2 >= 360) {
			angle2 = 0;
		}
		
		if(y <= 0 || y >= Game.HEIGHT - height*1.5) {
			velY *= -1;
		}
		
		if(x <= 0 || x >= Game.WIDTH - width) {
			velX *= -1;
		}
		
//		handler.addObject(new Trail(x, y, ID.Trail, Color.red, width, height, 0.03f, handler));
		
		//best I could manage for now
		handler.addObject(new Trail((int) calculatePlacementTrailX(), (int) calculatePlacementTrailY(), ID.Trail, Color.orange, (int) (width * 0.25), (int) (height * 0.25), 0.03f, handler));
		
		//cool result, very interesting. Not yet working as intended, but still =P
//		handler.addObject(new Trail((int) calculateWavePattern1X(), (int) calculateWavePattern1Y(), ID.Trail, Color.orange, (int) (width * 0.1), (int) (height * 0.1), 0.03f, handler));
//		handler.addObject(new Trail((int) calculateWavePattern2X(), (int) calculateWavePattern2Y(), ID.Trail, Color.orange, (int) (width * 0.1), (int) (height * 0.1), 0.03f, handler));
	}
	
	public void render(Graphics2D g2d, ImageObserver o) {
		g2d.setColor(Color.red);
//		g.fillRect(x, y, width, height);
		g2d.drawRect(x, y, width, height);
		
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
		double radians = Math.atan2(velY, velX) + Math.toRadians(180); //rotation depending on graphics formula
//		return (width*0.5)*Math.sin(Math.toDegrees(radians)) + getCenterObjectX(x);
		return ((width*0.5)-20)*Math.cos(radians) + getCenterObjectX(x);
//		return ((width*0.5))*Math.cos(Math.toRadians(angle)) + getCenterObjectX(x);
	}
	
	protected double calculatePlacementTrailY(){
		double radians = Math.atan2(velY, velX) + Math.toRadians(180); //rotation depending on graphics formula
		return ((height*0.5)-20)*Math.cos(Math.toDegrees(radians)) + getCenterObjectX(y);
//		return ((height*0.5))*Math.sin(Math.toRadians(angle)) + getCenterObjectX(y);
	}
	
	protected double calculateWavePattern1X(){
		return ((width*0.5))*Math.cos(Math.toRadians(angle)) + getCenterObjectX(x);
	}
	
	protected double calculateWavePattern1Y(){
		return ((height*0.5))*Math.sin(Math.toRadians(angle)) + getCenterObjectX(y);
	}
	
	protected double calculateWavePattern2X(){
		return ((width*0.5))*Math.sin(Math.toRadians(angle2)) + getCenterObjectX(x);
	}
	
	protected double calculateWavePattern2Y(){
		return ((height*0.5))*Math.cos(Math.toRadians(angle2)) + getCenterObjectX(y);
	}
}
