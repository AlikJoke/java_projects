package Search;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MyTable extends JPanel {
	
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<Record> list;
	
    public MyTable() {
    	
        super();
        list = new ArrayList<Record>();	
		Treap treap = null;
	
    	HashMap hash = new HashMap();
    	ArrayList<Integer> listKey = new ArrayList<Integer>();
    	
        for(int j = 0; j < 15000; j++) {
        	
        	 Random rand = new Random(); 
             StringBuilder name = new StringBuilder(15);
             
             for(int i = 0; i < 15; i++) { 
            	 
                 char tmp = (char) ('A' + rand.nextInt('z' - 'a')); 
                 name.append(tmp); 
             }
             
             StringBuilder address = new StringBuilder(15);
             
             for(int i = 0; i < 15; i++) { 
            	 
                 char tmp = (char) ('B' + rand.nextInt('z' - 'a')); 
                 address.append(tmp); 
             }
             
             Record rec = new Record(name.toString(), j*127 + 12324, address.toString());
             
             listKey.add(rec.getPhone());
             list.add(rec);
             hash.add(rec);
             treap = Treap.add(treap, rec);
        }
        
        final Treap tr = treap;
        
	    Table_Model model = new Table_Model(list);
	    
	    JTable table = new JTable(model);
	    table.setPreferredScrollableViewportSize(new Dimension(500, 400));
	    table.setFillsViewportHeight(true);
	    table.setAutoCreateRowSorter(true);
	    JScrollPane scrollPane = new JScrollPane(table);
	    add(scrollPane);
	    
	    JButton b1 = new JButton("Search Treap");
	    
	    JButton b2 = new JButton("Search Hash");
	    JTextField t1 = new JTextField(7);
	    	
	    b1.addActionListener(new ActionListener() {
	    	
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		try{
		    		if(Treap.get(tr, Integer.parseInt(t1.getText())) == "") {
		    			
		    			System.out.println("In our book there isn't man with phone: " + t1.getText());
	         			
	         			JOptionPane.showMessageDialog(null, "In our book there isn't man with phone: " + t1.getText());
	         			
	         			t1.setText("");
	    		}
	    		else {
	    			
	    			System.out.println("The name of the man who have a phone: " + t1.getText() + " is " + 
	    					Treap.get(tr, Integer.parseInt(t1.getText())));
		    		
		    		JOptionPane.showMessageDialog(null, "Name of man with the phone: " + t1.getText() + 
	     					" is " + Treap.get(tr, Integer.parseInt(t1.getText())));
		    		
		    		t1.setText("");
	    		}
	    		}
	    		catch (NumberFormatException r) {
	    			
	    			System.out.println("This format of string is wrong!");
	    			JOptionPane.showMessageDialog(null, "This format of string is wrong!");
	    			t1.setText("");
	    		}
	    	}
	    });	
	    	add(b1);
	    	add(t1);
	    	 b2.addActionListener(new ActionListener() {
	         	
	         	@Override
	         	public void actionPerformed(ActionEvent e) {
	         			
	         		try {
	         			
	         		if(hash.get(Integer.parseInt(t1.getText())) == "-1" || 
	         						hash.get(Integer.parseInt(t1.getText())) == "") {
	         			
	         			System.out.println("In our book there isn't man with phone: " + t1.getText());
	         			
	         			JOptionPane.showMessageDialog(null, "In our book there isn't man with phone: " + t1.getText());
	         			
	         			t1.setText("");
	         		}	
	         		else {
	         			
	         			System.out.println("The address of the man who have a phone: " + t1.getText() + " is " + 
	         					hash.get(Integer.parseInt(t1.getText())));
	         			
	         			JOptionPane.showMessageDialog(null, "Address of man with the phone: " + t1.getText() + 
	         					" is " + hash.get(Integer.parseInt(t1.getText())));
	         			
	         			t1.setText("");
	         		}
	         	}
	         	catch (NumberFormatException r) {
	         		
	         		System.out.println("This format of string is wrong!");
	    			JOptionPane.showMessageDialog(null, "This format of string is wrong!");
	    			t1.setText("");
	         	}
	         		
	         }
	        });	
	         	add(b2);
	         	add(t1);
	         	
	         	JButton b3 = new JButton("Add");
	         	JTextField t2 = new JTextField(7);
	         	JTextField t3 = new JTextField(7);
	         	JTextField t4 = new JTextField(7);
	         
	         	b3.addActionListener(new ActionListener() {
		        
		         	@Override
		         	public void actionPerformed(ActionEvent e) {
		         		
		         		try {
		         			if(Integer.parseInt(t3.getText()) <= 0) {
		         				
		         				JOptionPane.showMessageDialog(null, "The phone should have positive number!");
				                t2.setText("");
				                t3.setText("");
				                t4.setText("");
		         			}
		         			else if(listKey.contains(Integer.parseInt(t3.getText()))) {
		         				
		         				JOptionPane.showMessageDialog(null, "The man with this number of phone exist!");
				                t2.setText("");
				                t3.setText("");
				                t4.setText("");
		         			}
		         			else {
		         				
				         		list.add(new Record(t2.getText(), Integer.parseInt(t3.getText()), t4.getText()));
				         		listKey.add(Integer.parseInt(t3.getText()));
				         		model.fireTableDataChanged();
				         		hash.add(new Record(t2.getText(), Integer.parseInt(t3.getText()), t4.getText()));
				         		Treap.add(tr, new Record(t2.getText(), Integer.parseInt(t3.getText()), t4.getText()));
				         		
				                model.fireTableDataChanged();
				                
				                JOptionPane.showMessageDialog(null, "Add " + t2.getText() + " in book with phone: " + 
				                			t3.getText() + " and address " + t4.getText());
				                
				                t2.setText("");
				                t3.setText("");
				                t4.setText("");
				         		}
				         		}
				         		catch (NumberFormatException r) {
				         		
				         		System.out.println("This format of string is wrong!");
				    			JOptionPane.showMessageDialog(null, "This format of string is wrong!");
				    			t2.setText("");
				                t3.setText("");
				                t4.setText("");
				         	}
		         	
		         	}
	         	});	
		         	add(b3);
		         	add(t2);
		         	add(t3);
		         	add(t4);
	         	
		         	JButton b4 = new JButton("Delete");
		         	JTextField t5 = new JTextField(7);
		         	
		         	b4.addActionListener(new ActionListener() {
		         		
			         	@Override
			         	public void actionPerformed(ActionEvent e) {
			         		
			         		try {		         			
			         			
			         			int n = 0;
			         			
			         			if(Integer.parseInt(t5.getText()) <= 0) {
			         				
			         				JOptionPane.showMessageDialog(null, "The phone should have positive number!");
					                t5.setText("");
			         			}
			         			else {
			         			 
			         				if(listKey.contains(Integer.parseInt(t5.getText()))) {
			         					
				         				n = listKey.indexOf(Integer.parseInt(t5.getText()));
										
										list.remove(n);
										model.fireTableDataChanged();
										listKey.remove(n);
										model.fireTableDataChanged();
										hash.remove(Integer.parseInt(t5.getText()));
						         		Treap.remove(tr, Integer.parseInt(t5.getText()));
						         		
						                model.fireTableDataChanged();
						               
						                JOptionPane.showMessageDialog(null, "Delete man from book with phone: " + t5.getText());
						                t5.setText("");
			         				}
			         				else {
			         					
			         					JOptionPane.showMessageDialog(null, "In our book there isn't man with phone: " + t5.getText());
						                t5.setText("");
			         				}
			         			}
			         		}
			         		catch (NumberFormatException r) {
			         		
			         		System.out.println("This format of string is wrong!");
			    			JOptionPane.showMessageDialog(null, "This format of string is wrong!");
			                t5.setText("");
			         	}
			         	
			         }
			        });	
			         	add(b4);
			         	add(t5);
    }
}
