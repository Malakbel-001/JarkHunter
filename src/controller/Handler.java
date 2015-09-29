package controller;

import java.awt.Graphics2D;
import java.util.LinkedList;

import model.GameObject;

public class Handler {
	
	private LinkedList<GameObject> object = new LinkedList<GameObject>();
	private Game game;
	
	public Handler(final Game game){
		this.game = game;
	}
	
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
			
			tempObject.render(g2d, game);
		}
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object);
	}

	public void clicked(final int x, final int y) {
		System.out.println(x);
		System.out.println(y);
	}
	
}
