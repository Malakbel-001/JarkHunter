package factory;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

import model.BasicEnemy;
import model.Handler;
import model.ID;
import model.ImageEnemy;

public class UnitFactory {
	private final Handler handler;
	private final BehaviourFactory behaviourFactory;

	public UnitFactory(final Handler handler, final BehaviourFactory behaviourFactory) {
		this.handler = handler;
		this.behaviourFactory = behaviourFactory;
	}

	public BasicEnemy createBasicEnemy(final Random random) {
		return new BasicEnemy(random, 48, 48, ID.BasicEnemy, behaviourFactory, handler.getMoveContainer(),
				handler.getDrawContainer(), handler.getCollidableContainer());
	}

	public ImageEnemy createShipEnemy(final Random random) {
		final Image img = new ImageIcon(this.getClass().getResource("../images/chaser.png")).getImage();

		return new ImageEnemy(img, random, img.getWidth(null), img.getHeight(null), ID.ShipEnemy, behaviourFactory,
				handler.getMoveContainer(), handler.getDrawContainer(), handler.getCollidableContainer(), 90);
	}

	public ImageEnemy createRocketEnemy(final Random random) {
		final Image img = new ImageIcon(this.getClass().getResource("../images/rocket-md.png")).getImage();

		return new ImageEnemy(img, random, img.getWidth(null), img.getHeight(null), ID.RocketEnemy, behaviourFactory,
				handler.getMoveContainer(), handler.getDrawContainer(), handler.getCollidableContainer(), 0);
	}
}
