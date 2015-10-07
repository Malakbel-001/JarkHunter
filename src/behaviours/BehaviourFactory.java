package behaviours;

import model.BasicEnemy;
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
				drawBehaviour.registerBehaviour(object);
				break;
			case RocketEnemy:
				drawBehaviour = new DrawImageBehaviour();
				drawBehaviour.registerBehaviour(object);
				break;
			case Trail:
				break; //TODO
			default:
				break;
		}
		return drawBehaviour;
	}
	public MoveBehaviour createMoveBehaviour(BasicEnemy basicEnemy) {
		MoveBehaviour moveBehaviour = null;
		switch (basicEnemy.getId()) {
			case BasicEnemy:
				moveBehaviour = new MoveBehaviour();
				moveBehaviour.register(3, 3, basicEnemy);
				
	//			MoveTrailBehaviour moveTrailBehaviour = new MoveTrailBehaviour();
	//			moveTrailBehaviour.register(3, 3, object, null);
				break;
			case ShipEnemy:
				moveBehaviour = new MoveImageBehaviour();
				moveBehaviour.register(2, 4, basicEnemy);
				break;
			case RocketEnemy:
				moveBehaviour = new MoveImageBehaviour();
				moveBehaviour.register(7, 2, basicEnemy);
				break;
			default:
				break;
		}
		return moveBehaviour;
	}
	public CollidableBehaviour createCollidableBehaviour(BasicEnemy basicEnemy) {
		CollidableBehaviour collidableBehaviour = null;
		switch (basicEnemy.getId()) {
			case BasicEnemy:
				collidableBehaviour = new CollidableBehaviour();
				collidableBehaviour.registerBehaviour(basicEnemy);
				break;
			case ShipEnemy:
				collidableBehaviour = new CollidableBehaviour();
				collidableBehaviour.registerBehaviour(basicEnemy);
				break;
			case RocketEnemy:
				collidableBehaviour = new CollidableBehaviour();
				collidableBehaviour.registerBehaviour(basicEnemy);
				break;
			default:
				break;
		}
		return collidableBehaviour;
	}
//	public TrailBehaviour createTrailBehaviour() {
//		
//	}
}
