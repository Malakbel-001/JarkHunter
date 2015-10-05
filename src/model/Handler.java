package model;

import java.awt.Graphics2D;
import java.util.LinkedList;

import container.DrawContainer;
import container.MoveContainer;

public class Handler {
	
	private LinkedList<GameObject> objects = new LinkedList<GameObject>();
	private MoveContainer moveContainer = new MoveContainer();
	private DrawContainer drawContainer = new DrawContainer();
	
	public void tick(double delta){
		GameObject tempObject = null;
		
		for(int i = 0; i < objects.size(); i++){
			tempObject = objects.get(i);
			tempObject.tick();
		}
	}
	
	public void render(Graphics2D g2d){
		for(int i = 0; i < objects.size(); i++){
			GameObject tempObject = objects.get(i);
			
			tempObject.render(g2d);
		}
	}
	
	public void addObject(GameObject object){
		this.objects.add(object);
	}
	
	public void removeObject(GameObject object){
		this.objects.remove(object);
	}
	
	public LinkedList<GameObject> getObjectList(){
		return objects;
	}
}
