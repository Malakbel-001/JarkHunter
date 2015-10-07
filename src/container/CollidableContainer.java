package container;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import behaviour.CollidableBehaviour;
import model.Handler;
import model.State;

public class CollidableContainer {
	public ArrayList<CollidableBehaviour> collidableBehaviours;
	public Handler handler;

	public CollidableContainer(final Handler handler) {
		collidableBehaviours = new ArrayList<CollidableBehaviour>();
		this.handler = handler;
	}

	public void add(final CollidableBehaviour collidableBehaviour) {
		collidableBehaviours.add(collidableBehaviour);
	}

	public void remove(final CollidableBehaviour collidableBehaviour) {
		collidableBehaviours.remove(collidableBehaviours);
	}

	public void update(final LinkedList<MouseEvent> input) {
		for (final CollidableBehaviour coll : collidableBehaviours) {
			if (coll.getBounds().contains(input.peek().getPoint())) {
				if (coll.getObject().getState() == State.ALIVE) {
					coll.getObject().remove();
					handler.removeObject(coll.getObject());
					handler.score++;
				}
			}
		}
	}
}