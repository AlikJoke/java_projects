package Sorts;

public class ShellSort {

	public void sort(int[] a) {
		
		int step = (a.length + 1) / 2;
		
		while(step > 0) {
			
			for(int i = 0; i < a.length - step; i ++) {
				
				for(int j = i; j >= 0 && a[j] > a[j + step]; j --) {
					
					int t = a[j];
					
					a[j] = a[j + step];
					a[j + step] = t;
				}
			}
			
			step = step / 2;  // O(n*n);
		}
	}
}
