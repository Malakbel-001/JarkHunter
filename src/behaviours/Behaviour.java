package behaviours;

import model.GameObject;

public abstract class Behaviour {
	protected GameObject object;
	
	public abstract void update(double delta);
}