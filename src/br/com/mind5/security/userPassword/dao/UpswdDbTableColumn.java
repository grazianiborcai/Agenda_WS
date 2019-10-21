package br.com.mind5.security.userPassword.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumnTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class UpswdDbTableColumn extends DaoDbTableColumnTemplate {
	
	public static final String COL_COD_OWNER = "cod_owner";	
	public static final String COL_COD_USER = "cod_user";
	public static final String COL_LAST_CHANGED = "last_changed";
	public static final String COL_PASSWORD = "hash1";
	public static final String COL_SALT = "hash2";
	

	Hashtable<String, List<DaoColumn>> tableColumns;	
	
	public UpswdDbTableColumn() {
		super(UpswdDbTableColumn.class);
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();
		
		buildStoreEmployeeTable();
		
		return tableColumns;
	}
	
	
	
	private void buildStoreEmployeeTable() {
		final String TABLE_NAME = DaoDbTable.USER_PASSWORD_TABLE;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();	
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_OWNER;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_USER;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_PASSWORD;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_SALT;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);		
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_LAST_CHANGED;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}
}
