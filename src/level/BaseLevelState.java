package level;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;

import factory.LevelFactory;
import factory.UnitFactory;
import model.Handler;

public abstract class BaseLevelState {
	protected final LevelFactory levelFactory;
	protected final UnitFactory unitFactory;
	
	protected final Handler handler;
	protected final Random random;
	protected Image img;
	
	public BaseLevelState(LevelFactory levelFactory, UnitFactory unitFactory, Handler handler, Random random) {
		this.levelFactory = levelFactory;
		this.unitFactory = unitFactory;
		this.handler = handler;
		this.random = random;
	}
	
	public abstract void initialize();

	public BaseLevelState changeLevel() {
		return levelFactory.nextLevel(this);
	}

	public void draw(Graphics2D g2d) {
		if(img != null) {
			g2d.drawImage(img, 0, 0, null);
		}
	}
}
