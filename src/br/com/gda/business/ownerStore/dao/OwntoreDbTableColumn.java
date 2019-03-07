package br.com.gda.business.ownerStore.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoDbTableColumnTemplate;
import br.com.gda.dao.common.DaoDbTable;

public final class OwntoreDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_COD_LANGUAGE = "language";
	public static final String COL_COD_OWNER = "cod_owner";
	public static final String COL_COD_STORE = "cod_store";
	public static final String COL_COD_USER = "cod_user";
	public static final String COL_RECORD_MODE = "record_mode";	
	
	private Hashtable<String, List<DaoColumn>> tableColumns;	
	
	public OwntoreDbTableColumn() {
		super();
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();		
		buildOwnerStoreTable();		
		return tableColumns;
	}
	
	
	
	private void buildOwnerStoreTable() {
		final String TABLE_NAME = DaoDbTable.OWNER_STORE_VIEW;
		
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
		oneColumn.tableName = DaoDbTable.LANGUAGE_TABLE;
		oneColumn.columnName = COL_COD_LANGUAGE;
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
