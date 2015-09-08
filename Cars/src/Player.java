import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Player extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Image img_c = new ImageIcon(getClass().getClassLoader().getResource("image/Player.png")).getImage();
	Image img_n = new ImageIcon(getClass().getClassLoader().getResource("image/Player_nitro.png")).getImage();
	Image img_r = new ImageIcon(getClass().getClassLoader().getResource("image/Player_Right.png")).getImage();
	Image img_l = new ImageIcon(getClass().getClassLoader().getResource("image/Player_Left.png")).getImage();
	Image img_r_n = new ImageIcon(getClass().getClassLoader().getResource("image/Player_Right_nitro.png")).getImage();
	Image img_l_n = new ImageIcon(getClass().getClassLoader().getResource("image/Player_Left_nitro.png")).getImage();
	Image img = img_c;
	
	public static final int max_vel = 80;
	public static final int max_top = 20;
	public static final int max_bottom = 480;
	
	int vel = 0;
	int acc = 0;
	int s = 0;
	
	int x = 30;
	int y = 100;
	int dy = 0;
	
	int layer1 = 0;
	int layer2 = 1200;
	
	public Rectangle getRect() {
		return new Rectangle(x, y, 155, 50);
	}
	
	public void move() {
		
		s+=vel;
		vel+=acc;
		
		if(vel>=max_vel) vel=max_vel;
		if(vel<=0) vel=0;
		
		y-=dy;
		
		if(y>=max_bottom) y=max_bottom;
		if(y<=max_top) y=max_top;
		
		if(layer2-vel<=0){
			
			layer1 = 0;
			layer2 = 1200;
		} else {
			
			layer1-=vel;
			layer2-=vel;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if(vel == 0 && key == KeyEvent.VK_SPACE) {
			vel = 0;
			acc = 0;
		} else if(vel != 0 && key == KeyEvent.VK_SPACE) {
			acc = 2;
			img = img_n;
		}
	
		
		if(key == KeyEvent.VK_RIGHT) {
			acc = 1;
		}
		
		if(key == KeyEvent.VK_LEFT) {
			acc = -1;
		}	
		
		if(key == KeyEvent.VK_UP) {
			dy = 7;
			img = img_l;
		}
		
		if(key == KeyEvent.VK_DOWN) {
			dy = -7;
			img = img_r;
		}
		
		if(key == KeyEvent.VK_SPACE && key == KeyEvent.VK_UP) {
			img = img_l_n;
			dy = 7;
			acc = 2;
			
		}
		
		if(key == KeyEvent.VK_SPACE && key == KeyEvent.VK_DOWN) {
			img = img_r_n;
			dy = -7;
			acc = 2;
			
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_SPACE) {
			acc = 0;
			img =img_c;
		}
		
		if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT) {
			acc = 0;
		}
		
		if(key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
			dy = 0;
			img = img_c;
		}
		
	}
}
