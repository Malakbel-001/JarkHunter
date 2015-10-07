package model;

import java.awt.Graphics2D;
import java.util.LinkedList;

import container.CollidableContainer;
import container.DrawContainer;
import container.MoveContainer;

public class Handler {
	
	private LinkedList<GameObject> objects;
	private DrawContainer drawContainer;
	private MoveContainer moveContainer;
	private CollidableContainer collidableContainer;
	
	public Handler(){
		objects = new LinkedList<GameObject>();
		drawContainer = new DrawContainer();
		moveContainer = new MoveContainer();
		collidableContainer = new CollidableContainer();
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
	public MoveContainer getMoveContainer(){
		return moveContainer;
	}
	public DrawContainer getDrawContainer(){
		return drawContainer;
	}
	public CollidableContainer getCollidableContainer(){
		return collidableContainer;
	}
}
