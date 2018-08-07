package br.com.gda.dao;

import java.util.List;

public interface DaoDbTableColumn {
	public List<String> getTableNamesAsList();
	public List<DaoColumn> getTableColumnsAsList(String tableName);
}
