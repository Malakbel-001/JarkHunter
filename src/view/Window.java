package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.Toolkit;

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

		Toolkit tk = Toolkit.getDefaultToolkit();
		int xsize = (int) tk.getScreenSize().getWidth();
		int ysize = (int) tk.getScreenSize().getHeight();
		this.setSize(xsize, ysize);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		
		game.setSize((xsize-menuBar.WIDTH), (ysize-menuBar.HEIGHT));

		game.setPreferredSize(new Dimension(xsize, ysize));
		game.setMaximumSize(new Dimension(xsize, ysize));
		game.setMinimumSize(new Dimension(xsize, ysize));
				
		getContentPane().add(game, BorderLayout.CENTER);
		menuBar = new JPanel();
		menuBar.setPreferredSize(new Dimension(xsize, 50));
		getContentPane().add(menuBar, BorderLayout.SOUTH);

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
