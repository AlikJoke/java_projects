package Search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

class Table_Model extends AbstractTableModel {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Set<TableModelListener> listeners = new HashSet<>();
    private final List<Record> list;
    
    public Table_Model(ArrayList<Record> list) {
    	
    	super();
        this.list = list;
    }
    
    @Override
    public void addTableModelListener(TableModelListener listener) {
    	
        listeners.add(listener);
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
    	
        return getValueAt(0, columnIndex).getClass();
    }
    
    @Override
    public int getColumnCount() {
    	
        return 3;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
    	
        switch (columnIndex) {
        
	        case 0:
	            return "Name";
	        case 1:
	            return "Phone";
	        case 2:
	            return "Address";
        }
        return "";
    }
    
    @Override
    public int getRowCount() {
    	
        return list.size();
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	
        Record user = list.get(rowIndex);
        
        switch (columnIndex) {
        
        case 0:
            return user.getName();
        case 1:
            return user.getPhone();
        case 2:
            return user.getAddress();
        }
        return "";
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
    	
        return false;
    }
    
    @Override
    public void removeTableModelListener(TableModelListener listener) {
    	
        listeners.remove(listener);
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
 
    }
}
