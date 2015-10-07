package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Game;

public class Window extends JFrame {

	private static final long serialVersionUID = -240840600533728354L;
	private final JPanel menuBar;
	public JLabel infoLabel;
	public int score;
	public JLabel UPSCounter;

	public Window(final int width, final int height, final String title, final Game game1) {
		final Game game = game1;
		this.setTitle(title);

		final Toolkit tk = Toolkit.getDefaultToolkit();
		final int xsize = (int) tk.getScreenSize().getWidth();
		final int ysize = (int) tk.getScreenSize().getHeight();
		this.setSize(xsize, ysize);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());

		game.setSize((xsize - ImageObserver.WIDTH), (ysize - ImageObserver.HEIGHT));

		game.setPreferredSize(new Dimension(xsize, ysize));
		game.setMaximumSize(new Dimension(xsize, ysize));
		game.setMinimumSize(new Dimension(xsize, ysize));

		getContentPane().add(game, BorderLayout.CENTER);
		menuBar = new JPanel();
		menuBar.setPreferredSize(new Dimension(xsize, 50));
		getContentPane().add(menuBar, BorderLayout.SOUTH);

		infoLabel = new JLabel("Score: " + score);
		UPSCounter = new JLabel("UPS: 0");
		menuBar.setLayout(new BorderLayout());
		menuBar.add(infoLabel, BorderLayout.WEST);
		menuBar.add(UPSCounter, BorderLayout.EAST);

		this.setVisible(true);
		this.pack();
		game.start();
	}

	public void setScore(final int i) {
		score = i;
	}
}
