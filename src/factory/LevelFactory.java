package factory;

import java.util.ArrayList;
import java.util.Random;

import level.*;
import model.Handler;

public class LevelFactory {
	private ArrayList<BaseLevelState> levels;
	
	public LevelFactory() {
		this.levels = new ArrayList<BaseLevelState>();
	}
	
	public BaseLevelState initializeLevels(UnitFactory unitFactory, Handler handler, Random random) {
		this.levels.add(new GameLevel1(this, unitFactory, handler, random));
		this.levels.add(new GameLevel2(this, unitFactory, handler, random));
		this.levels.add(new GameLevel3(this, unitFactory, handler, random));
		return levels.get(0);
	}
	
	public BaseLevelState nextLevel(final BaseLevelState levelState) {
		int index = levels.indexOf(levelState);
		if(levels.size() == index + 1){
			return new FinishedState(null, null, null, null);
		}
		else {
			return levels.get(index+1);
		}
	}
	
	public BaseLevelState finished() {
		return null;
	}
	
}