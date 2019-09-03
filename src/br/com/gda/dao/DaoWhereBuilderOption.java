package br.com.gda.dao;

public final class DaoWhereBuilderOption {
	public static final boolean IGNORE_NULL = true;
	public static final boolean DONT_IGNORE_NULL = false;
	public static final boolean IGNORE_RECORD_MODE = true;
	public static final boolean DONT_IGNORE_RECORD_MODE = false;
	public static final boolean IGNORE_NON_PK = true;
	public static final boolean DONT_IGNORE_NON_PK = false;
	public static final boolean DUMMY_CLAUSE_ALLOWED = true;
	public static final boolean NO_DUMMY_CLAUSE_ALLOWED = false;
	
	public boolean ignoreNull;
	public boolean ignoreRecordMode;
	public boolean ignoreNonPrimaryKey;
	public boolean dummyClauseWhenEmpty;
	
	public DaoWhereBuilderOption() {
		ignoreNull = IGNORE_NULL;
		ignoreRecordMode = DONT_IGNORE_RECORD_MODE;
		ignoreNonPrimaryKey = DONT_IGNORE_NON_PK;
		dummyClauseWhenEmpty = NO_DUMMY_CLAUSE_ALLOWED;
	}
}
