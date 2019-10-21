package br.com.mind5.dao;

import java.util.List;

public interface DaoDbTableColumn {
	public List<String> getTableNamesAsList();
	public List<DaoColumn> getTableColumnsAsList(String tableName);
}
