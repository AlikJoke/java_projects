package Sorts;

public class SelectionSort {

	public void sort(int[] a) {
		
		int min;
		
		for(int i = 0; i < a.length - 1; i ++) {
			
			min = i;
			for(int j = i + 1; j < a.length; j ++) {
				
				if(a[min] > a[j]) {
					
					min = j;
				}
			}
			
			int t = a[min];
			a[min] = a[i];
			a[i] = t; // O(n*n);
		}
	}
}
