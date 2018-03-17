package br.com.gda.sql;

import java.util.ArrayList;
import java.util.List;

public final class SqlStmtBuilderOption {
	public String schemaName;
	public String tableName;
	public String whereClause;
	public List<SqlColumn> columns;
	
	
	public SqlStmtBuilderOption() {
		columns = new ArrayList<>();
	}
}
