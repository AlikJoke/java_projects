import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Main extends JPanel
{
	static Test test = new Test();
	static long[][] table = test.test();
	
	public void paint(Graphics g)
	{
		int xArray[]={50, 150, 250, 350,450,550,650,750,850,950,1050};
		String array[] = {"10000","60000", "110000", "160000", "210000", "260000", "310000", "360000", "410000", "460000", "51000"};
		g=(Graphics2D) g;
		
		int[] yArray1= new int[11];
		int[] yArray2= new int[11];
		int[] yArray3= new int[11];
		int[] yArray4= new int[11];
		int[] yArray5= new int[11];
		int[] yArray6= new int[11];
		
		g.setColor(Color.black);
		
		g.drawLine(20, 400, 1070, 400);
		g.drawLine(20, 0, 20, 400);
		
		g.drawString("X", 1075, 390 );
		g.drawString("Y", 10, 15 );
		g.drawString("0", 10, 415 );
		
		for(int j=0;j<11;j++) 
		{
			
			g.drawString(array[j], xArray[j], 415);
			yArray1[j] = 395 - ((int) (table[0][j])/1000);
			yArray2[j] = 395 - ((int) (table[1][j])/1000);
			yArray3[j] = 395 - ((int) (table[2][j])/1000);
			yArray4[j] = 395 - ((int) (table[3][j])/1000);
			yArray5[j] = 395 - ((int) (table[4][j])/1000);
			yArray6[j] = 395 - ((int) (table[5][j])/1000);
		}
		
		g.setColor(Color.red);
		g.drawPolyline(xArray, yArray1, 11); // Insert random
		g.drawString("Red-Insert random", 10, 550);
		
		g.setColor(Color.gray);
		g.drawPolyline(xArray, yArray3, 11); // Insert по возрастанию
		g.drawString("Gray-Insert по возрастанию", 10, 570);
		
		g.setColor(Color.green);
		g.drawPolyline(xArray, yArray5, 11); // Insert по убыванию
		g.drawString("Green-Insert по убыванию", 10, 590);
		
		g.setColor(Color.blue);
		g.drawPolyline(xArray, yArray2, 11); // Shell random
		g.drawString("Blue-Shell random", 10, 530);
		
		g.setColor(Color.orange);
		g.drawPolyline(xArray, yArray4, 11); // Shell по возрастанию
		g.drawString("Orange-Shell по возрастанию", 10, 510);
		
		g.setColor(Color.pink);
		g.drawPolyline(xArray, yArray6, 11); // Shell по убыванию
		g.drawString("Pink-Shell по убыванию", 10, 490);
		
	}	
	
	public static void main(String args[])
	{
		
		File_Writer file = new File_Writer();
		file.file_Writer(table);
		
		Frame frame = new Frame();
		frame.frame();

	}	
}
	

