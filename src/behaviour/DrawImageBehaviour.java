package behaviour;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import model.ImageEnemy;

public class DrawImageBehaviour extends DrawBehaviour {
	@Override
	public void update(final Graphics2D g2d) {
		g2d.setColor(Color.white);
		g2d.drawRect((int) object.getX(), (int) object.getY(), object.getWidth(), object.getHeight());
		if (object instanceof ImageEnemy) {
			//remember old transform to revert rotation on graphics
			final AffineTransform originalTransform = g2d.getTransform();

			//rotate all the following graphic draw actions
			g2d.rotate(((ImageEnemy) object).getRadians(), object.getCenterObjectX((int) object.getX()),
					object.getCenterObjectY((int) object.getY()));
					//make sure to give the center point of the image!

			//draw the image, while being rotated
			g2d.drawImage(((ImageEnemy) object).getImg(), (int) object.getX(), (int) object.getY(), null);

			//revert transform / rotation on graphics, so OTHER GAMEOBJECTS that get RENDERED, do NOT get rotated!
			g2d.setTransform(originalTransform);
		} else {
			try {
				throw new Exception();
			} catch (final Exception e) {
				e.printStackTrace();
				System.out.println("Not supposed to be used for something other than ImageEnemy");
			}
		}
	}
}
