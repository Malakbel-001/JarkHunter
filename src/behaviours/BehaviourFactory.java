package behaviours;

import model.GameObject;

public class BehaviourFactory {
	public DrawBehaviour createDrawBehaviour(GameObject object) {
		switch (object.getId()) {
			case BasicEnemy:
				DrawBehaviour drawBehaviour = new DrawBehaviour();
				drawBehaviour.registerBehaviour(object);
				return drawBehaviour;
			case Trail:
				return null; //TODO
			default:
				return null;
		}
	}
	public MoveBehaviour createMoveBehaviour(GameObject object) {
		switch (object.getId()) {
		case BasicEnemy:
			MoveBehaviour moveBehaviour = new MoveBehaviour();
			moveBehaviour.register(3, 3, object);
			
//			MoveTrailBehaviour moveTrailBehaviour = new MoveTrailBehaviour();
//			moveTrailBehaviour.register(3, 3, object, null);
			return moveBehaviour;
		default:
			return null;
		}
	}
	public CollidableBehaviour createCollidableBehaviour(GameObject object) {
		switch (object.getId()) {
		case BasicEnemy:
			CollidableBehaviour collidableBehaviour = new CollidableBehaviour();
			collidableBehaviour.registerBehaviour(object);
			return collidableBehaviour;
		default:
			return null;		
		}
	}
}
