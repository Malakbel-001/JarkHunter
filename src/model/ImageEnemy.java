package model;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

import behaviour.MoveImageBehaviour;
import container.CollidableContainer;
import container.DrawContainer;
import container.MoveContainer;
import controller.Game;
import factory.BehaviourFactory;

public class ImageEnemy extends BasicEnemy {
	
	protected Image img;
	protected double radians = 0;
	
	public ImageEnemy(Image img, Random random, int width, int height, ID id, BehaviourFactory behaviourFactory,
			MoveContainer moveContainer, DrawContainer drawContainer, CollidableContainer collidableContainer, int presetRotationNumber) {
		super(random, width, height, id, behaviourFactory, moveContainer, drawContainer, collidableContainer);
		this.img = img;
		((MoveImageBehaviour) this.moveBehaviour).setPresetRotationNumber(presetRotationNumber);
	}

	public double getRadians() {
		return this.radians;
	}
	public void setRadians(double radians) {
		this.radians = radians;
	}
	public Image getImg() {
		return img;
	}
}
