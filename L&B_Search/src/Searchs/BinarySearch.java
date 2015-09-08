package Searchs;


public class BinarySearch {

	public static int search(int[] a, int key) {
		
		int low = 0;
		int high = a.length - 1;
		
		while(low <= high) {
			
			int mid = (low + high) >>> 1;
			int midValue = a[mid];
			
			if(midValue < key) {
				
				low = mid + 1;
			}	else if(midValue > key) {
				
				high = mid - 1;
			}	else {
				
				return mid;
			}
		}
		
		return -1;
	}
}
