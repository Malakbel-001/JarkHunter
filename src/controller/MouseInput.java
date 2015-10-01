package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.GameObject;
import model.ID;

public class MouseInput extends MouseAdapter {
	
	private Handler handler;
	
	public MouseInput(Handler handler){
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e){
//		e.getX();
//		e.getY();
		
		//handler.clicked(e.getX(), e.getY());
		//loop / factory to check Rectangle getbounds if we clicked something
		
		GameObject tempObject = null;
		for(int i = 0; i < handler.getObjectList().size(); i++){
			tempObject = handler.getObjectList().get(i);
			
			if(tempObject.getId() == ID.BasicEnemy){
				System.out.println("x Enemy: "+tempObject.getX());
				System.out.println("y Enemy: "+tempObject.getY());
				System.out.println("x Point: "+e.getX());
				System.out.println("y Point: "+e.getY());
				System.out.println("RectangleBool: "+tempObject.getBounds().contains(e.getPoint()));
				System.out.println("RectangleX: "+tempObject.getBounds().getMaxX());
				System.out.println("RectangleY: "+tempObject.getBounds().getMaxY());
				if(tempObject.getBounds().contains(e.getPoint())){
					System.out.println("Touched: "+tempObject.getId());
				}
			}
			
			//end
			tempObject = null;
		}
	}
	
}
