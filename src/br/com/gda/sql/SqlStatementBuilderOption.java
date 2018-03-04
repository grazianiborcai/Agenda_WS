package br.com.gda.sql;

import java.util.ArrayList;
import java.util.List;

public final class SqlStatementBuilderOption {
	public String schemaName;
	public String tableName;
	public String whereClause;
	public List<String> selectColumns = new ArrayList<>();
	public List<String> insertColumns = new ArrayList<>();
	public List<String> updateColumns = new ArrayList<>();
}
