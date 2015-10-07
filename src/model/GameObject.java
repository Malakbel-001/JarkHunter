package model;

import java.awt.Image;

public abstract class GameObject {

	protected double x, y;// can only be used by stuff that extends GameObject
	protected ID id;
	protected int width, height;
	protected Image img;
	protected State state;

	public GameObject(final int x, final int y, final int width, final int height, final ID id) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;
		this.state = State.ALIVE;
	}

	public abstract void remove();

	public double getCenterObjectX(final int x) {
		return x + width * 0.5;
	}

	public double getCenterObjectY(final int y) {
		return y + height * 0.5;
	}

	public void setX(final int x) {
		this.x = x;
	}

	public void setY(final int y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setId(final ID id) {
		this.id = id;
	}

	public ID getId() {
		return id;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setWidth(final int width) {
		this.width = width;
	}

	public void setHeight(final int height) {
		this.height = height;
	}

	public State getState() {
		return state;
	}
}
