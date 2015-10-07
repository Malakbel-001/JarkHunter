package behaviour;

import java.awt.geom.AffineTransform;

import model.BasicEnemy;
import model.ID;
import model.ImageEnemy;

public class MoveImageBehaviour extends MoveBehaviour {
	private int presetRotationNumber;
	
	public void update(double delta) {
		this.superUpdate(delta);
		
		if(basicEnemy instanceof ImageEnemy) {
			//get rotation angle depending on velocity
			((ImageEnemy) this.basicEnemy).setRadians(Math.atan2(basicEnemy.getVelY(), basicEnemy.getVelX()) + Math.toRadians(presetRotationNumber));
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
	
	public void setPresetRotationNumber(int rotationNumber) {
		this.presetRotationNumber = rotationNumber;
	}
}
