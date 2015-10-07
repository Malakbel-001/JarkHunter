package container;

import java.awt.Graphics2D;
import java.util.ArrayList;

import behaviours.DrawBehaviour;

public class DrawContainer {
	public ArrayList<DrawBehaviour> drawBehaviours;
	
	public DrawContainer(){
		drawBehaviours = new ArrayList<DrawBehaviour>();
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
