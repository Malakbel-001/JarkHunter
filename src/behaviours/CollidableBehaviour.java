package behaviours;

import java.awt.Rectangle;

import model.BasicEnemy;
import model.GameObject;

public class CollidableBehaviour extends Behaviour {
	protected BasicEnemy basicEnemy;
	
	public void registerBehaviour(BasicEnemy basicEnemy) {
		this.basicEnemy = basicEnemy;
	}
	
	public Rectangle getBounds() {
		return basicEnemy.getBounds();
	}
	
	public GameObject getObject() {
		return basicEnemy;
	}
}
