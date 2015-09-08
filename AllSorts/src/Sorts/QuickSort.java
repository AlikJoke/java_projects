package Sorts;

public class QuickSort {

	public static void sort(int[] a, int l, int r) {
		
		int i = l;
		int j = r;
		int m = a[l + (r - l) / 2];
		
		while(i <= j) {
			
			while(a[i] < m) {
				
				i ++;
			}
			
			while(a[j] > m) {
				
				j --;
			}
			
			if(i <= j) {
				
				int t = a[j];
				a[j] = a[i];
				a[i] = t;
				
				i ++;
				j --;
			}
		}
		
		if(j > l) {
			
			sort(a, l, j);
		}
		
		if(i < r) {
			
			sort(a, i, r); // O(n*log n);
		}
	}
}
