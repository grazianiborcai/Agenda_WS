package br.com.gda.sql;

public final class SqlColumn {
	public String columnName;
	public boolean isPK;
	
	public SqlColumn() {
		this.columnName = null;
		this.isPK = false;
	}
}
