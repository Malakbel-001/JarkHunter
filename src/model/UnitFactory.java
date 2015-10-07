package model;

import java.util.Random;

import behaviours.BehaviourFactory;

public class UnitFactory {
	private Handler handler;
	private BehaviourFactory behaviourFactory;
	private Random random;
	
	public UnitFactory(Handler handler, BehaviourFactory behaviourFactory) {
		this.handler = handler;
		this.behaviourFactory = behaviourFactory;
		random = new Random();
	}
	
	public void createLevel1(){
		for(int i = 0; i < 5; i++){
			handler.addObject(this.createBasicEnemy(random));
		}
	}
	
	public BasicEnemy createBasicEnemy(Random random){
		return new BasicEnemy(random, 48, 48, ID.BasicEnemy, behaviourFactory, handler.getMoveContainer(), handler.getDrawContainer(), handler.getCollidableContainer());
	}
}
