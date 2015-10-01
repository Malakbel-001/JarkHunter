package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.GameObject;
import model.Handler;
import model.ID;

public class MouseInput extends MouseAdapter {
	
	private Handler handler;
	
	public MouseInput(Handler handler){
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e){ //Use Pressed not Clicked! Clicked doesn't work when moving while clicking...
//		e.getX();
//		e.getY();
		
		//handler.clicked(e.getX(), e.getY());
		//loop / factory to check Rectangle getbounds if we clicked something
		
		GameObject tempObject = null;
		for(int i = 0; i < handler.getObjectList().size(); i++){
			tempObject = handler.getObjectList().get(i);
			
			if(tempObject.getId() == ID.BasicEnemy){
				if(tempObject.getBounds().contains(e.getPoint())){
					handler.removeObject(tempObject);
				}
			}
			
			//end
			tempObject = null;
		}
	}
	
}
