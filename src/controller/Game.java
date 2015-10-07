package controller;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.Random;

import behaviours.BehaviourFactory;
import behaviours.MoveTrailBehaviour;
import model.BasicEnemy;
import model.HUD;
import model.Handler;
import model.ID;
import model.UnitFactory;
import view.Window;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 688707883072222376L;
	
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;
	
	private UnitFactory unitFactory;
	private BehaviourFactory behaviourFactory;
	
	private Handler handler;
	private HUD hud;
	
	public Game(){
		handler = new Handler();
		hud = new HUD();
		this.addMouseListener(new MouseInput(handler));
		
		behaviourFactory = new BehaviourFactory();
		unitFactory = new UnitFactory(handler, behaviourFactory);
		unitFactory.createLevel1(); //change position? TODO

		new Window(WIDTH, HEIGHT, "JarkHunt", this);
	}
	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick(delta);
				delta--;
			}
			if(running){
				if(handler.getInput().size() >0){
					handler.handleInput();
				}
				//check input
				//update aan hand van input				
				render();
			}
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer+= 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick(double delta){
		handler.tick(delta);
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();
		
		g2d.setColor(Color.black);
		g2d.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g2d);
		
		hud.render(g2d);
		
		g2d.dispose();
		bs.show();
	}
	
	public static int clamp(int var, int min, int max){
		if(var >= max){
			return var = max;
		} else if(var <= min){
			return var = min;
		} else {
			return var;
		}
	}
	
	public static void main(String[] args) {
		new Game();
	}
}
