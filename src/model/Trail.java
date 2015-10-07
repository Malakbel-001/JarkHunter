package model;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject {
	public Trail(int x, int y, int width, int height, ID id) {
		super(x, y, width, height, id);
		// TODO Auto-generated constructor stub
	}

	private float alpha = 1;
	private float life;
	
	private Handler handler;
	private Color color;
	
//	public Trail(int x, int y, ID id, Color color, int width, int height, float life, Handler handler) {
//		super(x, y, id);
//		this.handler = handler;
//		this.color = color;
//		this.width = width;
//		this.height = height;
//		this.life = life;
//	}

//	public Trail(int x, int y, ID id) {
//		super(x, y, id);
//	}

	public void tick() {
		if(alpha > life){
			alpha -= (life - 0.0001f);
		}
		else {
			handler.removeObject(this);
		}
	}
	
	public void render(Graphics2D g2d) {
		g2d.setComposite(makeTransparent(alpha));
		
		g2d.setColor(color);
		g2d.fillRect((int) x, (int) y, width, height);
		
		g2d.setComposite(makeTransparent(1));
	}
	
	private AlphaComposite makeTransparent(float alpha){
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}
	
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}
