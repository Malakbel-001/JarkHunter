package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.jarkhunt.main.Handler;
import com.jarkhunt.main.ID;

import controller.Game;

public class BasicEnemy extends GameObject {

	private Handler handler;
	BufferedImage image;
	
	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		try
	    {
	      // the line that reads the image file
	      image = ImageIO.read(new File("..//JarkHunter/rocket-md-cropped.png"));
	      // work with the image here ...
	    } 
	    catch (IOException e)
	    {
	      // log the exception
	      // re-throw if desired
	    }
		
		velX = 3;
		velY = 3;
		
//		width = 32;
//		height = 32;
		
		width = 130;
		height = 80;
		
		this.handler = handler;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, width, height);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 60) {
			velY *= -1;
		}
		
		if(x <= 0 || x >= Game.WIDTH - 36) {
			velX *= -1;
		}
//		handler.addObject(new Trail(x, y, ID.Trail, Color.red, width, height, 0.03f, handler));
		//handler.addObject(new Trail(x+(width/4), y+(height/4), ID.Trail, Color.orange, (int) (width * 0.5), (int) (height * 0.5), 0.03f, handler));
	}

	public void render(Graphics g) {
		
		AffineTransform at = new AffineTransform();

        // 4. translate it to the center of the component
        at.translate(image.getWidth() / 2, image.getHeight() / 2);

        // 3. do the actual rotation
        at.rotate(Math.PI/4);
        // 1. translate the object so that you rotate it around the 
        //    center (easier :))
        at.translate(-image.getWidth()/2, -image.getHeight()/2);

        // draw the image
        Graphics2D g2d = (Graphics2D) g;
        //g2d.drawImage(image, at, null);
        g.drawImage(image, x, y, null);
		
//		g.setColor(Color.red);
//		g.fillRect( width, height);
	}
	
}
