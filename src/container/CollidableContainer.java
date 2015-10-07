package container;

import java.awt.event.MouseEvent;
import java.util.LinkedList;

import behaviours.CollidableBehaviour;
import model.BasicEnemy;
import model.Handler;

public class CollidableContainer {
	public LinkedList<CollidableBehaviour> collidableBehaviours;
	public Handler handler;
	
	public CollidableContainer(Handler handler){
		collidableBehaviours = new LinkedList<CollidableBehaviour>();
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
			}
		}
		
//		GameObject tempObject = null;
//		for(int i = 0; i < objects.size(); i++){
//			tempObject = objects.get(i);
//			
//			if(tempObject.getId() == ID.BasicEnemy){
//				if(tempObject.getBounds().contains(input.peek().getPoint())){
//					removeObject(tempObject);
//				}
//			}
//			
//			//end
//			tempObject = null;
//		}
//		input.poll();
	}
}