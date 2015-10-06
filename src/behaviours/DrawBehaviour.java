package behaviours;

import java.awt.Graphics2D;

import container.DrawContainer;
import model.GameObject;

public class DrawBehaviour extends Behaviour {
	
	public DrawContainer drawContainer;
	
	public void update(double delta, Graphics2D g2d) {
		
	}

	public void registerBehaviour(GameObject object, DrawContainer drawContainer) {
		this.object = object;
		this.drawContainer = drawContainer;
	}
	
	public static DrawBehaviour registerTrailBehaviour() {
		return new DrawBehaviour(); //temp
	}

	public void update(double delta) { //WHHYYYYY. idk
		
	}
}
