package behaviour;

import controller.Game;
import model.BasicEnemy;

public class MoveBehaviour extends Behaviour {
	protected BasicEnemy basicEnemy;

	public void register(final int velX, final int velY, final BasicEnemy basicEnemy) {
		this.basicEnemy = basicEnemy;
		basicEnemy.setVelX(velX);
		basicEnemy.setVelY(velY);

		System.out.println("velX: " + velX);
		System.out.println("velY: " + velY);
	}

	public void update(final double delta) {
		this.superUpdate(delta);
	}

	protected void superUpdate(final double delta) {
		basicEnemy.setX((int) (basicEnemy.getX() + basicEnemy.getVelX() * delta));
		basicEnemy.setY((int) (basicEnemy.getY() + basicEnemy.getVelY() * delta));

		if (basicEnemy.getY() <= 0 || basicEnemy.getY() >= Game.HEIGHT - basicEnemy.getHeight() * 1.5) {
			basicEnemy.setVelY(basicEnemy.getVelY() * -1);
		}

		if (basicEnemy.getX() <= 0 || basicEnemy.getX() >= Game.WIDTH - basicEnemy.getWidth()) {
			basicEnemy.setVelX(basicEnemy.getVelX() * -1);
		}
	}
}
