package behaviours;

import java.awt.Color;

import container.DrawContainer;
import container.MoveContainer;
import controller.Game;
import model.GameObject;
import model.Handler;
import model.ID;
import model.Trail;

public class TrailBehaviour extends Behaviour{
	protected MoveContainer moveContainer;
	protected DrawContainer drawContainer;
	protected BehaviourFactory behaviourFactory;
	
	private int angle = 0;
	private int angleVel = 5;
	
	public void register(GameObject object, DrawContainer drawContainer, BehaviourFactory behaviourFactory) {
		this.object = object;
		this.drawContainer = drawContainer;
		this.behaviourFactory = behaviourFactory;
	}
	
	public void update(double delta) {
		angle += angleVel;
		
		if(angle >= 360) {
			angle = 0;
		}
		
//		handler.addObject(new Trail(x, y, ID.Trail, Color.red, width, height, 0.03f, handler));
		
		//best I could manage for now
//		handler.addObject(new Trail((int) calculatePlacementTrailX(), (int) calculatePlacementTrailY(), ID.Trail, Color.white, (int) (width * 0.25), (int) (height * 0.25), 0.03f, handler));
		
		//cool result, very interesting. Not yet working as intended, but still =P
		drawContainer.add(behaviourFactory.createDrawBehaviour(object));
//		handler.addObject(new Trail((int) calculateWavePattern1X(), (int) calculateWavePattern1Y(), ID.Trail, Color.white, (int) (object.getWidth() * 0.1), (int) (object.getHeight() * 0.1), 0.03f, handler));
//		handler.addObject(new Trail((int) calculateWavePattern2X(), (int) calculateWavePattern2Y(), ID.Trail, Color.orange, (int) (width * 0.1), (int) (height * 0.1), 0.03f, handler));
	}
	
	/**
	 * 	formula for getting x and y depending on r, t and h or k
		r = radius length
		t = angle in radians
		h = x position circle center
		k = y position circle center
		http://stackoverflow.com/questions/5300938/calculating-the-position-of-points-in-a-circle
		
		float x = r*cos(t) + h;
		float y = r*sin(t) + k;
	 */
//	protected double calculatePlacementTrailX(){
//		double radians = Math.atan2(velY, velX) + Math.toRadians(180); //rotation depending on graphics formula
//		double radians = Math.atan2(velY, velX); //rotation depending on graphics formula
//		return ((object.getWidth()*0.5)-20)*Math.cos(radians) + object.getCenterObjectX((int) object.getX()); //still no correct positioning but close enough
//	}
	
//	protected double calculatePlacementTrailY(){
//		double radians = Math.atan2(velY, velX) + Math.toRadians(180); //rotation depending on graphics formula
//		double radians = Math.atan2(velY, velX); //rotation depending on graphics formula
//		return ((object.getHeight()*0.5)-20)*Math.sin(radians) + object.getCenterObjectY((int) object.getY()); //still no correct positioning but close enough
//	}
	
	protected double calculateWavePattern1X(){
		return ((object.getWidth()*0.5))*Math.cos(Math.toRadians(angle)) + object.getCenterObjectX((int) object.getX());
	}
	
	protected double calculateWavePattern1Y(){
		return ((object.getHeight()*0.5))*Math.sin(Math.toRadians(angle)) + object.getCenterObjectX((int) object.getY());
	}
	
//	protected double calculateWavePattern2X(){
//		return ((object.getWidth()*0.5))*Math.sin(Math.toRadians(angle2)) + getCenterObjectX(x);
//	}
//	
//	protected double calculateWavePattern2Y(){
//		return ((object.getHeight()*0.5))*Math.cos(Math.toRadians(angle2)) + getCenterObjectX(y);
//	}
}
