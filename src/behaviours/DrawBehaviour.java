package behaviours;

import java.awt.Graphics2D;

import model.GameObject;

public class DrawBehaviour extends Behaviour {
	
	public void update(double delta, Graphics2D g2d) {
		
	}

	public void registerBehaviour(GameObject object) {
		this.object = object;
	}
	
	public void update(double delta) { //WHHYYYYY. idk
		
	}
}
