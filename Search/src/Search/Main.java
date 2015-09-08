package Search;

import javax.swing.JFrame;


public class Main {
	
    public static void main(String[] args) {
        
    Frame frame = new Frame();
    
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
    	
        @Override
        public void run() {
        	
            JFrame.setDefaultLookAndFeelDecorated(true);
            frame.paint();
        }
    });   
    
	}
}