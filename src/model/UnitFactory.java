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
		for(int i = 0; i < 1; i++){
			handler.addObject(this.createBasicEnemy(random));
		}
		for(int i = 0; i < 1; i++){
			handler.addObject(this.createShipEnemy(random));
		}
		for(int i = 0; i < 1; i++){
			handler.addObject(this.createRocketEnemy(random));
		}
	}
	
	public BasicEnemy createBasicEnemy(Random random){
		return new BasicEnemy(random, 48, 48, ID.BasicEnemy, behaviourFactory, handler.getMoveContainer(), handler.getDrawContainer(), handler.getCollidableContainer());
	}
	
	public ImageEnemy createShipEnemy(Random random){
		Image img = new ImageIcon(this.getClass().getResource("../images/chaser.png")).getImage();
		
		return new ImageEnemy(img, random, img.getWidth(null), img.getHeight(null), ID.ShipEnemy, behaviourFactory, 
				handler.getMoveContainer(), handler.getDrawContainer(), handler.getCollidableContainer(), 90);
	}
	
	public ImageEnemy createRocketEnemy(Random random){
		Image img = new ImageIcon(this.getClass().getResource("../images/rocket-md.png")).getImage();
		
		return new ImageEnemy(img, random, img.getWidth(null), img.getHeight(null), ID.RocketEnemy, behaviourFactory, 
				handler.getMoveContainer(), handler.getDrawContainer(), handler.getCollidableContainer(), 0);
	}
}
