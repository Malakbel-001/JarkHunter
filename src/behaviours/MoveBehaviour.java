package behaviours;

import controller.Game;
import model.GameObject;

public class MoveBehaviour extends Behaviour {
	protected int velX, velY;
	protected GameObject object;
	
	public void setVelX(int velX){
		this.velX = velX;
	}
	public void setVelY(int velY){
		this.velY = velY;
	}
	public int getVelX(){
		return velX;
	}
	public int getVelY(){
		return velY;
	}
	
	public void register(final int velX, final int velY, GameObject object) {
		this.velX = velX;
		this.velY = velY;
		this.object = object;
	}
	
	public void update(double delta) {
		this.superUpdate(delta);
	}
	
	protected void superUpdate(double delta) {
		object.setX((int) (object.getX() + velX * delta));
		object.setY((int) (object.getY() + velY * delta));
		
		if(object.getY() <= 0 || object.getY() >= Game.HEIGHT - object.getHeight()*1.5) {
			velY *= -1;
		}
		
		if(object.getX() <= 0 || object.getX() >= Game.WIDTH - object.getWidth()) {
			velX *= -1;
		}
	}
}
