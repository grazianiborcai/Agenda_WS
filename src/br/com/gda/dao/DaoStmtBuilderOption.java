package br.com.gda.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.common.DaoOptionValue;

public final class DaoStmtBuilderOption {
	public String schemaName;
	public String tableName;
	public String whereClause;
	public List<DaoColumn> columns;
	public List<DaoJoin> joins;
	public boolean ignoreLookUpColumn;
	public boolean ignoreAutoIncrementedColumn;
	public boolean lockWrite;
	
	
	public DaoStmtBuilderOption() {
		columns = new ArrayList<>();
		ignoreLookUpColumn = DaoOptionValue.DONT_IGNORE_LOOKUP;
		ignoreAutoIncrementedColumn = DaoOptionValue.DONT_IGNORE_AUTO_INCREMENTED;
		lockWrite = DaoOptionValue.DONT_LOCK_WRITE;
	}
}
