package behaviour;

import model.ImageEnemy;

public class MoveImageBehaviour extends MoveBehaviour {
	private int presetRotationNumber;

	@Override
	public void update(final double delta) {
		this.superUpdate(delta);

		if (basicEnemy instanceof ImageEnemy) {
			//get rotation angle depending on velocity
			((ImageEnemy) this.basicEnemy).setRadians(
					Math.atan2(basicEnemy.getVelY(), basicEnemy.getVelX()) + Math.toRadians(presetRotationNumber));
		} else {
			try {
				throw new Exception();
			} catch (final Exception e) {
				e.printStackTrace();
				System.out.println("Not supposed to be used for something other than ImageEnemy");
			}
		}
	}

	public void setPresetRotationNumber(final int rotationNumber) {
		this.presetRotationNumber = rotationNumber;
	}
}
