package br.com.mind5.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoStmtBuilderOption {
	public String schemaName;
	public String tableName;
	public String whereClause;
	public List<DaoColumn> columns;
	public List<DaoJoin> joins;
	public boolean ignoreLookUpColumn;
	public boolean ignoreAutoIncrementedColumn;
	
	
	public DaoStmtBuilderOption() {
		columns = new ArrayList<>();
		ignoreLookUpColumn = DaoOptionValue.DONT_IGNORE_LOOKUP;
		ignoreAutoIncrementedColumn = DaoOptionValue.DONT_IGNORE_AUTO_INCREMENTED;
	}
}
