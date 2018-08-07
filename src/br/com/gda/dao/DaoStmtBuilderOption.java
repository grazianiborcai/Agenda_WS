package br.com.gda.dao;

import java.util.ArrayList;
import java.util.List;

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
		ignoreLookUpColumn = false;
		ignoreAutoIncrementedColumn = false;
	}
}
