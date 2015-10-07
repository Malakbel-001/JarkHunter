package behaviours;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import model.ImageEnemy;

public class DrawImageBehaviour extends DrawBehaviour {
	public void update(Graphics2D g2d) {
		this.superUpdate(g2d); //to be disabled
		if(object instanceof ImageEnemy) {
			//remember old transform to revert rotation on graphics
			AffineTransform originalTransform = g2d.getTransform();
			
			//rotate all the following graphic draw actions
			g2d.rotate(((ImageEnemy) object).getRadians(), object.getCenterObjectX((int) object.getX()), object.getCenterObjectY((int) object.getY())); 
			//make sure to give the center point of the image!
			
			//draw the image, while being rotated
			g2d.drawImage(((ImageEnemy) object).getImg(), (int) object.getX(), (int) object.getY(), null);
			
			//revert transform / rotation on graphics, so OTHER GAMEOBJECTS that get RENDERED, do NOT get rotated!
			g2d.setTransform(originalTransform);
		}
		else {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Not supposed to be used for something other than ImageEnemy");
			}
		}
	}
}
