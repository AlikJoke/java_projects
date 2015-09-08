package HashTable;


public class HashMapOpenAddress {

	public class DataItem {
		
		public int key;
		public String value;
		
		public DataItem(int key, String value) {
			
			this.key = key;
			this.value = value;
		}
		
		public int getKey() {
			
			return key;
		}
		
		public String getValue() {
			
			return value;
		}
	}
	
	private DataItem[] table;
	private int table_size;
	private DataItem nonItem;
	
	public HashMapOpenAddress(int size) {
		
		table_size = size;
		table = new DataItem[table_size];
		nonItem = new DataItem(-1, "");
	}
	
	public int hashCode(int key) {
		
		return key % table_size;
	}
	
	public String get(int key) {
		
		int hash = hashCode(key);
		
		while(table[hash] != null) {
			
			if(table[hash].getKey() == key) {
				
				return table[hash].getValue();
			}	
			
			++ hash;
			hash %= table_size;
		}
		
		return "-1";
	}
	
	public void add(int key, String value) {
		
		int hash = hashCode(key);
		
		while(table[hash] != null && table[hash].getKey() != -1) {
			
			++ hash;
			hash %= table_size;
		}
		
		table[hash] = new DataItem(key, value);
		
	}
	
	public void remove(int key) {
		
		int hash = hashCode(key);
		
		while(table[hash] != null) {
			
			if(table[hash].getKey() == key) {
				
				table[hash] = nonItem;
			}
			
			++ hash;
			hash %= table_size;
		}
	}
	
	public static void main(String[] args)	{
		
	
	}
}
