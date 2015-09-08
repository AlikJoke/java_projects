package Searchs;


public class LinearSearch {

	public void search(int[] a, int key) {
		
		for(int i = 0; i < a.length; i ++) {
			
			if(a[i] == key) {
				
				System.out.println("Index of " + key + "in massive a[] is " + i);
			}	else {
				
				System.out.println(-1);
			}
		}
	}
}
