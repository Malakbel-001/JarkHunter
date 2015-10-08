package level;

import java.util.Random;

import javax.swing.ImageIcon;

import factory.LevelFactory;
import factory.UnitFactory;
import model.Handler;

public class GameLevel3 extends BaseLevelState {
	public GameLevel3(final LevelFactory levelFactory, final UnitFactory unitFactory, final Handler handler,
			final Random random) {
		super(levelFactory, unitFactory, handler, random);
		img = new ImageIcon(this.getClass().getResource("../images/NyanCatBackground.jpg")).getImage();
	}

	@Override
	public void initialize() {
		for (int i = 0; i < 3; i++) {
			handler.addObject(unitFactory.createRocketEnemy(random));
		}
	}
}
