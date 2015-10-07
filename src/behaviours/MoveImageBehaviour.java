package behaviours;

import java.awt.geom.AffineTransform;

import model.BasicEnemy;
import model.ID;
import model.ShipEnemy;

public class MoveImageBehaviour extends MoveBehaviour {
	public void update(double delta) {
		this.superUpdate(delta);
		
		if(object.getId().equals(ID.BasicEnemy)) {
			//get rotation angle depending on velocity
			double radians = Math.atan2(this.getVelY(), this.getVelX()) + Math.toRadians(90);
			
			
			
			
			((ShipEnemy) this.object).getRadians();
		}
		
	}
}
