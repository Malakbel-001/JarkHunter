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
		
		velX = 3;
		velY = 3;
		
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
		handler.addObject(new Trail(x, y, ID.Trail, Color.orange, (int) (width * 0.25), (int) (height * 0.25), 0.03f, handler));
	}

	public void render(Graphics2D g2d, ImageObserver o) {
//		g.setColor(Color.red);
//		g.fillRect(x, y, width, height);
		
//		double radians = Math.atan2(velY, velX) + constant number to fix rotation;
		double radians = Math.atan2(velY, velX) + Math.toRadians(90);
		AffineTransform originalTransform = g2d.getTransform();
		g2d.rotate(radians, x+20, y+20); //make sure to give the center point of the image!!!
		g2d.drawImage(img, x, y, o);
		g2d.setTransform(originalTransform);
	}
	
}
