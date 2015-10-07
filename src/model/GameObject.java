package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import behaviours.CollidableBehaviour;
import behaviours.DrawBehaviour;
import behaviours.MoveBehaviour;
import container.CollidableContainer;
import container.DrawContainer;
import container.MoveContainer;

public abstract class GameObject {
	
	protected double x, y; // can only be used by stuff that extends GameObject
	protected ID id;
	protected int width, height;
	protected Image img;
	
	public GameObject(int x, int y, int width, int height, ID id){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;
	}
	
	public abstract void remove();
	
	public double getCenterObjectX(int x){
		return x+width*0.5;
	}
	public double getCenterObjectY(int y){
		return y+height*0.5;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public void setId(ID id){
		this.id = id;
	}
	public ID getId(){
		return id;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public void setWidth(int width){
		this.width = width;
	}
	public void setHeight(int height){
		this.height = height;
	}
}
