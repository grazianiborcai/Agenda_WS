package br.com.gda.sql;

import java.util.List;

public interface SqlDbTableColumn {
	public List<String> getTableNamesAsList();
	public List<SqlColumn> getTableColumnsAsList(String tableName);
}
