import javax.swing.JFrame;


public class Frame {
	
	public void frame() {
		
		JFrame frame = new JFrame("Java Sort1");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1100, 600);
		frame.add(new Main());
		frame.setVisible(true);	

	}
}
