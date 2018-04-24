package br.com.gda.sql;

public final class SqlJoinColumn implements Cloneable {
	public String leftTableName;
	public String leftColumnName;
	public String rightColumnName;
	public String condition;
	
	
	public SqlJoinColumn() {
		this.condition = SqlDictionary.EQUAL;
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
}
