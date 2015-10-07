package container;

import java.util.ArrayList;

import behaviours.MoveBehaviour;

public class MoveContainer {
	private final ArrayList<MoveBehaviour> moveBehaviours;

	public MoveContainer() {
		moveBehaviours = new ArrayList<MoveBehaviour>();
	}

	public void add(final MoveBehaviour moveBehaviour) {
		moveBehaviours.add(moveBehaviour);
	}

	public void update(final double delta) {
		for (final MoveBehaviour move : moveBehaviours) {
			move.update(delta);
		}
	}

	public void remove(final MoveBehaviour moveBehaviour) {
		moveBehaviours.remove(moveBehaviour);
	}
}
