package br.com.mind5.security.storeAuthorization.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumnTemplate;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class StorauthDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_COD_OWNER = DaoDbField.COL_COD_OWNER;
	public static final String COL_COD_STORE = DaoDbField.COL_COD_STORE;
	public static final String COL_COD_USER = DaoDbField.COL_COD_USER;
	public static final String COL_RECORD_MODE = DaoDbField.COL_RECORD_MODE;	
	
	private Hashtable<String, List<DaoColumn>> tableColumns;	
	
	public StorauthDbTableColumn() {
		super(StorauthDbTableColumn.class);
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();		
		buildStoreAuthTable();		
		return tableColumns;
	}
	
	
	
	private void buildStoreAuthTable() {
		final String TABLE_NAME = DaoDbTable.STORE_AUTH_VIEW;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();	
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.OWNER_TABLE;
		oneColumn.columnName = COL_COD_OWNER;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.STORE_TABLE;
		oneColumn.columnName = COL_COD_STORE;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.STORE_TABLE;
		oneColumn.columnName = COL_RECORD_MODE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);	
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.STORE_TABLE;
		oneColumn.columnName = COL_COD_USER;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);

		
		tableColumns.put(TABLE_NAME, columns);
	}
}
