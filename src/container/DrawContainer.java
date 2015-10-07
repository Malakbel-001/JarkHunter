package container;

import java.awt.Graphics2D;
import java.util.ArrayList;

import behaviour.DrawBehaviour;

public class DrawContainer {
	public ArrayList<DrawBehaviour> drawBehaviours;

	public DrawContainer() {
		drawBehaviours = new ArrayList<DrawBehaviour>();
	}

	public void add(final DrawBehaviour drawBehaviour) {
		drawBehaviours.add(drawBehaviour);
	}

	public void remove(final DrawBehaviour drawBehaviour) {
		drawBehaviours.remove(drawBehaviour);
	}

	public void update(final Graphics2D g2d) {
//		System.out.println(drawBehaviours.size());
		for (final DrawBehaviour drawBehaviour : drawBehaviours) {
			drawBehaviour.update(g2d);
		}
	}
}
