package Search;

import javax.swing.JFrame;

public class Frame { 
	
    public void paint() {       
    	
        JFrame frame = new JFrame("Name - Number - Address");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        MyTable table = new MyTable();
        table.setOpaque(true);
        
        frame.setContentPane(table);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }            
}