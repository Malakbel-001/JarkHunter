package container;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import behaviours.CollidableBehaviour;
import model.Handler;

public class CollidableContainer {
	public ArrayList<CollidableBehaviour> collidableBehaviours;
	public Handler handler;
	
	public CollidableContainer(Handler handler){
		collidableBehaviours = new ArrayList<CollidableBehaviour>();
		this.handler = handler;
	}
	
	public void add(CollidableBehaviour collidableBehaviour) {
		collidableBehaviours.add(collidableBehaviour);
	}

	public void remove(CollidableBehaviour collidableBehaviour) {
		collidableBehaviours.remove(collidableBehaviours);
	}
	
	public void update(LinkedList<MouseEvent> input) {
		for(CollidableBehaviour coll : collidableBehaviours) {
			if(coll.getBounds().contains(input.peek().getPoint())){
				coll.getObject().remove();
				handler.removeObject(coll.getObject());
				handler.score++;
			}
		}
	}
}