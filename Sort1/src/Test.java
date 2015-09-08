import java.util.Random;


public class Test {
	public long[][] test() {
		
		long table[][]=new long[6][11];
		
		Shell_Sort ob1=new Shell_Sort();
		
		Insert ob2=new Insert();

		int[] size={1000, 6000, 11000, 16000, 21000, 26000, 31000, 36000, 41000, 46000, 51000};
		
		for(int m=0;m<11;m++)
		{
			
			int[] a=new int[size[m]];
			Random rand=new Random();
			
			for(int i=0;i<size[m];i++)
			{
			
				a[i]=rand.nextInt();
				
			}
			
			long start_insert=System.currentTimeMillis();
			ob2.sort(a);
			long end_insert=System.currentTimeMillis();	
			
			table[0][m]=end_insert-start_insert;
			
		
			long start_Shell=System.currentTimeMillis();
			ob1.sort(a);
			long end_Shell=System.currentTimeMillis();
			
			table[1][m]=end_Shell-start_Shell;
			
			end_Shell = 0;
			start_Shell = 0;
			end_insert = 0;
			start_insert = 0;
			
			
			int[] b= new int[size[m]];
			
			for(int i=0;i<size[m];i++) 
			{
				b[i]=i;
			}
			
			start_insert=System.currentTimeMillis();
			ob2.sort(b);
			end_insert=System.currentTimeMillis();	
			
			table[2][m]=end_insert-start_insert;
			
			
			start_Shell=System.currentTimeMillis();
			ob1.sort(b);
			end_Shell=System.currentTimeMillis();
			
			table[3][m]=end_Shell-start_Shell;
			
			end_Shell = 0;
			start_Shell = 0;
			end_insert = 0;
			start_insert = 0;
			
			
			int[] c= new int[size[m]];
			
			for(int i=0;i<size[m];i++) 
			{
				c[i]=size[m]-i;
			}
			
			start_insert=System.currentTimeMillis();
			ob2.sort(b);
			end_insert=System.currentTimeMillis();	
			
			table[4][m]=end_insert-start_insert;
			
			start_Shell=System.currentTimeMillis();
			ob1.sort(b);
			end_Shell=System.currentTimeMillis();
			
			table[5][m]=end_Shell-start_Shell;
			
		}
		return table;
	}
}
