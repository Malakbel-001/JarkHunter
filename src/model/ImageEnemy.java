package model;

import java.awt.Image;
import java.util.Random;

import behaviour.MoveImageBehaviour;
import container.CollidableContainer;
import container.DrawContainer;
import container.MoveContainer;
import factory.BehaviourFactory;

public class ImageEnemy extends BasicEnemy {

	protected Image img;
	protected double radians = 0;

	public ImageEnemy(final Image img, final Random random, final int width, final int height, final ID id,
			final BehaviourFactory behaviourFactory, final MoveContainer moveContainer,
			final DrawContainer drawContainer, final CollidableContainer collidableContainer,
			final int presetRotationNumber) {
		super(random, width, height, id, behaviourFactory, moveContainer, drawContainer, collidableContainer);
		this.img = img;
		((MoveImageBehaviour) this.moveBehaviour).setPresetRotationNumber(presetRotationNumber);
	}

	public double getRadians() {
		return this.radians;
	}

	public void setRadians(final double radians) {
		this.radians = radians;
	}

	public Image getImg() {
		return img;
	}
}
