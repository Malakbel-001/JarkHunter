package model;

import java.awt.Rectangle;
import java.util.Random;

import behaviour.CollidableBehaviour;
import behaviour.DrawBehaviour;
import behaviour.MoveBehaviour;
import container.CollidableContainer;
import container.DrawContainer;
import container.MoveContainer;
import controller.Game;
import factory.BehaviourFactory;

public class BasicEnemy extends GameObject {

	protected int velX, velY;

	protected MoveContainer moveContainer;
	protected MoveBehaviour moveBehaviour;
	protected DrawContainer drawContainer;
	protected DrawBehaviour drawBehaviour;
	protected CollidableContainer collidableContainer;
	protected CollidableBehaviour collidableBehaviour;

	public BasicEnemy(final Random random, final int width, final int height, final ID id,
			final BehaviourFactory behaviourFactory, final MoveContainer moveContainer,
			final DrawContainer drawContainer, final CollidableContainer collidableContainer) {
		super(0, 0, width, height, id);

		x = random.nextInt(Game.WIDTH - width);
		y = random.nextInt((int) (Game.HEIGHT - (height * 1.5)));

		this.moveContainer = moveContainer;
		this.moveBehaviour = behaviourFactory.createMoveBehaviour(this);
		moveContainer.add(moveBehaviour);

		this.drawContainer = drawContainer;
		this.drawBehaviour = behaviourFactory.createDrawBehaviour(this);
		drawContainer.add(drawBehaviour);

		this.collidableContainer = collidableContainer;
		this.collidableBehaviour = behaviourFactory.createCollidableBehaviour(this);
		collidableContainer.add(collidableBehaviour);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, width, height);
	}

	@Override
	public void remove() {
		this.moveContainer.remove(moveBehaviour);
		this.drawContainer.remove(drawBehaviour);
		this.collidableContainer.remove(collidableBehaviour);
		state = State.DEAD;
	}

	public void setVelX(final int velX) {
		this.velX = velX;
	}

	public void setVelY(final int velY) {
		this.velY = velY;
	}

	public int getVelX() {
		return velX;
	}

	public int getVelY() {
		return velY;
	}
}
