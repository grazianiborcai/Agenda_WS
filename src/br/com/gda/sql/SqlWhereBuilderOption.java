package br.com.gda.sql;

public final class SqlWhereBuilderOption {
	public boolean ignoreNull;
	public boolean ignoreRecordMode;
	public boolean ignoreNonPrimaryKey;
	public boolean dummyClauseWhenEmpty;
	
	public SqlWhereBuilderOption() {
		this.ignoreNull = true;
		this.ignoreRecordMode = false;
		this.ignoreNonPrimaryKey = false;
		this.dummyClauseWhenEmpty = false;
	}
}
