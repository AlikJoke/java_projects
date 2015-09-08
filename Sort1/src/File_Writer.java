import java.io.FileWriter;
import java.io.IOException;


public class File_Writer {

	public void file_Writer(long[][] table) {
		try 
		{
			FileWriter dr=new FileWriter("file.csv");
			
			for (int i = 0; i < 6; ++i)
			{	
				switch (i) 
				{
						case 0: 
						{
							dr.write(";10000;60000;110000;160000;210000;260000;310000;360000;410000;460000;510000;");
							dr.write("\r\n");
							dr.write("Insert_random;");
							break;
						}
						case 1:
						{
							dr.write("Shell_random;");
							break;
						}
						case 2:
						{
							dr.write("Insert_по_возрастанию;");
							break;
						}
						case 3:
						{
							dr.write("Shell_по_возрастанию;");
							break;
						}
						case 4:
						{
							dr.write("Insert_по_убыванию;");
							break;
						}
						case 5:
						{
							dr.write("Shell_по_убыванию;");
							break;
						}
				}
				
				for(int j=0;j<11;++j)
	  			{
					String s = Long.toString(table[i][j]);
					dr.write(s + ";");
					
				}
				dr.write("\r\n");
				
			}
			dr.close();
			
		}
		catch (IOException e) 
		{
		
				e.printStackTrace();
		}	
	}
}