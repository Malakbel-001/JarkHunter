package behaviours;

import model.GameObject;

public class BehaviourFactory {
	public static DrawBehaviour createDrawBehaviour(GameObject object) {
		switch (object.getId()) {
			case BasicEnemy:
				return new DrawBehaviour();
			case Trail:
				return new DrawBehaviour();
			default:
				return null;
		}
	}
	public static MoveBehaviour createMoveBehaviour(GameObject object) {
		switch (object.getId()) {
		case BasicEnemy:
			MoveWithTrailBehaviour moveTrailBehaviour = new MoveWithTrailBehaviour();
			moveTrailBehaviour.register(3, 3, object);
			return new MoveBehaviour();
		case Trail:
			
			return new MoveWithTrailBehaviour();
		default:
			return null;
		}
	}
	public static CollidableBehaviour createCollidableBehaviour(GameObject object) {
		switch (object.getId()) {
		case BasicEnemy:
			return new CollidableBehaviour();
		case Trail:
			return new CollidableBehaviour();
		default:
			return new CollidableBehaviour();		
		}
	}
}
