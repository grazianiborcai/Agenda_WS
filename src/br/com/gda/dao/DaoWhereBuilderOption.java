package br.com.gda.dao;

public final class DaoWhereBuilderOption {
	public boolean ignoreNull;
	public boolean ignoreRecordMode;
	public boolean ignoreNonPrimaryKey;
	public boolean dummyClauseWhenEmpty;
	
	public DaoWhereBuilderOption() {
		this.ignoreNull = true;
		this.ignoreRecordMode = false;
		this.ignoreNonPrimaryKey = false;
		this.dummyClauseWhenEmpty = false;
	}
}
