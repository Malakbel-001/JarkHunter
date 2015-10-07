package behaviours;

import java.awt.geom.AffineTransform;

public class DrawImageBehaviour extends DrawBehaviour {
	public void update(double delta) {
//		//remember old transform to revert rotation on graphics
//		AffineTransform originalTransform = g2d.getTransform();
//		
//		//rotate all the following graphic draw actions
//		g2d.rotate(radians, getCenterObjectX((int) x), getCenterObjectY((int) y)); //make sure to give the center point of the image!!!
//		
//		//draw the image, while being rotated
//		g2d.drawImage(img, (int) x, (int) y, null);
//		
//		//revert transform / rotation on graphics, so OTHER GAMEOBJECTS that get RENDERED, do NOT get rotated!
//		g2d.setTransform(originalTransform);
	}
}
