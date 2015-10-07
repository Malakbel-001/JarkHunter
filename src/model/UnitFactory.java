package model;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

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
		for(int i = 0; i < 2; i++){
			handler.addObject(this.createShipEnemy(random));
		}
	}
	
	public BasicEnemy createBasicEnemy(Random random){
		return new BasicEnemy(random, 48, 48, ID.BasicEnemy, behaviourFactory, handler.getMoveContainer(), handler.getDrawContainer(), handler.getCollidableContainer());
	}
	
	public ImageEnemy createShipEnemy(Random random){
		Image img = new ImageIcon(this.getClass().getResource("../images/chaser.png")).getImage();
		
		return new ImageEnemy(img, random, img.getWidth(null), img.getHeight(null), ID.ShipEnemy, behaviourFactory, handler.getMoveContainer(), handler.getDrawContainer(), handler.getCollidableContainer());
	}
}
