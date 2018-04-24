package br.com.gda.sql;

public final class SqlColumn implements Cloneable {
	public String tableName;
	public String columnName;
	public boolean isPK;
	public boolean isLookUp;
	public boolean isAutoIncremented;
	
	public SqlColumn() {
		this.columnName = null;
		this.isPK = false;
		this.isLookUp = false;
		this.isAutoIncremented = false;
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {		
		return super.clone();
	}
}
