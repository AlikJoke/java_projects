import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

class Enemy extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Image img = new ImageIcon(getClass().getClassLoader().getResource("image/Enemy.png")).getImage();
	
	int vel;
	int x;
	int y;
	int acc;
	int s;
	Road road;
	
	public Enemy(int x, int y, int vel, Road road) {
		
		this.x = x;
		this.y = y;
		this.vel=vel;
		this.road = road;
		
	}
	
	public Rectangle getRect() {
		return new Rectangle(x, y, 130, 55);
	}
	
	public void move() {
		x = x-road.p.vel + vel;
	}
	
}
