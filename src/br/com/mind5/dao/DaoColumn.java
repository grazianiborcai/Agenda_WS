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
		return super.clone();
	}
}
