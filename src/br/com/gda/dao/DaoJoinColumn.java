package br.com.gda.dao;

public final class DaoJoinColumn implements Cloneable {
	public String leftTableName;
	public String leftColumnName;
	public String rightColumnName;
	public String condition;
	
	
	public DaoJoinColumn() {
		this.condition = DaoDictionary.EQUAL;
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
}
