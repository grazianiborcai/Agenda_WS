package br.com.gda.dao;

public final class DaoWhereBuilderOption {
	public static final boolean IGNORE_NULL = true;
	public static final boolean DONT_IGNORE_NULL = false;
	public static final boolean IGNORE_RECORD_MODE = true;
	public static final boolean DONT_IGNORE_RECORD_MODE = false;
	public static final boolean IGNORE_NON_PK = true;
	public static final boolean DONT_IGNORE_NON_PK = false;
	
	public boolean ignoreNull;
	public boolean ignoreRecordMode;
	public boolean ignoreNonPrimaryKey;
	public boolean dummyClauseWhenEmpty;
	
	public DaoWhereBuilderOption() {
		ignoreNull = true;
		ignoreRecordMode = false;
		ignoreNonPrimaryKey = false;
		dummyClauseWhenEmpty = false;
	}
}
