package model;

import java.awt.Event;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class Handler {
	
	private LinkedList<GameObject> object = new LinkedList<GameObject>();
	private LinkedList<MouseEvent> input = new LinkedList<MouseEvent>();
	
	public void tick(){
		GameObject tempObject = null;
		for(int i = 0; i < object.size(); i++){
			tempObject = object.get(i);
			tempObject.tick();
		}
	}
	
	public void render(Graphics2D g2d){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.render(g2d);
		}
	}
	
	public void handleInput(){
		while (input.size() > 0) {
			//input.poll();
			
			
			GameObject tempObject = null;
			for(int i = 0; i < object.size(); i++){
				tempObject = object.get(i);
				
				if(tempObject.getId() == ID.BasicEnemy){
					if(tempObject.getBounds().contains(input.peek().getPoint())){
						removeObject(tempObject);
					}
				}
				
				//end
				tempObject = null;
			}
			input.poll();
		}
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	
	public LinkedList<GameObject> getObjectList(){
		return object;
	}
	
	public void addInput(MouseEvent e){
		input.add(e);
	}
	
	public LinkedList<MouseEvent> getInput(){
		return input;
	}
}
