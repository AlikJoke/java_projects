import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Road extends JPanel implements ActionListener, Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Image img = new ImageIcon(getClass().getClassLoader().getResource("image/road.png")).getImage();
	
	Player p = new Player();
	
	Timer mainTimer = new Timer(20, this);
	
	Thread enemiesFactory = new Thread(this);
	
	Thread circlefactory = new Thread(this);
	
	List<Enemy> enemies = new ArrayList<Enemy>();
	
	List<Circle> circle = new ArrayList<Circle>();

	public Road() {
		
		mainTimer.start();
		enemiesFactory.start();
		circlefactory.start();
		addKeyListener(new myKey());
		setFocusable(true);
		
	}
	
	private class myKey extends KeyAdapter{
		
		public void keyPressed(KeyEvent e) {
			
			p.keyPressed(e);
		}
		
		public void keyReleased(KeyEvent e) {
			
			p.keyReleased(e);
			
		}
	}
	
	public void paint(Graphics g) {
		
		g = (Graphics2D) g;
		
		g.drawImage(img, p.layer1, 0, null);
		g.drawImage(img, p.layer2, 0, null);
		g.drawImage(p.img, p.x, p.y, null);
		
		double vel = (200/Player.max_vel)*p.vel;
		g.setColor(Color.RED);
		Font font = new Font("Arial", Font.ITALIC, 20);
		g.setFont(font);
		
		g.drawString("Speed: " + vel + " km/h", 100, 30);
		g.drawString("Score: " + p.s + " m", 100, 580);
		Iterator<Enemy> i = enemies.iterator();
		Iterator<Circle> j = circle.iterator();

		while(j.hasNext()) {
			
			Circle z = j.next();
			if(z.x>=2400 || z.x<=-2400) {
				
				j.remove();
				
			} else {
				z.move();
				g.drawImage(z.img, z.x, z.y, null);
				
			}
			
		}

		while(i.hasNext()) {
			
			Enemy e = i.next();
			if(e.x>=2400 || e.x<=-2400) {
				
				i.remove();
				
			} else {
				
				e.move();
				g.drawImage(e.img, e.x, e.y, null);
				
			}
			
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		p.move();
		repaint();
		testCircle();
		testEnemy();
		testWin();
	}
	
	private void testWin() {
		
		if(p.s > 2000000) {
			JOptionPane.showMessageDialog(null, "Win, lalka!");
			System.exit(0);
		
		}
		
	}

	public void testEnemy() {
		

		Iterator<Enemy> i = enemies.iterator();
		while(i.hasNext()) {
			
			Enemy e = i.next();
			
			if(p.getRect().intersects(e.getRect())) {
				JOptionPane.showMessageDialog(null, "Azazazaza lalka looser!!!");
				
				System.exit(0);
			}
			
			
		}
		
	}
	
	private void testCircle() {
		
		Iterator<Circle> j = circle.iterator();
		
		while(j.hasNext()) {
			
			Circle e = j.next();
			if(p.getRect().intersects(e.getCircle())) {
				
				p.s = p.s + 1000;
			
			if(e.getCircle().intersects(e.getCircle())) {
				
				j.remove();
			
			}
			}
		}
	}
	
	@Override
	public void run() {
		while(true) {
			Random rand = new Random();
			try {
				Thread.sleep(rand.nextInt(3000));
				enemies.add(new Enemy(1200, (rand.nextInt(400)+70), (rand.nextInt(60)+10), this));
				circle.add(new Circle(1200, (rand.nextInt(400)+70), rand.nextInt(1), this));
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
