package Search;

public class HashMap implements MainFunction {
	
    private final static int TABLE_SIZE = 128;

    LinkedHashEntry[] table;

    public HashMap() {
    	
          table = new LinkedHashEntry[TABLE_SIZE];
          
          for (int i = 0; i < TABLE_SIZE; i++) {
        	  
                table[i] = null;
          }
    }
    
    @Override
    public String get(int key) {
    	
          int hash = (key % TABLE_SIZE);
          
          if (table[hash] == null) {
        	  
        	  return "";
          }
          else {
        	  
        	  LinkedHashEntry entry = table[hash];
        	  
              while ((entry != null) && (entry.getKey() != key))
            	  
            	  entry = entry.getNext();
              
              if (entry == null) {
            	  
            	  return "";
              }
              else {
            	  
                  return entry.getValue();
              }
          }
    }
    
    @Override
    public void add(Record rec) {
    	
    	int key = rec.getPhone();
    	String value = rec.getAddress();
        
    	 int hash = (key % TABLE_SIZE);
         
         if (table[hash] == null) {
       	  
       	  	table[hash] = new LinkedHashEntry(key, value);
         }
         else {
       	  
       	  	 LinkedHashEntry entry = table[hash];
             while ((entry.getNext() != null) && (entry.getKey() != key))
           	  
                   entry = entry.getNext();
             
             if (entry.getKey() == key) {
           	  
                   entry.setValue(value);
             }
             else {
           	  
                   entry.setNext(new LinkedHashEntry(key, value));
             }
         }
    }
    @Override
    public void remove(int key) {
    	
          int hash = (key % TABLE_SIZE);
          
          if (table[hash] != null) {
        	  
        	  LinkedHashEntry prevEntry = null;
              LinkedHashEntry entry = table[hash];
              
              while ((entry.getNext() != null) && (entry.getKey() != key)) {
            	  
            	  prevEntry = entry;
                  entry = entry.getNext();
              }
              
              if (entry.getKey() == key) {
            	  
                    if (prevEntry == null) {
                    	
                         table[hash] = entry.getNext();
                    }
                    else {
                    	
                         prevEntry.setNext(entry.getNext());
                    }
              }
          }
    }
}