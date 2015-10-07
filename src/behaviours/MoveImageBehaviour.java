package behaviours;

import java.awt.geom.AffineTransform;

import model.BasicEnemy;
import model.ID;
import model.ImageEnemy;

public class MoveImageBehaviour extends MoveBehaviour {
	public void update(double delta) {
		this.superUpdate(delta);
		
		if(object.getId().equals(ID.ShipEnemy)) {
			//get rotation angle depending on velocity
			((ImageEnemy) this.object).setRadians(Math.atan2(this.getVelY(), this.getVelX()) + Math.toRadians(90));
		}
		else {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Not supposed to, ShipEnemy <-> BasicEnemy");
			}
		}
		
	}
}
