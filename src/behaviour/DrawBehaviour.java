package behaviour;

import java.awt.Color;
import java.awt.Graphics2D;

import model.GameObject;

public class DrawBehaviour extends Behaviour {

	public void update(final Graphics2D g2d) {
		g2d.setColor(Color.red);
		g2d.fillRect((int) object.getX(), (int) object.getY(), object.getWidth(), object.getHeight());
	}

	public void registerBehaviour(final GameObject object) {
		this.object = object;
	}
}
