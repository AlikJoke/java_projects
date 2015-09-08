package Search;

public class Record {
	
    private final int numb;
    private final String name;
    private final String address;
    
    Record(String name, int numb, String address) {
    	
        this.numb = numb;
        this.name = name;
        this.address = address;
    }
    
    public int getPhone() {
    	
        return numb;
    }
    
    public String getName() {
    	
        return name;
    }
    
    public String getAddress() {
    	
        return address;
    }
    
}