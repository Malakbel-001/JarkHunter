package model;

import java.awt.Graphics2D;
import java.util.LinkedList;

import container.CollidableContainer;
import container.DrawContainer;
import container.MoveContainer;

public class Handler {
	
	private LinkedList<GameObject> objects = new LinkedList<GameObject>();
	private DrawContainer drawContainer = new DrawContainer();
	private MoveContainer moveContainer = new MoveContainer();
	private CollidableContainer collidableContainer = new CollidableContainer();
	
	public Handler(){
		DrawContainer drawContainer = new DrawContainer();
		MoveContainer moveContainer = new MoveContainer();
		CollidableContainer collidableContainer = new CollidableContainer();
	}
	
	public void tick(double delta){
		moveContainer.update(delta);
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
