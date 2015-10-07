package container;

import java.awt.Graphics2D;
import java.util.LinkedList;

import behaviours.DrawBehaviour;

public class DrawContainer {
	public LinkedList<DrawBehaviour> drawBehaviours;
	
	public DrawContainer(){
		drawBehaviours = new LinkedList<DrawBehaviour>();
	}
	
	public void add(DrawBehaviour drawBehaviour) {
		drawBehaviours.add(drawBehaviour);
	}
	
	public void remove(DrawBehaviour drawBehaviour) {
		drawBehaviours.remove(drawBehaviour);
	}

	public void update(Graphics2D g2d) {
//		System.out.println(drawBehaviours.size());
		for(DrawBehaviour drawBehaviour : drawBehaviours) {
			drawBehaviour.update(g2d);
		}
	}
}
