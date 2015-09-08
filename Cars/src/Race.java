import javax.swing.JFrame;



public class Race {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Race");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1100, 650);
		frame.add(new Road());
		frame.setVisible(true);
	}

}
