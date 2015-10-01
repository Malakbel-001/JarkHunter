package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
	
	private Handler handler;
	
	public MouseInput(Handler handler){
		this.handler = handler;
	}
	
	public void mouseClicked(MouseEvent e){
//		e.getX();
//		e.getY();
		
		//handler.clicked(e.getX(), e.getY());
		//loop / factory to check Rectangle getbounds if we clicked something
	}
	
}
