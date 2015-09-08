

public class Insert implements Sorter
{
	@Override
	public void sort(int[] a)
	{
		
		for(int i=1;i<a.length;i++)
		{
			
			for(int j=i;j>0 && a[j-1]<a[j];j--)
			{
				
				int t=a[j-1];
				
				a[j-1]=a[j];
				a[j]=t;
				
			}
		}
	}
}
