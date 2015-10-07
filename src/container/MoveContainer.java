package container;

import java.util.LinkedList;

import behaviours.MoveBehaviour;

public class MoveContainer {
	private LinkedList<MoveBehaviour> moveBehaviours;
	
	public MoveContainer() {
		moveBehaviours = new LinkedList<MoveBehaviour>();
	}
	
	public void add(MoveBehaviour moveBehaviour) {
		moveBehaviours.add(moveBehaviour);
	}

	public void update(double delta) {
		for(MoveBehaviour move : moveBehaviours) {
			move.update(delta);
		}
		
//		for(int i = 0; i < objects.size(); i++){
//			tempObject = objects.get(i);
//			tempObject.tick();
//		}
	}
	
	public void remove(MoveBehaviour moveBehaviour) {
		moveBehaviours.remove(moveBehaviour);
	}
}
