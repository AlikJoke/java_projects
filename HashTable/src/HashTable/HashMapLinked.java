package HashTable;


public class HashMapLinked {

	public class LinkedHashEntry {
		
		private int key;
		private String value;
		LinkedHashEntry next;
		
		public LinkedHashEntry(int key, String value) {
			
			this.key = key;
			this.value = value;
			this.next = null;
		}
		
		public int getKey() {
			
			return key;
		}
		
		public void setValue(String value) {
			
			this.value = value;
		}
		
		public String getValue() {
			
			return value;
		}
		
		public void setNext(LinkedHashEntry next) {
			
			this.next = next;
		}
		
		public LinkedHashEntry getNext() {
			
			return next;
		}
	}
	
	private static final int TABLE_SIZE = 128;
	LinkedHashEntry[] table;
	
	public HashMapLinked() {
		
		table = new LinkedHashEntry[TABLE_SIZE];
		
		for(int i = 0; i < table.length; i ++) {
			
			table[i] = null;
		}
	}
	
	public void add(int key, String value) {
		
		int hash = key % TABLE_SIZE;
		
		if(table[hash] == null) {
			
			table[hash] = new LinkedHashEntry(key, value);
		}	else {
			
			LinkedHashEntry entry = table[hash];
			
			while(entry.getNext() != null && entry.getKey() != key) 
				
				entry = entry.getNext();
			
			if(entry.getKey() == key) {
				
				entry.setValue(value);
			}	else {
				
				entry.setNext(new LinkedHashEntry(key, value));
			}
		}
	}
	
	public String get(int key) {
		
		int hash = key % TABLE_SIZE;
		
		if(table[hash] == null) {
			
			return "";
		}	else {
			
			LinkedHashEntry entry = table[hash];
			
			while(entry != null && entry.getKey() != key) 
				
				entry = entry.getNext();
			
			if(entry == null) {
				
				return "";
			}	else {
				
				return entry.getValue();
			}
		}
	}
	
	public void remove(int key) {
		
		int hash = key % TABLE_SIZE;
		
		if(table[hash] != null) {
			
			LinkedHashEntry prevEntry = null;
			LinkedHashEntry entry = table[hash];
			
			while(entry.getNext() != null && entry.getKey() != key) {
				
				prevEntry = entry;
				entry = entry.getNext();
			}
			
			if(prevEntry == null) {
				
				table[hash] = entry.getNext();
			}	else {
				
				prevEntry.setNext(entry.getNext());
			}
		}
	}
}
