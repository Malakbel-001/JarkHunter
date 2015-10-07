package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import controller.Game;

public class Window extends JFrame  {

	private static final long serialVersionUID = -240840600533728354L;
	private JPanel menuBar;
	public JLabel infoLabel;
	public int score;
	public JLabel UPSCounter;
		
	public Window(int width, int height, String title, Game game1){
		Game game = game1;
		this.setTitle(title);
		
//		this.setPreferredSize(new Dimension(width, height));
//		this.setMaximumSize(new Dimension(width, height));
//		this.setMinimumSize(new Dimension(width, height));
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		game.setPreferredSize(new Dimension(width, height));
		game.setMaximumSize(new Dimension(width, height));
		game.setMinimumSize(new Dimension(width, height));
				
		this.add(game, BorderLayout.CENTER);
		menuBar = new JPanel();
		this.add(menuBar, BorderLayout.SOUTH);

		infoLabel = new JLabel("Score: "+ score);
		UPSCounter = new JLabel("UPS: 0");
		menuBar.setLayout(new BorderLayout());
		menuBar.add(infoLabel, BorderLayout.WEST);
		menuBar.add(UPSCounter, BorderLayout.EAST);
		
		this.setVisible(true);
		this.pack();
		game.start();
	}
	
	public void setScore(int i){
		score = i;
	}
}
