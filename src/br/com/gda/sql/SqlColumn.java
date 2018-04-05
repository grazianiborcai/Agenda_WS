package br.com.gda.sql;

public final class SqlColumn implements Cloneable {
	public String columnName;
	public boolean isPK;
	
	public SqlColumn() {
		this.columnName = null;
		this.isPK = false;
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {		
		return super.clone();
	}
}
