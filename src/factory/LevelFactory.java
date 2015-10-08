package factory;

import java.util.ArrayList;
import java.util.Random;

import level.BaseLevelState;
import level.FinishedState;
import level.GameLevel1;
import level.GameLevel2;
import level.GameLevel3;
import model.Handler;

public class LevelFactory {
	private final ArrayList<BaseLevelState> levels;

	public LevelFactory() {
		this.levels = new ArrayList<BaseLevelState>();
	}

	public BaseLevelState initializeLevels(final UnitFactory unitFactory, final Handler handler, final Random random) {
		this.levels.add(new GameLevel1(this, unitFactory, handler, random));
		this.levels.add(new GameLevel2(this, unitFactory, handler, random));
		this.levels.add(new GameLevel3(this, unitFactory, handler, random));
		return levels.get(0);
	}

	public BaseLevelState nextLevel(final BaseLevelState levelState) {
		final int index = levels.indexOf(levelState);
		if (levels.size() == index + 1) {
			return new FinishedState(null, null, null, null);
		} else {
			return levels.get(index + 1);
		}
	}

	public BaseLevelState finished() {
		return null;
	}

}