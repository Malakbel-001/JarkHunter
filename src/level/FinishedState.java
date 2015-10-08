package level;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import controller.Game;
import factory.LevelFactory;
import factory.UnitFactory;
import model.Handler;

public class FinishedState extends BaseLevelState {

	public FinishedState(LevelFactory levelFactory, UnitFactory unitFactory, Handler handler, Random random) {
		super(levelFactory, unitFactory, handler, random);
	}

	@Override
	public void initialize() {
		
	}
	
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, Game.WIDTH, Game.HEIGHT+50);
	}
}
