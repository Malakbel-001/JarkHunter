package com.jarkhunt.main;

import java.awt.Graphics;
import java.util.LinkedList;

import Model.GameObject;

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick(){
		GameObject tempObject = null;
		for(int i = 0; i < object.size(); i++){
			tempObject = object.get(i);
			tempObject.tick();
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			//enemyobject
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	public void addObjectFirst(GameObject object){
		this.object.addFirst(object);
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	
}
