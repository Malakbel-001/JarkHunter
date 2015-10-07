package behaviours;

import model.GameObject;

public class BehaviourFactory {
	public DrawBehaviour createDrawBehaviour(GameObject object) {
		DrawBehaviour drawBehaviour = null;
		switch (object.getId()) {
			case BasicEnemy:
				drawBehaviour = new DrawBehaviour();
				drawBehaviour.registerBehaviour(object);
				break;
			case ShipEnemy:
				drawBehaviour = new DrawImageBehaviour();
				drawBehaviour.registerBehaviour(object); //I hope this works TODO
				break;
			case Trail:
				break; //TODO
			default:
				break;
		}
		return drawBehaviour;
	}
	public MoveBehaviour createMoveBehaviour(GameObject object) {
		MoveBehaviour moveBehaviour = null;
		switch (object.getId()) {
			case BasicEnemy:
				moveBehaviour = new MoveBehaviour();
				moveBehaviour.register(3, 3, object);
				
	//			MoveTrailBehaviour moveTrailBehaviour = new MoveTrailBehaviour();
	//			moveTrailBehaviour.register(3, 3, object, null);
				break;
			case ShipEnemy:
				moveBehaviour = new MoveImageBehaviour();
				moveBehaviour.register(5, 3, object); //I hope this works TODO
			default:
				break;
		}
		return moveBehaviour;
	}
	public CollidableBehaviour createCollidableBehaviour(GameObject object) {
		CollidableBehaviour collidableBehaviour = null;
		switch (object.getId()) {
			case BasicEnemy:
				collidableBehaviour = new CollidableBehaviour();
				collidableBehaviour.registerBehaviour(object);
				break;
			case ShipEnemy:
				collidableBehaviour = new CollidableBehaviour();
				collidableBehaviour.registerBehaviour(object);
				break;
			default:
				break;
		}
		return collidableBehaviour;
	}
}
