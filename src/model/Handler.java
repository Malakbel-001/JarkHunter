package model;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import container.CollidableContainer;
import container.DrawContainer;
import container.MoveContainer;

public class Handler {
	

	private LinkedList<GameObject> objects;
	private LinkedList<MouseEvent> input;

	private DrawContainer drawContainer;
	private MoveContainer moveContainer;
	private CollidableContainer collidableContainer;
	private int score = 0;

	
	public Handler(){
		objects = new LinkedList<GameObject>();
		input = new LinkedList<MouseEvent>();
		drawContainer = new DrawContainer();
		moveContainer = new MoveContainer();
		collidableContainer = new CollidableContainer();
	}
	
	public void tick(double delta){
		moveContainer.update(delta);
	}
	
	public void render(Graphics2D g2d){
//		drawContainer.update(g2d);
		
		for(int i = 0; i < objects.size(); i++){
			GameObject tempObject = objects.get(i);
			
			tempObject.render(g2d);
		}
	}
	
	public void handleInput(){
		while (input.size() > 0) {
			//input.poll();
			
			
			GameObject tempObject = null;
			for(int i = 0; i < objects.size(); i++){
				tempObject = objects.get(i);
				
				if(tempObject.getId() == ID.BasicEnemy){
					if(tempObject.getBounds().contains(input.peek().getPoint())){
						removeObject(tempObject);
						score++;
					}
				}
				
				//end
				tempObject = null;
			}
			input.poll();
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
	
	public void addInput(MouseEvent e){
		input.add(e);
	}
	
	public LinkedList<MouseEvent> getInput(){
		return input;
	}
	
	public int getScore(){
		return score;
	}
}
