package br.com.mind5.dao;

import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoWhereBuilderOption {	
	public boolean ignoreNull;
	public boolean ignoreRecordMode;
	public boolean ignoreNonPrimaryKey;
	public boolean dummyClauseWhenEmpty;
	
	public DaoWhereBuilderOption() {
		ignoreNull = DaoOptionValue.IGNORE_NULL;
		ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		ignoreNonPrimaryKey = DaoOptionValue.DONT_IGNORE_NON_PK;
		dummyClauseWhenEmpty = DaoOptionValue.NO_DUMMY_CLAUSE_ALLOWED;
	}
}
