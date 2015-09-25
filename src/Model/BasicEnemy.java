package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.jarkhunt.main.Handler;
import com.jarkhunt.main.ID;

import controller.Game;

public class BasicEnemy extends GameObject {

	private Handler handler;
	
	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		velX = 3;
		velY = 3;
		
		width = 32;
		height = 32;
		
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
		handler.addObject(new Trail(x, y, ID.Trail, Color.orange, (int) (width * 0.5), (int) (height * 0.5), 0.03f, handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}
	
}
