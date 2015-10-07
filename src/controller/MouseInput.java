//http://www.gameprogblog.com/generic-game-loop/#headingGame

package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Handler;

public class MouseInput extends MouseAdapter {

	private final Handler handler;

	public MouseInput(final Handler handler) {
		this.handler = handler;
	}

	@Override
	public void mousePressed(final MouseEvent e) {//Use Pressed not Clicked! Clicked doesn't work when moving while clicking...
		handler.addInput(e);
	}

}
