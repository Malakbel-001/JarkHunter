package view;

import java.awt.Dimension;

import javax.swing.JFrame;

import controller.Game;

public class Window extends JFrame  {

	private static final long serialVersionUID = -240840600533728354L;
	
	public Window(int width, int height, String title, Game game){
		this.setTitle(title);
		
		this.setPreferredSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(width, height));
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.add(game);
		this.setVisible(true);
		game.start();
	}
}
