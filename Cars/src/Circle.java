import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Circle extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Image img = new ImageIcon(getClass().getClassLoader().getResource("image/circle.png")).getImage();
	
	int x;
	int y;
	int vel;
	Road road;
	
	public Circle(int x, int y, int vel, Road road) {
		
		this.x = x;
		this.y = y;
		this.vel = vel;
		this.road = road;
	}
	
	public Rectangle getCircle() {
		
		return new Rectangle(x,y,49,73);
	}
	
	public void move() {
		x = x - road.p.vel + vel;
	}
	
}
