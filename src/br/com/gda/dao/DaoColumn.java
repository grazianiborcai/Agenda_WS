package br.com.gda.dao;

public final class DaoColumn implements Cloneable {
	public String tableName;
	public String columnName;
	public boolean isPK;
	public boolean isLookUp;
	public boolean isAutoIncremented;
	
	public DaoColumn() {
		this.columnName = null;
		this.isPK = false;
		this.isLookUp = false;
		this.isAutoIncremented = false;
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {		
		return super.clone();
	}
}
