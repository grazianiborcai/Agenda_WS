package br.com.mind5.dao;

public final class DaoColumn implements Cloneable {
	public String tableName;
	public String columnName;
	public boolean isPK;
	public boolean isLookUp;
	public boolean isAutoIncremented;
	
	public DaoColumn() {
		columnName = null;
		isPK = false;
		isLookUp = false;
		isAutoIncremented = false;
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {	
		DaoColumn copy = new DaoColumn();
		
		copy.tableName = new String(tableName);
		copy.columnName = new String(columnName);
		copy.isPK = isPK;
		copy.isLookUp = isLookUp;
		copy.isAutoIncremented = isAutoIncremented;
		
		return copy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (tableName != null)
			result = result * 31 + tableName.hashCode();
		
		if (columnName != null)
			result = result * 31 + columnName.hashCode();
		
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof DaoColumn))
			return false;
		
		
		DaoColumn obj = (DaoColumn) o;	
		
		return (tableName.equals(obj.tableName)   &&
				columnName.equals(obj.columnName)	 );
	}
}
