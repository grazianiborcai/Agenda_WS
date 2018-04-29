package br.com.gda.sql;

public final class SqlWhereBuilderOption {
	public boolean isIgnoringNull;
	public boolean isIgnoringRecordMode;
	public boolean isIgnoringNonPrimaryKey;
	
	public SqlWhereBuilderOption() {
		this.isIgnoringNull = true;
		this.isIgnoringRecordMode = false;
		this.isIgnoringNonPrimaryKey = false;
	}
}
