package behaviours;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import model.GameObject;

public class DrawBehaviour extends Behaviour {
	
	public void update(Graphics2D g2d) {
		this.superUpdate(g2d);
	}
	
	protected void superUpdate(Graphics2D g2d) {
		g2d.setColor(Color.red);
		g2d.drawRect((int) object.getX(),(int) object.getY(), object.getWidth(), object.getHeight());
	}

	public void registerBehaviour(GameObject object) {
		this.object = object;
	}
}
